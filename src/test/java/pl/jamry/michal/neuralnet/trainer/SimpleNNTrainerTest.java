package pl.jamry.michal.neuralnet.trainer;

import org.junit.Test;
import pl.jamry.michal.neuralnet.loss.TSS;
import pl.jamry.michal.neuralnet.models.Model;
import pl.jamry.michal.neuralnet.models.SequentialModel;
import pl.jamry.michal.neuralnet.optimization.SGD;
import pl.jamry.michal.neuralnet.tensors.JBlasTensor;
import pl.jamry.michal.neuralnet.tensors.Tensor;

public class SimpleNNTrainerTest {

    @Test
    public void xorModelling() {

        org.jblas.util.Random.seed(0);

        Model model = new SequentialModel();
//        model.addLayer(new LinearLayer(2, 1));
//            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
//            add(new TanhActivationLayer());
//            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
//            add(new TanhActivationLayer());
//            add(new LinearLayer(JBlasTensor.randr(2, 2), JBlasTensor.randr(2)));
//        }});

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

        model.fit(inputs, targets);

        Tensor predictions = model.predict(inputs);

        System.out.println(targets);
        System.out.println(predictions);
    }

}