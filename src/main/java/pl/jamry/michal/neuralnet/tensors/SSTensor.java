package pl.jamry.michal.neuralnet.tensors;

import com.numericalmethod.suanshu.algebra.linear.matrix.doubles.matrixtype.dense.DenseMatrix;

/**
 * The type Ss tensor.
 */
public class SSTensor implements Tensor {
    private DenseMatrix matrix;

    /**
     * Instantiates a new Ss tensor.
     *
     * @param data the data
     */
    public SSTensor(double[][] data) {
        matrix = new DenseMatrix(data);
    }

    private SSTensor(DenseMatrix denseMatrix) {
        this.matrix = denseMatrix;
    }

    @Override
    public Tensor dot(Tensor tensor) {
        return null;
    }

    @Override
    public Tensor multiply(double d) {
        return null;
    }

    @Override
    public Tensor multiply(Tensor tensor) {
        DenseMatrix other = (DenseMatrix) tensor.getData();
        return new SSTensor((DenseMatrix) matrix.deepCopy().multiply(other));
    }

    @Override
    public Tensor divide(double d) {
        return null;
    }

    @Override
    public Tensor add(double d) {
        return null;
    }

    @Override
    public Tensor add(Tensor tensor) {
        DenseMatrix other = (DenseMatrix) tensor.getData();
        return new SSTensor((DenseMatrix) matrix.deepCopy().add(other));
    }

    @Override
    public Tensor substract(double d) {
        return null;
    }

    @Override
    public Tensor substract(Tensor tensor) {
        DenseMatrix other = (DenseMatrix) tensor.getData();
        return new SSTensor((DenseMatrix) matrix.deepCopy().minus(other));
    }

    @Override
    public Tensor transpose() {
        return new SSTensor(matrix.deepCopy().t());
    }

    @Override
    public Tensor power(double d) {
        return null;
    }

    @Override
    public Tensor sum(int axis) {
        return null;
    }

    @Override
    public Tensor tanh() {
        return null;
    }

    @Override
    public Tensor sigmoid() {
        return null;
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
    public Integer[] dimensions() {
        return new Integer[0];
    }

    @Override
    public Tensor ones(Integer[] dimensions) {
        return null;
    }

    @Override
    public Object getData() {
        return matrix;
    }
}
