package pl.jamry.michal.neuralnet.tensors;

import org.jblas.DoubleMatrix;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.assertEquals;

public class JBlasTensorTest {

    @Test
    public void dot() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        Tensor b = new JBlasTensor(new double[][]{
                {7, 8},
                {9, 10},
                {11, 12}
        });

        Tensor ret = a.dot(b);
        assertEquals(2, ret.dimensions()[0]);
        assertEquals(2, ret.dimensions()[1]);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{58, 139, 64, 154};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void multiply() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });
        double d = 2;

        Tensor ret = a.multiply(d);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{2, 6, 4, 8};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void multiplyTensor() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor b = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor ret = a.multiply(b);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{1, 9, 4, 16};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void divide() {
        Tensor a = new JBlasTensor(new double[][]{
                {16, 2},
                {30, 4}
        });
        double d = 2;

        Tensor ret = a.divide(d);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{8, 15, 1, 2};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void divideTensor() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor b = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor ret = a.divide(b);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{1, 1, 1, 1};
        assertArraysEqual(expected, returned);
    }


    @Test
    public void add() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });
        double d = 2;

        Tensor ret = a.add(d);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{3, 5, 4, 6};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void addTensor() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor b = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor ret = a.add(b);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{2, 6, 4, 8};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void substract() {
        throw new NotImplementedException();
    }

    @Test
    public void substractTensor() {
        throw new NotImplementedException();
    }

    @Test
    public void transpose() {
        throw new NotImplementedException();
    }

    @Test
    public void power() {
        throw new NotImplementedException();
    }

    @Test
    public void sum() {
        throw new NotImplementedException();
    }

    @Test
    public void sumAxis1() {
        throw new NotImplementedException();
    }

    @Test
    public void sumAxis2() {
        throw new NotImplementedException();
    }

    @Test
    public void tanh() {
        throw new NotImplementedException();
    }

    @Test
    public void sigmoid() {
        throw new NotImplementedException();
    }

    @Test
    public void relu() {
        throw new NotImplementedException();
    }


    private void assertArraysEqual(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("Arrays are of a different length");
        }

        for (int i = 0; i < a.length; i++) {
            double left = a[i];
            double right = b[i];

            if (left != right) {
                throw new RuntimeException("Arrays are not equal " + arr2str(a) + " != " + arr2str(b));
            }
        }
    }

    private String arr2str(double[] doubles) {
        StringBuilder sb = new StringBuilder().append("[");
        for (double d : doubles) {
            sb.append(d).append(", ");
        }

        return sb.append("]").toString();
    }
}