package pl.jamry.michal.neuralnet.trainer;

import org.junit.Test;
import pl.jamry.michal.neuralnet.activation.SigmoidActivation;
import pl.jamry.michal.neuralnet.activation.TanhActivation;
import pl.jamry.michal.neuralnet.layers.DenseLayer;
import pl.jamry.michal.neuralnet.loss.TSS;
import pl.jamry.michal.neuralnet.models.Model;
import pl.jamry.michal.neuralnet.models.SequentialModel;
import pl.jamry.michal.neuralnet.optimization.SGD;
import pl.jamry.michal.neuralnet.tensors.JBlasTensor;
import pl.jamry.michal.neuralnet.tensors.Tensor;

public class SimpleNNTrainerTest {

    @Test
    public void xorTanh() {

        org.jblas.util.Random.seed(0);

        Model model = new SequentialModel();
        model.addLayer(new DenseLayer(4, 2, new TanhActivation()));
        model.addLayer(new DenseLayer(2, 2, new SigmoidActivation()));

        model.compile(new TSS(), new SGD(0.01));

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

        model.fit(inputs, targets, 1000, 1);

        Tensor predictions = model.predict(inputs);

        System.out.println(targets);
        System.out.println(predictions);
    }


    @Test
    public void xorRelu() {

    }

}