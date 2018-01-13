package pl.jamry.michal.neuralnet.tensors;

import org.jblas.DoubleMatrix;

//TODO in some future: split interface-impl, add DI based on tensor impl we want
public class TensorFactory {
    public static Tensor createRandomTensor(int row, int cols) {
        return new JBlasTensor(DoubleMatrix.randn(row, cols));
    }

    public static Tensor createZeroes(int row, int cols) {
        return new JBlasTensor(DoubleMatrix.zeros(row, cols));
    }

    public static Tensor createOnes(int row, int cols) {
        return new JBlasTensor(DoubleMatrix.ones(row, cols));
    }

    public static Tensor createRandomTensor(int row) {
        return new JBlasTensor(DoubleMatrix.randn(row));
    }

    public static Tensor createZeroes(int row) {
        return new JBlasTensor(DoubleMatrix.zeros(row));
    }

    public static Tensor createOnes(int row) {
        return new JBlasTensor(DoubleMatrix.ones(row));
    }
}
