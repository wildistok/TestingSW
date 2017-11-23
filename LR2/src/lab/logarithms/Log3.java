package lab.logarithms;

import lab.*;
import static java.lang.Double.*;


public class Log3 extends AbstructFunction {
    {
        table.put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        table.put(3.0 - 0.01, 0.996960801);
        table.put(3.0, 1.0);
        table.put(3.0 + 0.01, 1.003029085);

        table.put(0.0 - 0.01, Double.NaN);
        table.put(0.0, Double.NEGATIVE_INFINITY);
        table.put(0.0 + 0.01, -4.184948602);

        table.put(1.0 - 0.01, -0.009148209);
        table.put(1.0, 0.0);
        table.put(1.0 + 0.01, 0.009057181);

        function = Functions.LOG_3;
    }

    private boolean isStub = true;
    Ln ln;

    public Log3(double precision) {
        super(precision);
        ln = new Ln(precision);
    }

    @Override
    protected double calculate(double x) {
        int base = 3;
        if (Math.abs(x - base) < DELTA)
            return 1d;

        if (Math.abs(base - 1d) < DELTA)
            return 0d;

        if (x == 0.0)
            return NEGATIVE_INFINITY;

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
        Log3 log3 = new Log3(0.001);
        ln.setFuncIsStub(false);
        log3.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(log3);
        w.write(-1, 5, 0.01);
    }
}
