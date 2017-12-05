package pl.jamry.michal.neuralnet.layers;

import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The interface Layer.
 */
public abstract class Layer {
    /**
     * The Weights.
     */
    protected Tensor weights;
    /**
     * The Bias.
     */
    protected Tensor bias;
    /**
     * The Weights grad.
     */
    protected Tensor weightsGrad;
    /**
     * The Bias grad.
     */
    protected Tensor biasGrad;

    /**
     * Forward tensor.
     *
     * @param inputs the inputs
     * @return the tensor
     */
    public abstract Tensor forward(Tensor inputs);

    /**
     * Backword tensor.
     *
     * @param grad the grad
     * @return the tensor
     */
    public abstract Tensor backward(Tensor grad);

    /**
     * Gets weights.
     *
     * @return the weights
     */
    public Tensor getWeights() {
        return weights;
    }

    /**
     * Sets weights.
     *
     * @param weights the weights
     */
    public void setWeights(Tensor weights) {
        this.weights = weights;
    }

    /**
     * Gets bias.
     *
     * @return the bias
     */
    public Tensor getBias() {
        return bias;
    }

    /**
     * Sets bias.
     *
     * @param bias the bias
     */
    public void setBias(Tensor bias) {
        this.bias = bias;
    }

    /**
     * Gets weights grad.
     *
     * @return the weights grad
     */
    public Tensor getWeightsGrad() {
        return weightsGrad;
    }

    /**
     * Sets weights grad.
     *
     * @param weightsGrad the weights grad
     */
    public void setWeightsGrad(Tensor weightsGrad) {
        this.weightsGrad = weightsGrad;
    }

    /**
     * Gets bias grad.
     *
     * @return the bias grad
     */
    public Tensor getBiasGrad() {
        return biasGrad;
    }

    /**
     * Sets bias grad.
     *
     * @param biasGrad the bias grad
     */
    public void setBiasGrad(Tensor biasGrad) {
        this.biasGrad = biasGrad;
    }
}
