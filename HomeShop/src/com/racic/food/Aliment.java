package com.racic.food;

public class Aliment {
    String nom;
    boolean estCuit;

    public void manger() {
        if (estCuit) {
            System.out.println("miam miam, " + nom + " est bien cuit!" );
        } else {
            System.out.println("beeeurk " + nom + " est cru!");
        }
    }

}
