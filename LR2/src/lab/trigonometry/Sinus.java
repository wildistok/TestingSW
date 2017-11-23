package lab.trigonometry;

import lab.AbstructFunction;
import lab.CSVWriter;
import lab.Functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.NaN;
import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;
import static java.lang.Math.PI;

public class Sinus extends AbstructFunction {

    {
        table.put(-PI, 0.0);
        table.put(-PI / 2, -1.0);
        table.put(0.0, 0.0);
        table.put(PI / 2, 1.0);
        table.put(PI, 0.0);

        table.put(3 * PI / 4, 0.707106781);
        table.put(-3 * PI / 4, -0.707106781);
        table.put( PI / 4, 0.707106781);
        table.put(-PI / 4, -0.707106781);

        function = Functions.SINUS;
    }

    public Sinus(Double precision) {
        super(precision);
    }

    @Override
    protected double calculate(double arg) {

        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        arg = subOverages(arg);

        int scale = 10;
        double d = getPrecision();

        BigDecimal last;
        BigDecimal value = new BigDecimal(0d, MathContext.UNLIMITED);
        int n = 0;

        do {
            last = value;

            value = value.add((new BigDecimal(-1, MathContext.UNLIMITED).pow(n)).
                    multiply((new BigDecimal(arg, MathContext.UNLIMITED).pow(2 * n + 1))).
                    divide(new BigDecimal(factorial(2 * n + 1)), scale, RoundingMode.HALF_UP));
            n++;
        } while (getPrecision() <= value.subtract(last).abs().doubleValue() && n < MAX_ITERATIONS);

        double valueToDouble = value.setScale(scale, RoundingMode.UP).doubleValue();

        if(valueToDouble > 1) valueToDouble = 1;
        else if(valueToDouble < -1) valueToDouble = -1;
        return valueToDouble;
    }

    protected static double subOverages(double arg) {
        long periodCounter = (long) (arg / (2 * PI)) + ((arg > 0)? 1: -1);

        if(arg > PI || arg < -PI)
            arg -= periodCounter * 2 * PI;
        return arg;
    }

    private static Double factorial(int n) {
        Double ret;
        if (n == 0) {
            return 1.0;
        } else {
            ret = n * factorial(n - 1);
        }
        return ret;
    }

    public static void main(String [] args) {
        CSVWriter w = new CSVWriter(new Sinus(1e-3));
        w.write(-5, 5, 0.01);
    }
}