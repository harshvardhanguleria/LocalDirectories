public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }

    public int getNumerator() { return this.numerator; }
    public int getDenominator() { return this.denominator; }

    @Override
    public String toString() {
        return this.numerator +"/"+ this.denominator;
    }
}
