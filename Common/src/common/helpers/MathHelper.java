package common.helpers;

public class MathHelper extends CommonHelper {

    public static final double E = 2.71;
    public static final double PI = 3.14;

    public static int square(int val)
    {
        return val * val;
    }

    public static double CircleArea(double radius) {
        return PI*radius*radius;
    }

    public static double Circumference(double radius) {
        return 2*PI*radius;
    }

    public static double PercentOf(double input, double portionOfInput) {
        return ((input-portionOfInput)/input)*100;
    }

}
