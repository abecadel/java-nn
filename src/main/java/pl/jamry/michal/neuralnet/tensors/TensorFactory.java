package pl.jamry.michal.neuralnet.tensors;

//TODO in some future: split interface-impl, add DI based on tensor impl we want
public class TensorFactory {
    public static Tensor createRandomTensor(int rows, int cols) {
        return JBlasTensor.randr(rows, cols);
    }
}
