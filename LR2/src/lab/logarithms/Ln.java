package lab.logarithms;

import lab.*;
import static java.lang.Double.*;

public class Ln extends AbstructFunction {
    {
        table.put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        table.put(NEGATIVE_INFINITY, NaN);

        table.put(Math.E - 0.01, 0.996314422);
        table.put(Math.E, 1.0);
        table.put(Math.E + 0.01, 1.003672044);

        table.put(0.0 - 0.01, Double.NaN);
        table.put(0.0, Double.NEGATIVE_INFINITY);
        table.put(0.0 + 0.01, -4.597299250);

        table.put(1.0 - 0.01, -0.010050000);
        table.put(1.0, 0.0);
        table.put(1.0 + 0.01, 0.009950000);

        function = Functions.LN;
    }

    public Ln(double acc) {
        super(acc);
    }

    @Override
    protected double calculate(double x) {
        if (x < 0.0)
            return NaN;

        if (x == POSITIVE_INFINITY)
            return POSITIVE_INFINITY;

        if (x == 0.0)
            return NEGATIVE_INFINITY;


        double value = 0;
        double prevValue;
        int n = 1;
        int k = 1;
        if (Math.abs(x - 1) <= 1) {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, n) * Math.pow(x - 1, n)) / n);
                n++;
            } while (getPrecision() <= Math.abs(value - prevValue) && n < MAX_ITERATIONS);
        } else {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, k) * Math.pow(x - 1, -k)) / k);
                k++;
            } while (getPrecision() <= Math.abs(value - prevValue) && k < MAX_ITERATIONS);
            value += calc(x - 1);
        }
        return value;
    }

    public static void main(String [] args) {
        CSVWriter w = new CSVWriter(new Ln(1e-3));
        w.write(-1, 5, 0.01);
    }
}