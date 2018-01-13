package pl.jamry.michal.neuralnet.activation;

import pl.jamry.michal.neuralnet.tensors.Tensor;

public class LinearActivation implements ActivationFunction{
    @Override
    public Tensor call(Tensor inputs) {
        return inputs;
    }

    @Override
    public Tensor callPrime(Tensor grads) {
        return grads; //TODO: verify
    }
}
