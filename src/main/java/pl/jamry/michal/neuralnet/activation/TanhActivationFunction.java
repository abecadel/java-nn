package pl.jamry.michal.neuralnet.activation;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Tanh activation function.
 */
public class TanhActivationFunction implements ActivationFunction {
    @Override
    public Tensor call(Tensor tensor) {
        return tensor.tanh();
    }

    @Override
    public Tensor callPrime(Tensor tensor) {
        Tensor y = tensor.tanh();
        Tensor ones = y.ones();
        return ones.substract(y.power(2));
    }
}
