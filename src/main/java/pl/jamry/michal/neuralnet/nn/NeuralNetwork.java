package pl.jamry.michal.neuralnet.nn;

import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.util.List;

/**
 * The type Neural network.
 */
public class NeuralNetwork {
    private List<Layer> layers;

    /**
     * Instantiates a new Neural network.
     *
     * @param layers the layers
     */
    public NeuralNetwork(List<Layer> layers) {
        this.layers = layers;
    }

    /**
     * Forward tensor.
     *
     * @param input the input
     * @return the tensor
     */
    public Tensor forward(Tensor input) {
        for (Layer layer : layers) {
            input = layer.forward(input);
        }

        return input;
    }

    /**
     * Backward tensor.
     *
     * @param grad the grad
     * @return the tensor
     */
    public Tensor backward(Tensor grad) {
        for (int i = layers.size() - 1; i >= 0; i--) {
            Layer layer = layers.get(i);
            layer.backward(grad);
        }

        return grad;
    }

    /**
     * Gets layers.
     *
     * @return the layers
     */
    public List<Layer> getLayers() {
        return layers;
    }
}
