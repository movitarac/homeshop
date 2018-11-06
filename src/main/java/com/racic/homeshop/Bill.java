package com.racic.homeshop;

import java.util.HashMap;
import java.util.Map;

public class Bill {
   private Client client;
   private Map<Product,Integer> products = new HashMap<Product,Integer>();
   private Delivery delivery;

    public Bill(Client client, Delivery delivery) {
        this.client = client;
        this.delivery=delivery;

    }

    /**
     * add a product with a quantity in the bill
     * @param product to add
     * @param quantity of the product
     */
   public void addProduct (Product product, Integer quantity) {
       this.products.put(product,quantity);
   }

    public Client getClient() {

       return client;
    }

    public Map<Product, Integer> getProducts() {

       return products;
    }

    public void generate(Writer writer) {
       if (products.isEmpty())
           throw new NoProductInBillException();
        writer.start();
        writer.writeLine("HomeShop compagnie");
        writer.writeLine("1 Place Charles de Gaulle, 75008 Paris");
        writer.writeLine("");
        writer.writeLine("Facture à l'attention de : ");
        writer.writeLine(client.getFullname());
        writer.writeLine(client.getAddress());
        writer.writeLine("");
        writer.writeLine("Mode de livraison : " + delivery.getInfo());
        writer.writeLine("");
        writer.writeLine("Produits : ");
        writer.writeLine("-----------------------------------------------------");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            writer.writeLine(product.getName() + " - " + product.getPrice() + " - " + quantity + " unité(s)");
            writer.writeLine(product.getDescription());
            writer.writeLine("");
        }
        writer.writeLine("Livraison : " + delivery.getPrice());
        writer.writeLine("-----------------------------------------------------");
        writer.writeLine("Total : " + this.getTotal());
        writer.stop();
    }

    public double getTotal(){
       double total = 0;
       for (Map.Entry<Product,Integer> entry : products.entrySet()){
           Product product = entry.getKey();
           Integer quantity = entry.getValue();
           total += product.getPrice()* quantity;
       }

        return total;
   }

}
