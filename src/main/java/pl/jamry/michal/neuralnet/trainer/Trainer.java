package pl.jamry.michal.neuralnet.trainer;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The interface Trainer.
 */
public interface Trainer {

    /**
     * Train.
     *
     * @param inputs  the inputs
     * @param targets the targets
     */
    void train(Tensor inputs, Tensor targets);
}
