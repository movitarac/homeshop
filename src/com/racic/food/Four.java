package com.racic.food;

public class Four {
    private int puissance;
    private int capacite;
    Aliment aliment;
    private Resistance resistance;
    private Soufflerie soufflerie;

    public void cuire() {
        System.out.println("Je cuis un aliment");
        System.out.println("avec ma capacité de " + capacite + " litres");
        System.out.println("et ma puissance de " + puissance + " degrés.");
    }

    public void cuire(Aliment aliment) {
        System.out.println("Je cuis un " + aliment.nom);
        System.out.println("avec ma capacité de " + capacite + " litres");
        System.out.println("et ma puissance de " + puissance + " degrés.");
    }


    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        System.out.println("puissance est modifiee");
        this.puissance = puissance;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Aliment getAliment() {
        return aliment;
    }

    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    public Resistance getResistance() {
        return resistance;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    public Soufflerie getSoufflerie() {
        return soufflerie;
    }

    public void setSoufflerie(Soufflerie soufflerie) {
        this.soufflerie = soufflerie;
    }





}
