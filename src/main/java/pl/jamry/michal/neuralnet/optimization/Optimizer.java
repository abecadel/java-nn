package pl.jamry.michal.neuralnet.optimization;

import pl.jamry.michal.neuralnet.models.Model;

/**
 * The interface Optimizer.
 */
public interface Optimizer {
    void step(Model model);
}
