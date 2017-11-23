package lab.logarithms;

import lab.*;
import static java.lang.Double.*;


public class Log10 extends AbstructFunction {
    {
        table.put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        table.put(10.0 - 0.01, 0.999565488);
        table.put(10.0, 1.0);
        table.put(10.0 + 0.01, 1.000434077);

        table.put(0.0 - 0.01, Double.NaN);
        table.put(0.0, Double.NEGATIVE_INFINITY);
        table.put(0.0 + 0.01, -1.996640695);

        table.put(1.0 - 0.01, -0.004364805);
        table.put(1.0, 0.0);
        table.put(1.0 + 0.01, 0.004321374);

        function = Functions.LOG_10;
    }

    private boolean isStub = true;
    Ln ln;

    public Log10(double precision) {
        super(precision);
        ln = new Ln(precision);
    }

    @Override
    protected double calculate(double x) {
        int base = 10;
        if (Math.abs(x - base) < DELTA)
            return 1d;

        if (Math.abs(base - 1d) < DELTA)
            return 0d;

        if (x == 0.0)
            return NEGATIVE_INFINITY;

        if (x == POSITIVE_INFINITY)
            return POSITIVE_INFINITY;

        return ln.calc(x) / ln.calc(base);
    }

    @Override
    public void setFuncIsStub(boolean funcIsStub) {
        super.setFuncIsStub(funcIsStub);
        this.isStub = funcIsStub;
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        ln.setPrecision(precision);
    }

    public static void main(String [] args) {
        Ln ln = new Ln(0.001);
        Log10 log10 = new Log10(0.001);
        ln.setFuncIsStub(false);
        log10.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(log10);
        w.write(-1, 5, 0.01);
    }
}
