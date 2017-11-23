package lab.trigonometry;

import lab.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import static java.lang.Double.*;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class TrigFunc extends AbstructFunction {
    private double precision;
    Sinus sin;
    Cosinus cos;
    Secant sec;
    Cosecant csc;
    Tangent tan;
    Cotangent cot;

    {
        table.put(0.01, 9.997833741664022E9);
        table.put(0.0, NaN);
        table.put(-0.01, -9.997833741664022E9);

        table.put(PI/2 + 0.01, 0.00010151185);
        table.put(PI/2, 3.352611064517931E-4);
        table.put(PI/2 - 0.01, 0.00009851148);

        table.put(-PI/2 + 0.01, -9.911367264986079E-5);
        table.put(-PI/2, -3.352611064517931E-4);
        table.put(-PI/2 - 0.01, -1.002067797916898E-4);

        table.put(-PI/4 + 0.01, -1.21428934181);
        table.put(-PI/4, -1.12132034356);
        table.put(-PI/4 - 0.01, -1.03699324223);


        table.put(-3*PI/4 + 0.01, -2.92051477454);
        table.put(-3*PI/4, -3.12132034356);
        table.put(-3*PI/4 - 0.01, -3.33797093046);


        table.put(-PI - 0.01, 1.000203053667498E10);
        table.put(-PI, NaN);
        table.put(-PI + 0.01, -1.000203053667498E10);

        function = Functions.TRIG_FN;
    }

    public TrigFunc(double precision) {
        super(precision);
        this.precision = precision;
        csc = new Cosecant(precision);
        sin = new Sinus(precision);
        cos = new Cosinus(precision);
        sec = new Secant(precision);
        tan = new Tangent(precision);
        cot = new Cotangent(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        sin.setPrecision(precision);
        cos.setPrecision(precision);
        sec.setPrecision(precision);
        csc.setPrecision(precision);
        tan.setPrecision(precision);
        cot.setPrecision(precision);
    }

    @Override
    public double calculate(double arg) {
        long periodCounter = (long) (arg / (2 * PI)) + ((arg > 0)? 1: -1);

        if(arg > PI || arg < -PI)
            arg -= periodCounter * 2 * PI;

        if(arg == PI || arg == -PI || arg == 0) {
            return NaN;
        }

        double sinVal = sin.calc(arg);
        double cosVal = cos.calc(arg);
        double secVal = sec.calc(arg);
        double tanVal = tan.calc(arg);
        double cotVal = cot.calc(arg);
        double cscVal = csc.calc(arg);

        double part1 = Math.pow((cotVal/secVal), 2);
        double part2 = sinVal/tanVal;

        if(isNaN(tanVal)) {
            part2 = 0;
        }

        if(isNaN(secVal)) {
            part1 = 0;
        }

        if(isNaN(cscVal)) {
            cscVal = 0;
        }

        if(isNaN(cotVal)) {
            cotVal = 0;
        }


        double res = (part1 - part2) * Math.pow(cscVal, 3) + ((cotVal + cscVal) * cosVal);

        System.out.println(res);

        return res;
    }

    public static void main(String [] args) {
        Sinus sin = new Sinus(0.001);
        Cosinus cos = new Cosinus(0.001);
        Cosecant csc = new Cosecant(0.001);
        Cotangent cot = new Cotangent(0.001);
        Tangent tan = new Tangent(0.001);
        Secant sec = new Secant(0.001);
        TrigFunc trigFunc = new TrigFunc(0.001);
        sin.setFuncIsStub(false);
        cos.setFuncIsStub(false);
        csc.setFuncIsStub(false);
        cot.setFuncIsStub(false);
        tan.setFuncIsStub(false);
        sec.setFuncIsStub(false);
        trigFunc.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(trigFunc);
        w.write(-5, 5, 0.01);
    }
}