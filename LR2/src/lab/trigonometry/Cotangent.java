package lab.trigonometry;

import lab.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;
import static java.lang.Float.NaN;
import static java.lang.Math.PI;

public class Cotangent extends AbstructFunction {
    {
        table.put(-PI, Double.POSITIVE_INFINITY);
        table.put(-PI / 2, 0.0);
        table.put(0.0, Double.POSITIVE_INFINITY);
        table.put(PI / 2, 0.0);
        table.put(PI, Double.POSITIVE_INFINITY);

        table.put(3 * PI / 4, -1.0);
        table.put(-3 * PI / 4, 1.0);
        table.put( PI / 4, 1.0);
        table.put(-PI / 4, -1.0);
        function = Functions.COTANGENT;
    }

    Tangent tan;

    public Cotangent(double precision) {
        super(precision);
        tan = new Tangent(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        tan.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        if (Math.abs(arg - Math.PI) < DELTA ) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(arg + Math.PI) < DELTA ) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(arg) < DELTA ) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(arg - Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg - 2*Math.PI) < DELTA) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(arg + 2*Math.PI) < DELTA) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(arg - 3*Math.PI/2) < DELTA) {
            return 0d;
        } else if (Math.abs(arg + 3*Math.PI/2) < DELTA) {
            return 0d;
        }
        if( isInfinite(arg) || isNaN(arg) ){
            return NaN;
        }

        return 1 / tan.calc(arg);
    }

    public static void main(String [] args) {
        Sinus sin = new Sinus(0.001);
        Cosinus cos = new Cosinus(0.001);
        Tangent tan = new Tangent(0.001);
        Cotangent cot = new Cotangent(0.001);
        sin.setFuncIsStub(false);
        cos.setFuncIsStub(false);
        tan.setFuncIsStub(false);
        cot.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(cot);
        w.write(-1, 5, 0.01);
    }
}