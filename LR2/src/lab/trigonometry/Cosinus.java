package lab.trigonometry;

import lab.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;
import static java.lang.Math.PI;

public class Cosinus extends AbstructFunction{
    {
        table.put(-PI, -1.0);

        table.put(-PI / 2 - 0.01, 0.00999983333);
        table.put(-PI / 2, 0.0);
        table.put(-PI / 2 + 0.01, -0.00999983333);

        table.put(0.0, 1.0);
        table.put(PI / 2, 0.0);
        table.put(PI, -1.0);

        table.put(3 * PI / 4, -0.707106781);
        table.put(-3 * PI / 4, -0.707106781);
        table.put( PI / 4, 0.707106781);
        table.put(-PI / 4, 0.707106781);

        function = Functions.COSINUS;
    }

    Sinus sin;
    public Cosinus(Double precision) {
        super(precision);
        sin = new Sinus(precision);
    }

    @Override
    protected double calculate(double arg) {
        if( Double.isNaN(arg) || Double.isInfinite(arg) ){
            return NaN;
        }
        long periodCounter = (long) (arg / (2 * PI)) + ((arg > 0)? 1: -1);

        if(arg > PI || arg < -PI)
            arg -= periodCounter * 2 * PI;

        double sinVal = sin.calc(arg);
        double res = Math.sqrt(1 - Math.pow(sinVal,2));
        if ((arg > Math.PI/2) || (arg < -Math.PI/2)) {
            res = -res;
        }
        return res;
    }

    public static void main(String [] args) {
        Sinus sin = new Sinus(0.001);
        Cosinus cos = new Cosinus(0.001);
        sin.setFuncIsStub(false);
        cos.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(cos);
        w.write(-5, 5, 0.01);
    }
}