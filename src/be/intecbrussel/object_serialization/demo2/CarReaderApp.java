package be.intecbrussel.object_serialization.demo2;

import be.intecbrussel.object_serialization.demo2.entities.Car;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLOutput;

public class CarReaderApp {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("Car.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            System.out.println("Process deserializing has started...");

            Car copy = (Car) ois.readObject();

            Car copy2 = (Car) ois.readObject();

            System.out.println(copy);
            System.out.println("Brand: " + copy.getBrand());

            System.out.println(copy2);
            System.out.println("Brand: " + copy2.getBrand());

            copy.newFeature();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
