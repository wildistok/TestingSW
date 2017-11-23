package lab.trigonometry;

 import lab.*;

 import java.math.BigDecimal;
 import java.math.MathContext;
 import java.math.RoundingMode;

 import static java.lang.Double.NaN;
 import static java.lang.Double.POSITIVE_INFINITY;
 import static java.lang.Math.PI;

public class Secant extends AbstructFunction{
    {
//        table.put(-PI, -1.0000001352604628);
        table.put(-PI, -1.0);
        table.put(-PI / 2, POSITIVE_INFINITY);
        table.put(0.0, 1.0);
        table.put(PI / 2, POSITIVE_INFINITY);
//        table.put(PI, -1.0000001352604628);
        table.put(PI, -1.0);

        table.put(3 * PI / 4, -1.41421356375);
        table.put(-3 * PI / 4, -1.41421356375);
        table.put( PI / 4, 1.41421356375);
        table.put(-PI / 4, 1.41421356375);
        function = Functions.SECANT;
    }

    Cosinus cos;

    public Secant(double precision) {
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
        if (Math.abs(arg - Math.PI/2) < DELTA) {
            return POSITIVE_INFINITY;
        }
        if (Math.abs(arg + Math.PI/2) < DELTA) {
            return POSITIVE_INFINITY;
        }

        if( Double.isNaN(arg) || Double.isInfinite(arg) ){
            return NaN;
        }

        return 1 / cos.calc(arg);
    }

    public static void main(String [] args) {
        Sinus sin = new Sinus(0.001);
        Cosinus cos = new Cosinus(0.001);
        Secant sec = new Secant(0.001);
        sin.setFuncIsStub(false);
        cos.setFuncIsStub(false);
        sec.setFuncIsStub(false);
        CSVWriter w = new CSVWriter(sec);
        w.write(-5, 5, 0.01);
    }
}