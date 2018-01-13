package pl.jamry.michal.neuralnet.tensors;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

/**
 * The type J blas tensor.
 */
public class JBlasTensor implements Tensor {
    private DoubleMatrix matrix;

    /**
     * Instantiates a new J blas tensor.
     *
     * @param doubles the doubles
     */
    public JBlasTensor(double[][] doubles) {
        matrix = new DoubleMatrix(doubles);
    }

    /**
     * Instantiates a new J blas tensor.
     *
     * @param matrix the matrix
     */
    public JBlasTensor(DoubleMatrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public Tensor dot(Tensor tensor) {
        return new JBlasTensor(matrix.mmul((DoubleMatrix) tensor.getData()));
    }

    @Override
    public Tensor multiply(double d) {
        return new JBlasTensor(matrix.mul(d));
    }

    @Override
    public Tensor multiply(Tensor tensor) {
        return new JBlasTensor(matrix.mul((DoubleMatrix) tensor.getData()));
    }

    @Override
    public Tensor divide(double d) {
        return new JBlasTensor(matrix.div(d));
    }

    @Override
    public Tensor divide(Tensor tensor) {
        return new JBlasTensor(matrix.div((DoubleMatrix) tensor.getData()));
    }

    @Override
    public Tensor add(double d) {
        return new JBlasTensor(matrix.add(d));
    }

    @Override
    public Tensor add(Tensor tensor) {
        DoubleMatrix other = (DoubleMatrix) tensor.getData();

//        simple column broadcasting
        if (matrix.columns != other.columns && other.columns == 1) {
            DoubleMatrix broadcastedOther = new DoubleMatrix().copy(other);
            while (broadcastedOther.columns < matrix.columns) {
                broadcastedOther = DoubleMatrix.concatHorizontally(broadcastedOther, other);
            }

            other = broadcastedOther;
        }

        return new JBlasTensor(matrix.add(other));
    }

    @Override
    public Tensor substract(double d) {
        return new JBlasTensor(matrix.sub(d));
    }

    @Override
    public Tensor substract(Tensor tensor) {
        return new JBlasTensor(matrix.sub((DoubleMatrix) tensor.getData()));
    }

    @Override
    public Tensor transpose() {
        return new JBlasTensor(matrix.transpose());
    }

    @Override
    public Tensor power(double d) {
        return new JBlasTensor(MatrixFunctions.pow(new DoubleMatrix().copy(matrix), d));
    }

    @Override
    public double sum() {
        return matrix.sum();
    }

    @Override
    public Tensor sum(int axis) {
        if (axis == 0) {
            DoubleMatrix ones = DoubleMatrix.ones(matrix.rows);
            return new JBlasTensor(matrix.transpose().mmul(ones));
        } else if (axis == 1) {
            DoubleMatrix ones = DoubleMatrix.ones(matrix.columns);
            return new JBlasTensor(matrix.mmul(ones));
        } else {
            throw new RuntimeException("Only axis = 0 or 1 supported");
        }
    }

    @Override
    public Tensor tanh() {
        return new JBlasTensor(MatrixFunctions.tanh(new DoubleMatrix().copy(matrix)));
    }

    @Override
    public Tensor sigmoid() {
        DoubleMatrix ones = DoubleMatrix.ones(matrix.rows, matrix.columns);
        return new JBlasTensor(ones.divi(MatrixFunctions.exp(matrix.mul(-1)).add(1)));
    }

    @Override
    public Tensor relu() {
        return new JBlasTensor(DoubleMatrix.zeros(matrix.rows, matrix.columns).max(matrix));
    }

    @Override
    public double get(Integer row, Integer col) {
        return matrix.getRow(row).getColumn(col).get(0);
    }

    @Override
    public int[] dimensions() {
        return new int[]{matrix.rows, matrix.columns};
    }

    @Override
    public Tensor ones(int[] dimensions) {
        return new JBlasTensor(DoubleMatrix.ones(dimensions[0], dimensions[1]));
    }

    @Override
    public Object getData() {
        return matrix;
    }

    @Override
    public Tensor copyTensor() {
        return new JBlasTensor(DoubleMatrix.zeros(matrix.rows, matrix.columns).copy(matrix));
    }

    @Override
    public String toString() {
        return matrix.toString();
    }
}
