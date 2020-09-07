package be.intecbrussel.factoryPattern;

public class App {

    // Example of design factory pattern which is used by class or interface Path, Paths
    // Path will create the object based on the OS
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("circle");
        circle.draw();


    }
}
