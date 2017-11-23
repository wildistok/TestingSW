package lab.trigonometry;

import lab.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;
import static java.lang.Math.PI;


public class Tangent extends AbstructFunction {

    {
        table.put(-PI - 0.01, 0.009999601002664633);
        table.put(-PI, 0.0);
        table.put(-PI + 0.01, -0.009999601002664633);

        table.put(-PI / 2, NaN);
        table.put(0.0, 0.0);
        table.put(PI / 2, NaN);
        table.put(PI, 0.0);
        table.put(PI, 0.0);

        table.put(3 * PI / 4, -1.0);
        table.put(-3 * PI / 4, 1.0);
        table.put( PI / 4, 1.0);
        table.put(-PI / 4, -1.0);

        function = Functions.TANGENT;
    }

    Cosinus cos;
    double tan;

    public Tangent(double precision) {
        super(precision);
        cos = new Cosinus(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        cos.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
//        if (Math.abs(arg - Math.PI) < getPrecision() ) {
//            return 0d;
//        } else if (Math.abs(arg + Math.PI) < getPrecision() ) {
//            return 0d;
//        } else if (Math.abs(arg) < getPrecision() ) {
//            return 0d;
//        } else if (Math.abs(arg - Math.PI/2) < getPrecision()) {
//            return NaN;
//        } else if (Math.abs(arg + Math.PI/2) < getPrecision()) {
//            return NaN;
//        } else if (Math.abs(arg - 2*Math.PI) < getPrecision()) {
//            return 0d;
//        } else if (Math.abs(arg + 2*Math.PI) < getPrecision()) {
//            return 0d;
//        } else if (Math.abs(arg - 3*Math.PI/2) < getPrecision()) {
//            return NaN;
//        } else if (Math.abs(arg + 3*Math.PI/2) < getPrecision()) {
//            return NaN;
//        }

        arg = subOverages(arg);

        double cosVal = cos.calc(arg);
        tan = Math.sqrt(1 / Math.pow(cosVal, 2) - 1);

        if(arg > -PI / 2 && arg < 0 || arg > PI / 2 && arg < PI)
            tan = -tan;

        if(isInfinite(arg) || isNaN(arg) || isInfinite(tan)){
            return NaN;
        }

        if(arg == PI/2 || arg == -PI/2)
            return NaN;

        return tan;
    }

    protected static double subOverages(double arg) {
        long periodCounter = (long) (arg / PI) + ((arg > 0)? 1: -1);

        if(arg > PI / 2 || arg < -PI / 2)
            arg -= periodCounter * PI;
        return arg;
    }

    public static void main(String [] args) {
        Sinus sin = new Sinus(0.001);
        Cosinus cos = new Cosinus(0.001);
        Tangent tan = new Tangent(0.001);
        sin.setFuncIsStub(false);
        cos.setFuncIsStub(false);
        tan.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(tan);
        w.write(-1, 5, 0.01);
    }
}