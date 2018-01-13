package pl.jamry.michal.neuralnet.util;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;

public class ShowBitmap extends JFrame implements Runnable {

    private byte[] bytes;
    private int width;
    private int height;
    private int resizeRatio;

    private ShowBitmap(byte[] bytes, int width, int height, int resizeRatio) throws HeadlessException {
        super();
        this.bytes = bytes;
        this.width = width;
        this.height = height;
        this.resizeRatio = resizeRatio;
    }

    public static void displayImage(double[] doubles, int width, int height, int resizeRatio) throws InterruptedException {
        byte[] bytes = new byte[doubles.length];
        for (int i = 0; i < doubles.length; i++) {
            bytes[i] = (byte) doubles[i];
        }

        displayImage(bytes, width, height, resizeRatio);
    }

    public static void displayImage(byte[] bytes, int width, int height, int resizeRatio) throws InterruptedException {
        ShowBitmap showBitmap = new ShowBitmap(bytes, width, height, resizeRatio);
        Thread t = new Thread(showBitmap);
        t.run();
        t.join();
    }

    private BufferedImage createRGBImage(byte[] bytes, int width, int height) {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_GRAY), null, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width, 1, new int[]{0}, null), false, null);
    }

    private void dispImg() {
        Image img = createRGBImage(bytes, width, height);
        JFrame frame = new JFrame();
        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setImg(img.getScaledInstance(width * resizeRatio, height * resizeRatio, Image.SCALE_DEFAULT));
        frame.add(imagePanel);
        frame.setLayout(null);
        imagePanel.setLocation(0, 0);
        imagePanel.setSize(width * resizeRatio, height * resizeRatio);
        imagePanel.setVisible(true);
        frame.setVisible(true);
        frame.setSize(width * resizeRatio, height * resizeRatio);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        dispImg();
    }

    public static void main(String[] argv) throws InterruptedException {
        String[] arr = imageString.split(",");
        byte[] b = new byte[arr.length];

        for (int i = 0; i < arr.length; i++) {
            b[i] = (byte) Integer.parseInt(arr[i]);
        }

        ShowBitmap.displayImage(b, 28, 28, 30);
    }

    private static final String imageString = "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,220,179,6,0,0,0,0,0,0,0,0,9,77,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,28,247,17,0,0,0,0,0,0,0,0,27,202,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,242,155,0,0,0,0,0,0,0,0,27,254,63,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,160,207,6,0,0,0,0,0,0,0,27,254,65,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,127,254,21,0,0,0,0,0,0,0,20,239,65,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,77,254,21,0,0,0,0,0,0,0,0,195,65,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,70,254,21,0,0,0,0,0,0,0,0,195,142,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,56,251,21,0,0,0,0,0,0,0,0,195,227,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,222,153,5,0,0,0,0,0,0,0,120,240,13,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,67,251,40,0,0,0,0,0,0,0,94,255,69,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,234,184,0,0,0,0,0,0,0,19,245,69,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,234,169,0,0,0,0,0,0,0,3,199,182,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,154,205,4,0,0,26,72,128,203,208,254,254,131,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,61,254,129,113,186,245,251,189,75,56,136,254,73,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,15,216,233,233,159,104,52,0,0,0,38,254,73,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,254,73,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,18,254,73,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,206,106,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,186,159,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,209,101,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0";

    private class ImagePanel extends JPanel {
        private Image img;

        public Image getImg() {
            return img;
        }

        public void setImg(Image img) {
            this.img = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, this);
        }
    }
}
