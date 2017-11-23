package lab.trigonometry;

import lab.TestUtil;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.PI;
import static lab.AbstructFunction.DELTA;
import static org.junit.Assert.*;


public class TrigFuncTest {
    private double precision = DELTA;
    private TestUtil util = new TestUtil(new TrigFunc(precision));

    @Before
    public void setUp() throws Exception {
        Sinus sin = new Sinus(precision);
        sin.setFuncIsStub(false);
        Cosinus cos = new Cosinus(precision);
        cos.setFuncIsStub(false);
        Secant sec = new Secant(precision);
        sec.setFuncIsStub(false);
        Cosecant csc = new Cosecant(precision);
        csc.setFuncIsStub(false);
        Tangent tan = new Tangent(precision);
        tan.setFuncIsStub(false);
        Cotangent cot = new Cotangent(precision);
        cot.setFuncIsStub(false);
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
        util.doCheck(Double.NaN, precision);
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
    public void gtFirstExtrema() {
        util.doCheck(PI/2 + 0.01, precision);
    }

    @Test
    public void firstExtrema() {
        util.doCheck(PI/2, precision);
    }

    @Test
    public void ltFirstExtrema() {
        util.doCheck(PI/2 - 0.01, precision);
    }

    @Test
    public void gtSecondExtrema() {
        util.doCheck(-PI/2 + 0.01, precision);
    }


    @Test
    public void secondExtrema() {
        util.doCheck(-PI/2, precision);
    }

    @Test
    public void ltSecondExtrema() {
        util.doCheck(-PI/2 - 0.01, precision);
    }

    @Test
    public void gtThirdExtrema() {
        util.doCheck(-PI/4 + 0.01, precision);
    }

    @Test
    public void thirdExtrema() {
        util.doCheck(-PI/4, precision);
    }

    @Test
    public void ltThirdExtrema() {
        util.doCheck(-PI/4 - 0.01, precision);
    }

    @Test
    public void gtFourthExtrema() {
        util.doCheck(-3 * PI/4, precision);
    }

    @Test
    public void fourthExtrema() {
        util.doCheck(-3 * PI/4, precision);
    }

    @Test
    public void ltFourthExtrema() {
        util.doCheck(-3 * PI/4 - 0.01, precision);
    }

    @Test
    public void gtMinusPi() {
        util.doCheck( -PI + 0.01, precision);
    }

    @Test
    public void minusPi() {
        util.doCheck(-PI, precision);
    }

    @Test
    public void ltMinusPi() {
        util.doCheck(-PI - 0.01, precision);
    }



}