public class Rectangle extends Shapes {
    protected double width;
    protected double length;

    public Rectangle() {}
    public Rectangle(double width, double length) {
        super();
        this.width = width;
    }
    public Rectangle(double width, double length, String color, 
            boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() { return this.width; }
    public double getLength() { return this.length; }

    public void setWidth(double width) {
        this.width = width;
    }
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return (double)(2 * (this.length + this.width));
    }

    @Override
    public String toString() {
        if (isFilled() && getLength() != getWidth())
            return "The rectangle is filled with "+ color +" color";
        return "The rectangle is not filled";
    }
}
