package pl.jamry.michal.neuralnet.trainer;

import org.junit.Test;
import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.layers.LinearLayer;
import pl.jamry.michal.neuralnet.layers.TanhActivationLayer;
import pl.jamry.michal.neuralnet.loss.TSS;
import pl.jamry.michal.neuralnet.nn.NeuralNetwork;
import pl.jamry.michal.neuralnet.optimization.SGD;
import pl.jamry.michal.neuralnet.tensors.JBlasTensor;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.util.ArrayList;

public class SimpleNNTrainerTest {

    @Test
    public void xorModelling() {

        org.jblas.util.Random.seed(0);

        NeuralNetwork neuralNetwork = new NeuralNetwork(new ArrayList<Layer>() {{
            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
            add(new TanhActivationLayer());
            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
            add(new TanhActivationLayer());
            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
        }});

        Trainer trainer = new SimpleNNTrainer(neuralNetwork, 5000, new TSS(), new SGD(0.01));

        Tensor inputs = new JBlasTensor(new double[][]{
                {0, 0},
                {1, 0},
                {0, 1},
                {1, 1}
        });

        Tensor targets = new JBlasTensor(new double[][]{
                {1, 0},
                {0, 1},
                {0, 1},
                {1, 0}
        });

        trainer.train(inputs, targets);

        Tensor predictions = neuralNetwork.forward(inputs);

        System.out.println(targets);
        System.out.println(predictions);
    }

}