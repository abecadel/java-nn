package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Linear layer.
 *
 * This class implements a very sophisticated algorithm which
 * has something to do with polynomial \(ax^2 + bx + c\).
 */
public class LinearLayer extends Layer {
    private Tensor inputs;

    public LinearLayer(int units, int input_dims) {
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
