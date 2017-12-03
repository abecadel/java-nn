package pl.jamry.michal.neuralnet.tensors;

/**
 * The interface Tensor.
 */
public interface Tensor {
    /**
     * Dot tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor dot(Tensor tensor);

    /**
     * Multiply tensor.
     *
     * @param i the
     * @return the tensor
     */
    default Tensor multiply(Integer i) {
        return multiply(new Float(i));
    }

    /**
     * Multiply tensor.
     *
     * @param f the f
     * @return the tensor
     */
    Tensor multiply(Float f);

    /**
     * Multiply tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor multiply(Tensor tensor);

    /**
     * Divide tensor.
     *
     * @param f the f
     * @return the tensor
     */
    Tensor divide(Float f);

    /**
     * Add tensor.
     *
     * @param f the f
     * @return the tensor
     */
    Tensor add(Float f);

    /**
     * Add tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor add(Tensor tensor);

    /**
     * Substract tensor.
     *
     * @param f the f
     * @return the tensor
     */
    Tensor substract(Float f);

    /**
     * Substract tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor substract(Tensor tensor);

    /**
     * Transpose tensor.
     *
     * @return the tensor
     */
    Tensor transpose();

    /**
     * T is a transpose() alias tensor.
     *
     * @return the tensor
     */
    default Tensor T() {
        return transpose();
    }

    /**
     * Power tensor.
     *
     * @param f the f
     * @return the tensor
     */
    Tensor power(Float f);

    /**
     * Power tensor.
     *
     * @param i the
     * @return the tensor
     */
    default Tensor power(Integer i) {
        return power(new Float(i));
    }

    /**
     * Sum tensor.
     *
     * @param axis the axis
     * @return the tensor
     */
    Tensor sum(int axis);

    /**
     * Sum tensor.
     *
     * @return the tensor
     */
    default Tensor sum() {
        return sum(0);
    }

    /**
     * Tanh tensor.
     *
     * @return the tensor
     */
    Tensor tanh();

    /**
     * Sigmoid tensor.
     *
     * @return the tensor
     */
    Tensor sigmoid();

    /**
     * Relu tensor.
     *
     * @return the tensor
     */
    Tensor relu();

    /**
     * Get float.
     *
     * @return the float
     */
    default Float get() {
        return get(0);
    }

    /**
     * Get float.
     *
     * @param col the col
     * @return the float
     */
    default Float get(Integer col) {
        return get(0, col);
    }

    /**
     * Get float.
     *
     * @param row the row
     * @param col the col
     * @return the float
     */
    default Float get(Integer row, Integer col) {
        return ix(row, col);
    }

    /**
     * Ix float.
     *
     * @param cords the cords
     * @return the float
     */
    Float ix(Integer... cords);
}
