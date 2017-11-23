package lab;

import lab.logarithms.*;
import lab.trigonometry.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static lab.AbstructFunction.DELTA;

public class FuncLvlOneTest {
    private double precision = DELTA;
    private TestUtil util = new TestUtil(new FuncSystem(precision));

    @Before
    public void setUp(){
        Cosinus cos = new Cosinus(precision);
        cos.setFuncIsStub(false);
        Secant sec = new Secant(precision);
        sec.setFuncIsStub(false);
        Tangent tan = new Tangent(precision);
        tan.setFuncIsStub(false);
        Cotangent cot = new Cotangent(precision);
        cot.setFuncIsStub(false);

        Ln ln = new Ln(DELTA);
        ln.setFuncIsStub(false);
        Log3 log3 = new Log3(DELTA);
        log3.setFuncIsStub(false);
        Log10 log10 = new Log10(DELTA);
        log10.setFuncIsStub(false);

    }

    @Test
    public void negativeInfinity(){
        util.doCheck(Double.NEGATIVE_INFINITY, precision);
    }

    @Test
    public void positiveInfinity(){
        util.doCheck(Double.POSITIVE_INFINITY, precision);
    }

    @Test
    public void nan(){
        util.doCheck(0, precision);
    }

    @Test
    public void zero() {
        util.doCheck(0.0, precision);
    }

    @Test
    public void gtZero() {
        util.doCheck(0.01, precision);
    }

    @Test
    public void ltOne() {
        util.doCheck(1 - 0.01, 1000);
    }

    @Test
    public void one() {
        util.doCheck(1.0, precision);
    }

    @Test
    public void gtOne() {
        util.doCheck(1.0 + 0.01, 1000);
    }

}