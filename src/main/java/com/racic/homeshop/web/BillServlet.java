package com.racic.homeshop.web;

import com.racic.homeshop.*;
import com.racic.homeshop.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

public class BillServlet extends HttpServlet {

    List<Product> products = new ArrayList<Product>();
    /**
     * generer la liste de produits disponibles dans notre catalogue
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        //super.init();

        /*Product cafe1 = new Product("Philips HD123","senseo quadrante",79.90);
        Television tv1 = new Television("TV Samsung 123","Smart TV LED", 599,49,"LED");
        Fridge fridge1 = new Fridge("BEKO TS2", "BEKO CLasse A+",199,130,false);
        products.add(cafe1);
        products.add(tv1);
        products.add(fridge1);
        */
        products = new ProductDAO().getAll();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getQueryString() == null)
            displayForm(resp);
        else
            displayBill(req, resp);
    }

    private void displayBill(HttpServletRequest req, HttpServletResponse resp) {
        //on recupere les params a partir de req
        Map<String, String> params = splitParameters(req.getQueryString());
        //on cree un client
        Client client = new Client(params.get("fullname"), params.get("address"));
        //on cree la partie delivery
        Delivery delivery = null;
        switch (params.get("deliveryMode")){
            case "direct":
                delivery = new DirectDelivery();
                break;
            case "express" :
                delivery = new ExpressDelivery(params.get("deliveryInfo"));
                break;
            case "relay" :
                delivery = new RelayDelivery(Integer.parseInt(params.get("deliveryInfo")));
                break;
            case "takeAway" :
                delivery = new TakeAwayDelivery();
                break;
        }
        Bill bill = new Bill(client,delivery);
        String[] productParams = params.get("products").split("%0D%0A");
        for (String productLine : productParams) {

            String[] productAndQuantity = productLine.split("%3A");
            //on recupere le produit
            Product product = products.get(Integer.parseInt(productAndQuantity[0]));
            //on recupere la quantite
            Integer quantity = Integer.parseInt(productAndQuantity[1]);
          //on rajoute dans la facture
            bill.addProduct(product, quantity);
        }
        //on genere la facture avec writer
        bill.generate(new Writer() {
            @Override
            public void start() {

            }

            @Override
            public void writeLine(String line) {
                try {
                    resp.getWriter().println("<br/>" + line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void stop() {

            }
        });
    }



    //on veut afficher la liste de produits

    private void displayForm(HttpServletResponse resp) throws IOException {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            resp.getWriter().println(
                    "<b>" + i + " - " + product.getName() + "</b> : " + product.getPrice() + "<br/>" +
                            product.getDescription() + "<br/><br/>");
        }
        String form = "<form action=\"bill\">" +
                "<b>nom complet :</b> <input name=\"fullname\"/><br/>" +
                "<b>adresse :</b> <input name=\"address\"/><br/><br/>" +
                "<b>livraison :</b> <br/>" +
                "à domicile : <input type=\"radio\" name=\"deliveryMode\" value=\"direct\"/><br/>" +
                "express : <input type=\"radio\" name=\"deliveryMode\" value=\"express\"/><br/>" +
                "point relais : <input type=\"radio\" name=\"deliveryMode\" value=\"relay\"/><br/>" +
                "à retirer : <input type=\"radio\" name=\"deliveryMode\" value=\"takeAway\"/><br/>" +
                "<b>Informations livraison</b> (relay et express) : <input name=\"deliveryInfo\"/><br/><br/>" +
                "<b>liste produits </b> (produit:quantité, un produit par ligne) : <br/>" +
                "<textarea name=\"products\"></textarea><br/>" +
                "<input type=\"submit\"/>" +
                "</form>";
        resp.getWriter().println(form);
    }

    //parametres valeurs
    public Map<String,String> splitParameters(String queryString){
        //on separe la chaine de caractere qui est separe par &
    String[] brutParams = queryString.split("&");
    //on cree un map retourne qui sera rempli
     Map<String,String> params = new HashMap<>();
        for (String brutParam:brutParams ) {
            //on split sur ==
            String[] keyAndValue = brutParam.split("=");
            if (keyAndValue.length ==2)
                params.put(keyAndValue[0],keyAndValue[1]);
        }
        return params;
    }
}