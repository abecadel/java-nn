package pl.jamry.michal.neuralnet.trainer;

import pl.jamry.michal.neuralnet.loss.Loss;
import pl.jamry.michal.neuralnet.nn.NeuralNetwork;
import pl.jamry.michal.neuralnet.optimization.Optimizer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Simple nn trainer.
 */
public class SimpleNNTrainer implements Trainer {

    private NeuralNetwork neuralNetwork;
    private int numOfEpochs;
    private Loss loss;
    private Optimizer optimizer;

    /**
     * Instantiates a new Simple nn trainer.
     *
     * @param neuralNetwork the neural network
     * @param numOfEpochs   the num of epochs
     * @param loss          the loss
     * @param optimizer     the optimizer
     */
    public SimpleNNTrainer(NeuralNetwork neuralNetwork, int numOfEpochs, Loss loss, Optimizer optimizer) {
        this.neuralNetwork = neuralNetwork;
        this.numOfEpochs = numOfEpochs;
        this.loss = loss;
        this.optimizer = optimizer;
    }

    public void train(Tensor inputs, Tensor targets) {
        for (int i = 0; i < numOfEpochs; i++) {
            Tensor predicted = neuralNetwork.forward(inputs);
            float epochLoss = loss.loss(predicted, targets);
            Tensor grad = loss.grad(predicted, targets);
            neuralNetwork.backward(grad);
            optimizer.step(neuralNetwork);

            System.out.println("epoch:" + i + " loss:" + epochLoss);
        }
    }
}
