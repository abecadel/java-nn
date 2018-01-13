package pl.jamry.michal.neuralnet.activation;

import pl.jamry.michal.neuralnet.tensors.Tensor;

public interface ActivationFunction {
    Tensor call(Tensor inputs);

    Tensor callPrime(Tensor grads);
}
