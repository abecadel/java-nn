package pl.jamry.michal.neuralnet.models;

import pl.jamry.michal.neuralnet.loss.Loss;
import pl.jamry.michal.neuralnet.optimization.Optimizer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

public abstract class Model {

    public abstract void compile(Loss loss, Optimizer optimizer);

    public abstract void fit(Tensor data, Tensor labels, int epochs, int batchSize);

    public void fit(Tensor data, Tensor labels) {
        fit(data, labels, 1000, 32);
    }

    public abstract Tensor predict(Tensor data);

}
