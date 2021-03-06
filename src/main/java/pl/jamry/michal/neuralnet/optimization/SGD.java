package pl.jamry.michal.neuralnet.optimization;

import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.models.Model;
import pl.jamry.michal.neuralnet.models.SequentialModel;
import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Sgd.
 */
public class SGD implements Optimizer {
    private double learning_rate;

    /**
     * Instantiates a new Sgd.
     *
     * @param learning_rate the learning rate
     */
    public SGD(double learning_rate) {
        this.learning_rate = learning_rate;
    }

    @Override
    public void step(Model model) {
        for (Layer layer : model.getLayers()) {
            Tensor weights = layer.getWeights();
            Tensor weightsGrads = layer.getWeightsGrad();
            Tensor biases = layer.getBias();
            Tensor biasesGrads = layer.getBiasGrad();

            if (weights == null){
                continue;
            }

            weights = weights.substract(weightsGrads.multiply(learning_rate));
            biases = biases.substract(biasesGrads.multiply(learning_rate));

            layer.setWeights(weights);
            layer.setBias(biases);
        }
    }
}
