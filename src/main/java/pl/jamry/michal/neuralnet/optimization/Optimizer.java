package pl.jamry.michal.neuralnet.optimization;

import pl.jamry.michal.neuralnet.models.SequentialModel;

/**
 * The interface Optimizer.
 */
public interface Optimizer {
    /**
     * Step.
     *
     * @param sequentialModel the neural network
     */
    void step(SequentialModel sequentialModel);
}
