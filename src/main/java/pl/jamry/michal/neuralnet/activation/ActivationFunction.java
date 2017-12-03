package pl.jamry.michal.neuralnet.activation;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The interface Activation function.
 */
public interface ActivationFunction {
    /**
     * Call tensor.
     *
     * @param tensor the tensor
     * @return the tensor
     */
    Tensor call(Tensor tensor);
}
