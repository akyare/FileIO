package be.intecbrussel.decorator_pattern;

public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setReadBorder();
    }

    private void setReadBorder() {
        System.out.println("Border Color is: Red");
    }


}
