package pl.jamry.michal.neuralnet.trainer;

import pl.jamry.michal.neuralnet.loss.Loss;
import pl.jamry.michal.neuralnet.models.SequentialModel;
import pl.jamry.michal.neuralnet.optimization.Optimizer;
import pl.jamry.michal.neuralnet.tensors.Tensor;

/**
 * The type Simple nn trainer.
 */
public class SimpleNNTrainer implements Trainer {

    private SequentialModel sequentialModel;
    private int numOfEpochs;
    private Loss loss;
    private Optimizer optimizer;

    /**
     * Instantiates a new Simple nn trainer.
     *
     * @param sequentialModel the neural network
     * @param numOfEpochs   the num of epochs
     * @param loss          the loss
     * @param optimizer     the optimizer
     */
    public SimpleNNTrainer(SequentialModel sequentialModel, int numOfEpochs, Loss loss, Optimizer optimizer) {
        this.sequentialModel = sequentialModel;
        this.numOfEpochs = numOfEpochs;
        this.loss = loss;
        this.optimizer = optimizer;
    }

    @Override
    public void train(Tensor inputs, Tensor targets) {
        for (int i = 0; i < numOfEpochs; i++) {
            Tensor predicted = sequentialModel.forward(inputs);
            double epochLoss = loss.loss(predicted, targets);
            Tensor grad = loss.grad(predicted, targets);
            sequentialModel.backward(grad);
            optimizer.step(sequentialModel);

            System.out.println("epoch:" + i + " loss:" + epochLoss);
        }
    }
}
