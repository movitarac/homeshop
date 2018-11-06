package com.racic.paris;

public class Taxi implements MoyenDeLocomotion {
    @Override
    public void deplace(String adresse) {
        System.out.println("je suis taxi bus et je vais a l'adresse: " + adresse);
    }
}
