package com.racic.garage;

public abstract class Vehicle {
    protected String modelName;
    private String description;
    private String manufacture;
    private int year;
    private String color;
    private int speed;
    private int[] dimensions = new int[3];
    private int weight;


    public Vehicle(String modelName, String description, String manufacture, int year, String color, int speed, int[] dimensions, int weight) {
        this.modelName = modelName;
        this.description = description;
        this.manufacture = manufacture;
        this.year = year;
        this.color = color;
        this.speed = speed;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public abstract void start();
    /*{
       System.out.println("je suis " +modelName + " et je demarre");
    }*/

    public abstract void stop();
    /*{
        System.out.println("je suis " +modelName + " et je m'arrete");
    }*/

    public String getModelName() {
        return modelName;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public int getWeight() {
        return weight;
    }
}
