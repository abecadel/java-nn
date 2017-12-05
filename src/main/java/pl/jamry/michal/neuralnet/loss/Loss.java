package pl.jamry.michal.neuralnet.loss;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The interface Loss.
 */
public interface Loss {
    /**
     * Loss float.
     *
     * @param predicted the predicted
     * @param actual    the actual
     * @return the double
     */
    double loss(Tensor predicted, Tensor actual);

    /**
     * Grad tensor.
     *
     * @param prediction the prediction
     * @param actual     the actual
     * @return the tensor
     */
    Tensor grad(Tensor prediction, Tensor actual);
}
