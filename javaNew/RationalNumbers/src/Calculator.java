public class Calculator {
    public RationalNumber add(RationalNumber one, 
                RationalNumber two) {
        int num1 = one.getNumerator();
        int denom1 = one.getDenominator();
        int num2 = two.getNumerator();
        int denom2 = two.getDenominator();
        int a = lcm(denom1, denom2);
        try {
            int numerator = (num1 * a)/denom1 + (num2 * a)/denom2;
            int hcf =  gcd(numerator, a);
            return new RationalNumber((int)numerator/hcf, (int)a/hcf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public RationalNumber subtract(RationalNumber one, 
                RationalNumber two) {
        int num1 = one.getNumerator();
        int denom1 = one.getDenominator();
        int num2 = two.getNumerator();
        int denom2 = two.getDenominator();
        int a = lcm(denom1, denom2);
        try {
            int numerator = (num1 * a)/denom1 - (num2 * a)/denom2;
            int hcf =  gcd(numerator, a);
            return new RationalNumber((int)numerator/hcf, (int)a/hcf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public RationalNumber multiply(RationalNumber one, 
                RationalNumber two) {
        int num1 = one.getNumerator();
        int denom1 = one.getDenominator();
        int num2 = two.getNumerator();
        int denom2 = two.getDenominator();
        try {
            RationalNumber result;
            int numerator = num1 * num2;
            int denominator = denom1 * denom2;
            int gcd = gcd(numerator, denominator);
            result = new RationalNumber((int)numerator/gcd,
                                (int)denominator/gcd);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public RationalNumber divide(RationalNumber one, 
                RationalNumber two) {
        int num1 = one.getNumerator();
        int denom1 = one.getDenominator();
        int num2 = two.getNumerator();
        int denom2 = two.getDenominator();
        try {
            RationalNumber result;
            int numerator = num1 * denom2;
            int denominator = num2 * denom1;
            int hcf = gcd(numerator, denominator);
            result = new RationalNumber((int)numerator/hcf,
                                    (int)denominator/hcf);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int compare(RationalNumber one, 
            RationalNumber two) {
        int num1 = one.getNumerator();
        int denom1 = one.getDenominator();
        int num2 = two.getNumerator();
        int denom2 = two.getDenominator();
        try {
            double a = num1 / denom1;
            double b = num2 / denom2;
            if (a > b) 
                return 1;
            else if (a == b)
                return 0;
            else
                return -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -5;
    }

    public double convertToFloatingPoint(RationalNumber num) {
        try {
            return (double) num.getNumerator()/num.getDenominator();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0d;
    }

    public double getAbsoluteValue(RationalNumber num) {
        double abs = convertToFloatingPoint(num);
        if (abs < 0)
            return abs * -1d;
        else if (abs == 0)
            return abs;
        else
            return abs;
    }

    private static int lcm(int one, int two) {
        return (one * two) / gcd(one, two);
    }

    private static int gcd(int one, int two) {
        if (two == 0)
            return one;
        return gcd(two, one%two);
    }
}
