package pl.jamry.michal.neuralnet.trainer;

import org.junit.Test;
import pl.jamry.michal.neuralnet.layers.Layer;
import pl.jamry.michal.neuralnet.layers.LinearLayer;
import pl.jamry.michal.neuralnet.layers.activation.TanhActivationLayer;
import pl.jamry.michal.neuralnet.loss.TSS;
import pl.jamry.michal.neuralnet.models.SequentialModel;
import pl.jamry.michal.neuralnet.optimization.SGD;
import pl.jamry.michal.neuralnet.tensors.JBlasTensor;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.util.ArrayList;

public class SimpleNNTrainerTest {

    @Test
    public void xorModelling() {

        org.jblas.util.Random.seed(0);

        SequentialModel sequentialModel = new SequentialModel(new ArrayList<Layer>() {{
            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
            add(new TanhActivationLayer());
            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
            add(new TanhActivationLayer());
            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
        }});

        Trainer trainer = new SimpleNNTrainer(sequentialModel, 5000, new TSS(), new SGD(0.01));

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

        Tensor predictions = sequentialModel.forward(inputs);

        System.out.println(targets);
        System.out.println(predictions);
    }

//    @Test
    public void fizzBuzz() {
        org.jblas.util.Random.seed(0);

        SequentialModel sequentialModel = new SequentialModel(new ArrayList<Layer>() {{
            add(new LinearLayer(JBlasTensor.randr(10,50), JBlasTensor.randr(50)));
            add(new TanhActivationLayer());
            add(new LinearLayer(JBlasTensor.randr(10, 50), JBlasTensor.randr(50)));
        }});

        Tensor inputs = new JBlasTensor(createInputs(101,1024));
        Tensor targets = new JBlasTensor(createTargets(101,1024));

        Trainer trainer = new SimpleNNTrainer(sequentialModel, 5000, new TSS(), new SGD(0.001));
        trainer.train(inputs, targets);
        Tensor predictions = sequentialModel.forward(inputs);

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

    @Test
    public void createTargets(){
        double[][] a = createTargets(101,1024);

        System.out.println(arr2str(a[0]));
        System.out.println(arr2str(a[1024-101-1]));
    }

    private double[][] createTargets(int from, int to){
        double[][] arr = new double[to - from][];

        for (int i = from, pos = 0; i < to; i++, pos++) {
            arr[pos] = fizzBuzzEncode(i);
        }

        return arr;
    }

    @Test
    public void createInputs(){
        double[][] a = createInputs(101,1024);

        System.out.println(arr2str(a[0]));
        System.out.println(arr2str(a[1024-101-1]));
    }

    private double[][] createInputs(int from, int to){
        double[][] arr = new double[to - from][];

        for (int i = from, pos = 0; i < to; i++, pos++) {
            arr[pos] = binEncode(i);
        }

        return arr;
    }

    private double[] fizzBuzzEncode(int x) {
        if (x % 15 == 0) {
            return new double[]{0, 0, 0, 1};
        } else if (x % 5 == 0) {
            return new double[]{0, 0, 1, 0};
        } else if (x % 3 == 0) {
            return new double[]{0, 1, 0, 0};
        } else {
            return new double[]{1, 0, 0, 0};
        }
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