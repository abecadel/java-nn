package pl.jamry.michal.neuralnet.tensors;

/**
 * The type Ss tensor.
 */
public class SSTensor implements Tensor {
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
        return null;
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
        return null;
    }

    @Override
    public Tensor substract(double d) {
        return null;
    }

    @Override
    public Tensor substract(Tensor tensor) {
        return null;
    }

    @Override
    public Tensor transpose() {
        return null;
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
}
