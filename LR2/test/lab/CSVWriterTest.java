package lab;

import lab.logarithms.*;
import lab.trigonometry.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CSVWriterTest {
    Ln ln; Log3 log3; Log5 log5; Log10 log10; LogFunc logFunc;
    Sinus sin; Cosinus cos; Cosecant csc; Cotangent cot; Tangent tan; Secant sec; TrigFunc trigFunc;
    FuncSystem func;

    @Ignore
    @Before
    public void setUp() {
        ln = new Ln(0.001);
        log3 = new Log3(0.001);
        log5 = new Log5(0.001);
        log10 = new Log10(0.001);
        logFunc = new LogFunc(0.001);
        ln.setFuncIsStub(false);
        log3.setFuncIsStub(false);
        log5.setFuncIsStub(false);
        log10.setFuncIsStub(false);
        logFunc.setFuncIsStub(false);

        sin = new Sinus(0.001);
        cos = new Cosinus(0.001);
        csc = new Cosecant(0.001);
        cot = new Cotangent(0.001);
        tan = new Tangent(0.001);
        sec = new Secant(0.001);
        trigFunc = new TrigFunc(0.001);
        sin.setFuncIsStub(false);
        cos.setFuncIsStub(false);
        csc.setFuncIsStub(false);
        cot.setFuncIsStub(false);
        tan.setFuncIsStub(false);
        sec.setFuncIsStub(false);
        trigFunc.setFuncIsStub(false);

        func = new FuncSystem(0.001);
        func.setFuncIsStub(false);    }

    @Ignore
    @Test
    public void lnCSV(){
        CSVWriter w = new CSVWriter(ln);
        w.write(-1, 5, 0.01);
    }

    @Ignore
    @Test
    public void log3CSV() {
        CSVWriter w = new CSVWriter(log3);
        w.write(-1, 5, 0.01);
    }

    @Ignore
    @Test
    public void log5CSW() {
        CSVWriter w = new CSVWriter(log5);
        w.write(-1, 5, 0.01);
    }

    @Ignore
    @Test
    public void log10CSW() {
        CSVWriter w = new CSVWriter(log10);
        w.write(-1, 5, 0.01);
    }

    @Ignore
    @Test
    public void LogFuncCSW() {
        CSVWriter w = new CSVWriter(logFunc);
        w.write(-1, 5, 0.01);
    }

    @Ignore
    @Test
    public void sinCSW() {
        CSVWriter w = new CSVWriter(sin);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void cosCSW() {
        CSVWriter w = new CSVWriter(cos);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void cscCSW() {
        CSVWriter w = new CSVWriter(csc);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void cotCSW() {
        CSVWriter w = new CSVWriter(cot);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void tanCSW() {
        CSVWriter w = new CSVWriter(tan);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void secCSW() {
        CSVWriter w = new CSVWriter(sec);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void trigFuncCSW() {
        CSVWriter w = new CSVWriter(trigFunc);
        w.write(-5, 5, 0.01);
    }

    @Ignore
    @Test
    public void FuncCSW() {
        CSVWriter w = new CSVWriter(trigFunc);
        w.write(-5, 5, 0.01);
    }

}