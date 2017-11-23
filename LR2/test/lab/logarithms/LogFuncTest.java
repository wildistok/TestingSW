package lab.logarithms;

import lab.TestUtil;
import org.junit.Before;
import org.junit.Test;

import static lab.AbstructFunction.DELTA;

public class LogFuncTest {
    private double precision = DELTA;
    private TestUtil util = new TestUtil(new LogFunc(precision));

    @Before
    public void setUp(){
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
        util.doCheck(-1, precision);
    }

    @Test
    public void ltZero() {
        util.doCheck(-0.01, precision);
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
        util.doCheck(1 - 0.01, precision);
    }

    @Test
    public void one() {
        util.doCheck(1.0, precision);
    }

    @Test
    public void gtOne() {
        util.doCheck(1.0 + 0.01, precision);
    }

}