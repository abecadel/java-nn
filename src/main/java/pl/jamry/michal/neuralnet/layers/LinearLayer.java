package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Linear layer.
 */
public class LinearLayer extends Layer {
    private Tensor inputs;

    /**
     * Instantiates a new Linear layer.
     *
     * @param weights the weights
     * @param bias    the bias
     */
    public LinearLayer(Tensor weights, Tensor bias) {
        this.weights = weights;
        this.bias = bias;
    }

    @Override
    public Tensor forward(Tensor inputs) {
        this.inputs = inputs;
        return inputs.dot(weights).add(bias);
    }

    @Override
    public Tensor backward(Tensor grad) {
        biasGrad = grad.sum(0);
        weightsGrad = inputs.T().dot(grad);
        return grad.dot(weights.T());
    }
}
