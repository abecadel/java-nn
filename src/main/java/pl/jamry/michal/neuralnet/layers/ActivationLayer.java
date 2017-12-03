package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.activation.ActivationFunction;
import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Activation layer.
 */
public class ActivationLayer implements Layer {
    private ActivationFunction function;
    private ActivationFunction functionPrime;
    private Tensor inputs;

    /**
     * Instantiates a new Activation layer.
     *
     * @param function      the function
     * @param functionPrime the function prime
     */
    public ActivationLayer(ActivationFunction function, ActivationFunction functionPrime) {
        this.function = function;
        this.functionPrime = functionPrime;
    }

    @Override
    public Tensor forward(Tensor inputs) {
        this.inputs = inputs;
        return function.call(inputs);
    }

    @Override
    public Tensor backward(Tensor grad) {
        return functionPrime.call(inputs).multiply(grad);
    }
}
