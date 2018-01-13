package pl.jamry.michal.neuralnet.models;

import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.loss.Loss;
import pl.jamry.michal.neuralnet.optimization.Optimizer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.util.List;

public class SequentialModel extends Model {
    private List<Layer> layers;

    public SequentialModel(List<Layer> layers) {
        this.layers = layers;
    }

    public Tensor forward(Tensor input) {
        for (Layer layer : layers) {
            input = layer.forward(input);
        }

        return input;
    }

    public Tensor backward(Tensor grad) {
        for (int i = layers.size() - 1; i >= 0; i--) {
            Layer layer = layers.get(i);
            grad = layer.backward(grad);
        }

        return grad;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    @Override
    public void compile(Loss loss, Optimizer optimizer) {
        //TODO
    }

    @Override
    public void fit(Tensor data, Tensor labels, int epochs, int batchSize) {
        //TODO
    }

    @Override
    public Tensor predict(Tensor data) {
        //TODO
        return null;
    }
}
