package com.racic.homeshop.web;

import com.racic.homeshop.Fridge;
import com.racic.homeshop.Product;
import com.racic.homeshop.Television;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        Product cafe1 = new Product("Philips HD123","senseo quadrante",79.90);
        Television tv1 = new Television("TV Samsung 123","Smart TV LED", 599,49,"LED");
        Fridge fridge1 = new Fridge("BEKO TS2", "BEKO CLasse A+",199,130,false);
        products.add(cafe1);
        products.add(tv1);
        products.add(fridge1);
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
}