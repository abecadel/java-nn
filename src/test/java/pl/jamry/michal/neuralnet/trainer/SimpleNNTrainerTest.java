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

    @Test
    public void fizzBuzz() {
        org.jblas.util.Random.seed(0);
    }

    @Test
    public void testEncoding() {
        assertArraysEqual(new double[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, binEncode(1));
        assertArraysEqual(new double[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, binEncode(2));
        assertArraysEqual(new double[]{1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, binEncode(3));
        assertArraysEqual(new double[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, binEncode(4));
        assertArraysEqual(new double[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0}, binEncode(5));
        assertArraysEqual(new double[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, binEncode(6));
        assertArraysEqual(new double[]{1, 1, 1, 0, 0, 0, 0, 0, 0, 0}, binEncode(7));
        assertArraysEqual(new double[]{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, binEncode(8));
        assertArraysEqual(new double[]{1, 0, 0, 1, 0, 0, 0, 0, 0, 0}, binEncode(9));
        assertArraysEqual(new double[]{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, binEncode(10));
    }

    private double[] binEncode(int x) {
        double[] arr = new double[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = x >> i & 1;
        }
        return arr;
    }


    private void assertArraysEqual(double[] a, double[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("Arrays are of a different length");
        }

        for (int i = 0; i < a.length; i++) {
            double left = a[i];
            double right = b[i];

            if (left != right) {
                throw new RuntimeException("Arrays are not equal " + arr2str(a) + " != " + arr2str(b));
            }
        }
    }

    private String arr2str(double[] doubles) {
        StringBuilder sb = new StringBuilder().append("[");
        for (double d : doubles) {
            sb.append(d).append(", ");
        }

        return sb.append("]").toString();
    }
}