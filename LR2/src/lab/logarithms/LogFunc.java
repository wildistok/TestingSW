package lab.logarithms;

import lab.*;
import lab.trigonometry.TrigFunc;
import org.junit.Test;

public class LogFunc extends AbstructFunction {
    private double precision;
    Ln ln;
    Log3 log3;
    Log5 log5;
    Log10 log10;

    {
        table.put(0.01, -1.226577058);
        table.put(0.99, -260255.807955049);
        table.put(1.01, -265513.368278378);

        function = Functions.LOG_FN;
    }

    public LogFunc(double precision) {
        super(precision);
        this.precision = precision;
        ln = new Ln(precision);
        log3 = new Log3(precision);
        log5 = new Log5(precision);
        log10 = new Log10(precision);
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        ln.setPrecision(precision);
        log3.setPrecision(precision);
        log5.setPrecision(precision);
        log10.setPrecision(precision);
    }

    @Override
    public double calculate(double x) {
        return ((Math.pow((ln.calc(x) - log3.calc(x)), 3) * log10.calc(x)) - (log3.calc(x) / (ln.calc(x) - log3.calc(x)))) / (log5.calc(x) * log5.calc(x));
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
        CSVWriter w = new CSVWriter(logFunc);
        w.write(-1, 5, 0.01);
    }
}