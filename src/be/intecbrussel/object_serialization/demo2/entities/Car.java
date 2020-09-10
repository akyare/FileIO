package be.intecbrussel.object_serialization.demo2.entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Car implements Serializable {

    private static final int NUMB_OF_WHEELS = 4;

    private transient Bug bug = new Bug();

    protected String brand;
    protected double weight;
    protected double height;

    public Car( String brand, double weight, double height) {
        this.brand = brand;
        this.weight = weight;
        this.height = height;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public static int getNumbOfWheels() {
        return NUMB_OF_WHEELS;
    }

    public void newFeature() {
        System.out.println(bug.getCause());
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        bug = new Bug(); // transient variable to initialize again, avoid exception
    }

    @Override
    public String toString() {
        return "Car{" +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
