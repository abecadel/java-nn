package pl.jamry.michal.neuralnet.activation;

import pl.jamry.michal.neuralnet.tensors.Tensor;

public class SigmoidActivation implements ActivationFunction{
    @Override
    public Tensor call(Tensor inputs) {
        return inputs.sigmoid();
    }

    @Override
    public Tensor callPrime(Tensor grads) {
        return null;
    }
}
