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
     * @param d the d
     * @return the tensor
     */
    Tensor multiply(double d);

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
     * @param d the d
     * @return the tensor
     */
    Tensor divide(double d);

    /**
     * Add tensor.
     *
     * @param d the d
     * @return the tensor
     */
    Tensor add(double d);

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
     * @param d the d
     * @return the tensor
     */
    Tensor substract(double d);

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
     * @param d the d
     * @return the tensor
     */
    Tensor power(double d);

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
     * Get double.
     *
     * @return the double
     */
    default double get() {
        return get(0);
    }

    /**
     * Get double.
     *
     * @param col the col
     * @return the double
     */
    default double get(Integer col) {
        return get(0, col);
    }

    /**
     * Get double.
     *
     * @param row the row
     * @param col the col
     * @return the double
     */
    default double get(Integer row, Integer col) {
        return ix(row, col);
    }

    /**
     * Ix double.
     *
     * @param cords the cords
     * @return the double
     */
    double ix(Integer... cords);

    /**
     * Dimensions integer [ ].
     *
     * @return the integer [ ]
     */
    Integer[] dimensions();

    /**
     * Ones tensor.
     *
     * @param dimensions the dimensions
     * @return the tensor
     */
    Tensor ones(Integer[] dimensions);

    /**
     * Ones tensor.
     *
     * @return the tensor
     */
    default Tensor ones() {
        return ones(dimensions());
    }
}
