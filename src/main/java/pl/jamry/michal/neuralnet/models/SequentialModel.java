package pl.jamry.michal.neuralnet.models;

import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.util.ArrayList;
import java.util.List;

public class SequentialModel extends Model {
    private List<Layer> layers;

    public SequentialModel() {
        layers = new ArrayList<>();
    }

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

    @Override
    public List<Layer> getLayers() {
        return layers;
    }

    @Override
    public void addLayer(Layer layer) {
        layers.add(layer);
    }


    public void fit(Tensor inputs, Tensor targets, int epochs, int batchSize) {
        for (int i = 0; i < epochs; i++) {
            Tensor predicted = forward(inputs);
            double epochLoss = loss.loss(predicted, targets);
            Tensor grad = loss.grad(predicted, targets);
            backward(grad);
            optimizer.step(this);

            System.out.println("epoch:" + i + " loss:" + epochLoss);
        }
    }

    @Override
    public Tensor predict(Tensor data) {
        return forward(data);
    }
}
