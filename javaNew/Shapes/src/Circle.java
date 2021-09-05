public class Circle extends Shapes {
    protected double radius;

    public Circle() {}
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() { return this.radius; }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return (double)(Math.PI * this.radius * this.radius);
    }

    @Override
    public double getPerimeter() {
        return (double)(Math.PI * 2 * this.radius);
    }

    @Override
    public String toString() {
        if (isFilled())
            return "The circle is filled with "+ color +" color";
        return "The circle is not filled";
    }
}
