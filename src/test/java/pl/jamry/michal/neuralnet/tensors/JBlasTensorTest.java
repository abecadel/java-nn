package pl.jamry.michal.neuralnet.tensors;

import org.jblas.DoubleMatrix;
import org.junit.Test;

public class JBlasTensorTest {

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