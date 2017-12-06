package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.activation.TanhActivationFunction;

/**
 * The type Tanh activation layer.
 */
public class TanhActivationLayer extends ActivationLayer {
    /**
     * Instantiates a new Activation layer.
     */
    public TanhActivationLayer() {
        super(new TanhActivationFunction());
    }
}
