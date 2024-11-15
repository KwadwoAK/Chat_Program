package dev.KwadwoAK.Windows;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ImageDisplay {
    JFrame frame = new JFrame("Image Display");
    JPanel panel = new JPanel();

    public ImageDisplay(URI uri)  {
        try {
            URL url = uri.toURL();
            ImageIcon image = new ImageIcon(url);
            JLabel label = new JLabel(image);
            panel.add(label);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        panel.setSize(800, 600);
        panel.setBounds(0, 0, 800, 600);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
