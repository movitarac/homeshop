package com.racic.food;

public class Main {

    public static void main(String[] args) {
        Four petitFour = new Four();
        petitFour.capacite = 30;
        petitFour.puissance = 180;

        Four grandFour = new Four();
        grandFour.capacite = 55;
        grandFour.puissance = 260;

        Aliment cake = new Aliment();
        cake.nom = "cake aux fraise";
        cake.estCuit=false;

        Aliment cake2 = new Aliment();
        cake2.nom="cake aux citrons";
        cake2.estCuit=true;

        petitFour.cuire();
        System.out.println("");
        grandFour.cuire();

        petitFour.cuire(cake);
        cake.manger();
        System.out.println("");
        grandFour.cuire(cake2);
        cake2.manger();
    }
}
