public class Square extends Rectangle {

    public Square() {}
    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() { return this.length; }
    public void setSide(double side) {
        this.length = this.width = side;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        if (isFilled())
            return "The square is filled with "+ color +" color";
        return "The square is not filled";
    }
}
