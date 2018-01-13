package pl.jamry.michal.neuralnet.layers;

import org.junit.Test;
import pl.jamry.michal.neuralnet.activation.LinearActivation;
import pl.jamry.michal.neuralnet.tensors.JBlasTensor;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import static org.junit.Assert.*;

public class DenseLayerTest {

    @Test
    public void forward() {
        org.jblas.util.Random.seed(0);

        Tensor inputs = new JBlasTensor(new double[][]{
                {1, 0}
        });

        Layer layer = new DenseLayer(1, 2, new LinearActivation());

        Tensor ret = layer.forward(inputs);


    }
}