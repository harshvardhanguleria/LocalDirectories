public abstract class Shapes {
    protected String color;
    protected boolean filled;

    public Shapes() {}
    public Shapes(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String color() { return this.color; }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() { return this.filled; }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}
