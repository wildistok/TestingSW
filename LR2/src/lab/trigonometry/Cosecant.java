package lab.trigonometry;

import lab.*;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Math.PI;

public class Cosecant extends AbstructFunction{
    {
        table.put(-PI, POSITIVE_INFINITY);
        table.put(-PI / 2, -1.0);
        table.put(0.0, POSITIVE_INFINITY);
        table.put(PI / 2, 1.0);
        table.put(PI, POSITIVE_INFINITY);

        table.put(3 * PI / 4, 1.41421356375);
        table.put(-3 * PI / 4, -1.41421356375);
        table.put( PI / 4, 1.41421356375);
        table.put(-PI / 4, -1.41421356375);
        function = Functions.COSECANT;
    }

    Sinus sin;

    public Cosecant(double precision) {
        super(precision);
        sin = new Sinus(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        sin.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        if (Math.abs(arg - Math.PI) < DELTA) {
            return POSITIVE_INFINITY;
        }
        if (Math.abs(arg + Math.PI) < DELTA) {
            return POSITIVE_INFINITY;
        }

        if( Double.isNaN(arg) || Double.isInfinite(arg) ){
            return NaN;
        }

        return 1 / sin.calc(arg);
    }

    public static void main(String [] args) {
        Sinus sin = new Sinus(0.001);
        Cosecant csc = new Cosecant(0.001);
        sin.setFuncIsStub(false);
        csc.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(csc);
        w.write(-1, 5, 0.01);
    }
}