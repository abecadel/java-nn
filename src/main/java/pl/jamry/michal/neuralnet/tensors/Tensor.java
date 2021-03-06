package pl.jamry.michal.neuralnet.tensors;

/**
 * The interface Tensor.
 */
public interface Tensor {

    int AXIS_0 = 0;
    int AXIS_1 = 1;

    /**
     * Dot tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor dot(Tensor tensor);

    /**
     * Mmul tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    default Tensor mmul(Tensor tensor) {
        return dot(tensor);
    }

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
     * Divide tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor divide(Tensor tensor);

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
     * Sum double.
     *
     * @return the double
     */
    double sum();

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
    double get(Integer row, Integer col);

    /**
     * Dimensions int [ ].
     *
     * @return the int [ ]
     */
    int[] dimensions();

    /**
     * Ones tensor.
     *
     * @param dimensions the dimensions
     * @return the tensor
     */
    Tensor ones(int[] dimensions);

    /**
     * Ones tensor.
     *
     * @return the tensor
     */
    default Tensor ones() {
        return ones(dimensions());
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    Object getData();

    /**
     * Copy tensor tensor.
     *
     * @return the tensor
     */
    Tensor copyTensor();
}
