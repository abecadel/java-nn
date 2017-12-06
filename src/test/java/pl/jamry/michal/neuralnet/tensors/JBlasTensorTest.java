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
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });
        double d = 2;

        Tensor ret = a.substract(d);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{-1, 1, 0, 2};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void substractTensor() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor b = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor ret = a.substract(b);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{0, 0, 0, 0};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void transpose() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        assertEquals(2, a.dimensions()[0]);
        assertEquals(3, a.dimensions()[1]);

        Tensor ret = a.transpose();
        assertEquals(3, ret.dimensions()[0]);
        assertEquals(2, ret.dimensions()[1]);

        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{1, 2, 3, 4, 5, 6};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void power() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });
        double d = 2;

        Tensor ret = a.power(d);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{1, 9, 4, 16};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void sum() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        });

        double ret = a.sum();
        assertEquals(21, ret,1);
    }

    @Test
    public void sumAxis0() {
        Tensor a = new JBlasTensor(new double[][]{
                {2, 1},
                {3, 4},
                {5, 6}
        });

        Tensor ret = a.sum(0);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{10, 11};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void sumAxis1() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        });

        Tensor ret = a.sum(1);
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{3, 7, 11};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void tanh() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor ret = a.tanh();
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{0.7615941559557649, 0.9950547536867305, 0.9640275800758169, 0.999329299739067};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void sigmoid() {
        Tensor a = new JBlasTensor(new double[][]{
                {1, 2},
                {3, 4}
        });

        Tensor ret = a.sigmoid();
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{0.7310585786300049, 0.9525741268224334, 0.8807970779778823, 0.9820137900379085};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void relu() {
        Tensor a = new JBlasTensor(new double[][]{
                {-1, 2},
                {3, -4}
        });

        Tensor ret = a.relu();
        double[] returned = ((DoubleMatrix) ret.getData()).data;
        double[] expected = new double[]{0, 3, 2, 0};
        assertArraysEqual(expected, returned);
    }

    @Test
    public void getSingleVal() {
        Tensor a = new JBlasTensor(new double[][]{
                {11}
        });

        double ret = a.get();
        assertEquals(11, ret, 1);
    }

    @Test
    public void getSingleValueFromRow() {
        Tensor a = new JBlasTensor(new double[][]{
                {1,2,3,4,5,11}
        });

        double ret = a.get(5);
        assertEquals(11, ret, 1);
    }

    @Test
    public void getSingleValueFromMatrix() {
        Tensor a = new JBlasTensor(new double[][]{
                {-1, 2},
                {3, -4}
        });

        double ret = a.get(1, 0);
        assertEquals(3, ret, 1);
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