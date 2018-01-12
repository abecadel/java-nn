package pl.jamry.michal.neuralnet.example.mnist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import pl.jamry.michal.neuralnet.tensors.JBlasTensor;
import pl.jamry.michal.neuralnet.tensors.Tensor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderExample {
    Logger LOG = LogManager.getLogger(ReaderExample.class);
    Tensor x;
    Tensor y;

    @Test
    public void testOne() {
        LOG.info("halo");
        //TODO
    }

    @Before
    public void prepareData() throws IOException, URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("train.csv").toURI());

        double[][] doubles = null;
        double[][] labels = null;


        List<String> lines = Files.lines(path).collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            String x = lines.get(i);

            if (i == 0) {
                int noOfValues = x.split(",").length - 1;
                doubles = new double[lines.size() - 1][noOfValues];
                labels = new double[lines.size() - 1][1];

            } else {
                String label = x.split(",")[0]; //first value is label
                labels[i - 1][0] = Double.parseDouble(label);

                double[] data = str2dblarr(x.substring(label.length() + 1)); //everything after the label is data
                System.arraycopy(data, 0, doubles[i - 1], 0, data.length);
            }
        }

        x = new JBlasTensor(doubles);
        y = new JBlasTensor(labels);
    }

    private double[] str2dblarr(String string) {
        String[] arr = string.split(",");
        double[] d = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            d[i] = Double.parseDouble(arr[i]);
        }

        return d;
    }
}
