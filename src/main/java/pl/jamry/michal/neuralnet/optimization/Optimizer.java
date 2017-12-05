package pl.jamry.michal.neuralnet.optimization;

import pl.jamry.michal.neuralnet.nn.NeuralNetwork;

/**
 * The interface Optimizer.
 */
public interface Optimizer {
    /**
     * Step.
     *
     * @param neuralNetwork the neural network
     */
    void step(NeuralNetwork neuralNetwork);
}
