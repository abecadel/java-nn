package pl.jamry.michal.neuralnet.tensors;

import org.jblas.DoubleMatrix;
import org.jblas.MatrixFunctions;

public class JBlasTensor implements Tensor {
    private DoubleMatrix matrix;

    public JBlasTensor(double[][] doubles) {
        matrix = new DoubleMatrix(doubles);
    }

    private JBlasTensor(DoubleMatrix matrix) {
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
        return new JBlasTensor(matrix.add((DoubleMatrix) tensor.getData()));
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
        return null;
    }

    @Override
    public double ix(Integer... cords) {
        return 0;
    }

    @Override
    public int[] dimensions() {
        return new int[]{matrix.rows, matrix.columns};
    }

    @Override
    public Tensor ones(int[] dimensions) {
        return null;
    }

    @Override
    public Object getData() {
        return matrix;
    }
}
