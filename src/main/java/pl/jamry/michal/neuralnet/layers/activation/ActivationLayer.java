package pl.jamry.michal.neuralnet.layers.activation;

import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Activation layer.
 */
public abstract class ActivationLayer extends Layer {
    private Tensor inputs;

    @Override
    public Tensor forward(Tensor inputs) {
        this.inputs = inputs;
        return call(inputs);
    }

    @Override
    public Tensor backward(Tensor grad) {
        return callPrime(inputs).multiply(grad);
    }

    public abstract Tensor call(Tensor inputs);


    public abstract Tensor callPrime(Tensor grads);
}
