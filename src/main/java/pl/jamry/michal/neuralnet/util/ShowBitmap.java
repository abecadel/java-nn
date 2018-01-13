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
