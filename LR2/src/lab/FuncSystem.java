package lab;

import lab.logarithms.*;
import lab.trigonometry.*;


public class FuncSystem extends AbstructFunction{
    private Double precision;
    private TrigFunc trigFunction;
    private LogFunc logFunction;

    {
        table.put(0.01, -1.2265770593931806);
        table.put(0.0, Double.NaN);
        table.put(-0.01, Double.NaN);

        table.put(1.01, -2.6551978215783334E5);
        table.put(1.0, Double.NaN);
        table.put(0.99, -2.602619746138427E5);
        function = Functions.SYS_FN;
    }

    FuncSystem(Double precision) {
        super(precision);
        this.precision = precision;
        trigFunction = new TrigFunc(precision);
        logFunction = new LogFunc(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        trigFunction.setPrecision(precision);
        logFunction.setPrecision(precision);
    }

    @Override
    public double calculate(double arg){
        if(arg <= 0)
            return trigFunction.calc(arg);
        else
            return logFunction.calc(arg);
    }

    public static void main(String [] args) {
        Ln ln = new Ln(0.001);
        Log3 log3 = new Log3(0.001);
        Log5 log5 = new Log5(0.001);
        Log10 log10 = new Log10(0.001);
        LogFunc logFunc = new LogFunc(0.001);
        ln.setFuncIsStub(false);
        log3.setFuncIsStub(false);
        log5.setFuncIsStub(false);
        log10.setFuncIsStub(false);
        logFunc.setFuncIsStub(false);

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