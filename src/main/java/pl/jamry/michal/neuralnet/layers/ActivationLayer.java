package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.activation.ActivationFunction;
import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Activation layer.
 */
public class ActivationLayer extends Layer {
    private ActivationFunction function;
    private Tensor inputs;

    /**
     * Instantiates a new Activation layer.
     *
     * @param function the function
     */
    public ActivationLayer(ActivationFunction function) {
        this.function = function;
    }

    @Override
    public Tensor forward(Tensor inputs) {
        this.inputs = inputs;
        return function.call(inputs);
    }

    @Override
    public Tensor backward(Tensor grad) {
        return function.callPrime(inputs).multiply(grad);
    }
}
