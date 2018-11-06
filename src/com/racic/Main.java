package com.racic;

import com.racic.garage.Car;
import com.racic.homeshop.*;
import com.racic.paris.*;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        /*Car car1 = new Car("clio iii", "renault clio gris", "renault", 2005, "gris", 225, new int[]{4032, 1720, 1497},
                1240, 5, 5, "motor name");

        car1.getDoor();
        */


        Product cafe1 = new Product("Philips HD123","senseo quadrante",79.90);
        Television tv1 = new Television("TV Samsung 123","Smart TV LED", 599,49,"LED");
        Fridge fridge1 = new Fridge("BEKO TS2", "BEKO CLasse A+",199,130,false);
        Client c1 = new Client("George Lukas", "151 Rue Carnot,Paris");




        Bill bill1 = new Bill(c1, new RelayDelivery(27) );
       /*
        bill1.addProduct(cafe1,1);
        bill1.addProduct(tv1,1);
        bill1.addProduct(fridge1,1);
        */
        //bill1.generate(new FileWriter("facture lukas"));
        try {
            bill1.generate(new Writer() {
                @Override
                public void start() {

                }

                @Override
                public void writeLine(String line) {
                    System.out.println(line);
                }

                @Override
                public void stop() {

                }
            });
        } catch (NoProductInBillException e) {
            System.err.println("Pas de produit dans la facture");
        }
  //      Parisien segolene = new Parisien();
    //    Bus bus = new Bus();
      //  Taxi taxi = new Taxi();
        //segolene.seDeplacer(bus);
    }
}
