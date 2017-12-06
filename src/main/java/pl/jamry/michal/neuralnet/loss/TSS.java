package pl.jamry.michal.neuralnet.loss;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Tss.
 */
public class TSS implements Loss {
    @Override
    public double loss(Tensor predicted, Tensor actual) {
        return predicted.substract(actual).power(2).sum();
    }

    @Override
    public Tensor grad(Tensor prediction, Tensor actual) {
        return prediction.substract(actual).multiply(2);
    }
}
