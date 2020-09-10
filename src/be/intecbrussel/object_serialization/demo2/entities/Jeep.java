package be.intecbrussel.object_serialization.demo2.entities;

public class Jeep extends Car{

    private final boolean bullbar = true;


    public Jeep(String brand, double weight, double height) {
        super(brand, weight, height);
    }

    @Override
    public String toString() {
        return "Jeep{" +
                "bullbar=" + bullbar +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
