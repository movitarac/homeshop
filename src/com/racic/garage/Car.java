package com.racic.garage;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {
    private int door;
    private int litrePer100km;
    private String motor;
    private List<String> options = new ArrayList<String>();

    public Car(String modelName, String description, String manufacture, int year, String color, int speed, int[] dimensions, int weight) {
        super(modelName, description, manufacture, year, color, speed, dimensions, weight);
    }

    public Car(String modelName, String description, String manufacture, int year, String color, int speed, int[] dimensions, int weight, int door, int litrePer100km, String motor) {
        super(modelName, description, manufacture, year, color, speed, dimensions, weight);
        this.door = door;
        this.litrePer100km = litrePer100km;
        this.motor = motor;
        this.options = options;
    }

    @Override
    public void start() {
        System.out.println("Je suis " + modelName + " je consomme " + litrePer100km + "l au 100km et je démarre !" );
    }

    @Override
    public void stop() {
        System.out.println("Je suis " + modelName + " j'arrête mon moteur " + motor);
    }

    public void startLight(){
        System.out.println("j'allume mes phares");
    }

    public void openTrunk(){
        System.out.println("j'ouvre le coffre");
    }

    public int getDoor() {
        return door;
    }

    public int getLitrePer100km() {
        return litrePer100km;
    }

    public String getMotor() {
        return motor;
    }

    public List<String> getOptions() {
        return options;
    }
}
