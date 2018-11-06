package com.racic.food;

public class Mainfood {

    public static void main(String[] args) {
        Four petitFour = new Four();
        petitFour.setCapacite(30);
        petitFour.setPuissance(180);
        petitFour.cuire1(30,15);

        Four grandFour = new Four();
        grandFour.setCapacite(55);
        grandFour.setPuissance(260);
        //grandFour.soufflerie = null;
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
