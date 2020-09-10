package be.intecbrussel.object_serialization.demo2;

import be.intecbrussel.object_serialization.demo2.entities.Car;
import be.intecbrussel.object_serialization.demo2.entities.Jeep;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CarWriterApp {

    public static void main(String[] args) {

        try (FileOutputStream fos = new FileOutputStream("Car.ser");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {

            System.out.println("Starting process...");

            Car toyota = new Car("Toyota AE86", 1000, 1.5);
            out.writeObject(toyota);

            Car toyota2 = new Car("Toyota ZZ86", 1000, 1.5);
            out.writeObject(toyota2);

            Jeep jeep = new Jeep("Jeep", 1900, 1.8);
            out.writeObject(jeep);

            System.out.println("Process is finished!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
