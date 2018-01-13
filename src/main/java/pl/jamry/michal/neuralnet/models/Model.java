package pl.jamry.michal.neuralnet.models;

import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.loss.Loss;
import pl.jamry.michal.neuralnet.optimization.Optimizer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.util.List;

public abstract class Model {
    protected Loss loss;
    protected Optimizer optimizer;

    public void compile(Loss loss, Optimizer optimizer) {
        this.loss = loss;
        this.optimizer = optimizer;
    }

    public abstract void fit(Tensor inputs, Tensor targets, int epochs, int batchSize);

    public void fit(Tensor inputs, Tensor targets) {
        fit(inputs, targets, 1000, 32);
    }

    public abstract Tensor predict(Tensor data);

    public abstract List<Layer> getLayers();

    public abstract void addLayer(Layer layer);
}
