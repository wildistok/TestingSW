package lab.logarithms;

import lab.TestUtil;
import org.junit.Test;

import static lab.AbstructFunction.DELTA;

public class LnTest {
    private final double base = Math.E;
    private double precision = DELTA;
    private TestUtil util = new TestUtil(new Ln(precision));

    @Test
    public void negativeInfinity() {
        util.doCheck(Double.NEGATIVE_INFINITY, precision);
    }

    @Test
    public void positiveInfinity() {
        util.doCheck(Double.POSITIVE_INFINITY, precision);
    }

    @Test
    public void nan() {
        util.doCheck(-1.0, precision);
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

    @Test
    public void ltBase() {
        util.doCheck(base - 0.01, precision);
    }

    @Test
    public void base() {
        util.doCheck(base, precision);
    }

    @Test
    public void gtBase() {
        util.doCheck(base + 0.01, precision);
    }
}