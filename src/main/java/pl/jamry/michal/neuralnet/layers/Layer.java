package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The interface Layer.
 */
public interface Layer {
    /**
     * Forward tensor.
     *
     * @param inputs the inputs
     * @return the tensor
     */
    Tensor forward(Tensor inputs);

    /**
     * Backword tensor.
     *
     * @param grad the grad
     * @return the tensor
     */
    Tensor backward(Tensor grad);
}
