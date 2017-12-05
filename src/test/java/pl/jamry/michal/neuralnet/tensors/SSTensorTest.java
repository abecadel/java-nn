package pl.jamry.michal.neuralnet.tensors;

import org.junit.Test;

import static org.junit.Assert.*;

public class SSTensorTest {

    @Test
    public void dot() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void multiplyTensor() {
        SSTensor a = new SSTensor(new double[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });

        SSTensor b = new SSTensor(new double[][]{
                {2,2,2},
                {2,2,2},
                {2,2,2}
        });

        SSTensor ret = (SSTensor) a.multiply(b);

        int k = 4;
    }

    @Test
    public void divide() {
    }

    @Test
    public void add() {
    }

    @Test
    public void add1() {
    }

    @Test
    public void substract() {
    }

    @Test
    public void substract1() {
    }

    @Test
    public void transpose() {
    }

    @Test
    public void power() {
    }

    @Test
    public void sum() {
    }

    @Test
    public void tanh() {
    }

    @Test
    public void sigmoid() {
    }

    @Test
    public void relu() {
    }

    @Test
    public void ix() {
    }

    @Test
    public void dimensions() {
    }

    @Test
    public void ones() {
    }
}