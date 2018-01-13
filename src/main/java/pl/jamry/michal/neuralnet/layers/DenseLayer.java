package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.activation.ActivationFunction;
import pl.jamry.michal.neuralnet.tensors.Tensor;
import pl.jamry.michal.neuralnet.tensors.TensorFactory;

/**
 * The type Linear layer.
 * <p>
 * This class implements a very sophisticated algorithm which
 * has something to do with polynomial \( activation_function(input *. weights + bias)\).
 */
public class DenseLayer extends Layer {
    private Tensor inputs;
    private ActivationFunction activationFunction;

    public DenseLayer(int units, int input_dims, ActivationFunction activationFunction) {
        this.weights = TensorFactory.createRandomTensor(input_dims, units);
        this.bias = TensorFactory.createRandomTensor(1, units);
        this.activationFunction = activationFunction;
    }

    @Override
    public Tensor forward(Tensor inputs) {
        this.inputs = inputs;
        Tensor ret = inputs.dot(weights).add(bias);

        if (activationFunction != null) {
            ret = activationFunction.call(ret);
        }

        return ret;
    }

    @Override
    public Tensor backward(Tensor grad) {
        biasGrad = grad.sum(Tensor.AXIS_0);
        weightsGrad = inputs.T().dot(grad);
        return grad.dot(weights.T());
    }
}
