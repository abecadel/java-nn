package pl.jamry.michal.neuralnet.tensors;

import org.junit.Test;

import static org.junit.Assert.*;

public class JBlasTensorTest {

    @Test
    public void add(){
        Tensor a = new JBlasTensor(new double[][]{
                {1,2},
                {3,4}
        });
        double d = 2;

        Tensor ret = a.add(d);
    }

    @Test
    public void addTensor(){
        Tensor a = new JBlasTensor(new double[][]{
                {1,2},
                {3,4}
        });

        Tensor b = new JBlasTensor(new double[][]{
                {1,2},
                {3,4}
        });

        Tensor ret = a.add(b);
    }

}