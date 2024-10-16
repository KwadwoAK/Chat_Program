package dev.KwadwoAK.Windows;

import dev.KwadwoAK.GPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static dev.KwadwoAK.ImageURLValidator.isValidImageUrl;

public class VisionWindow extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Vision Model");
    GPT gpt = new GPT();
    JLabel label = new JLabel("Enter a valid image URL:");
    JTextField textField = new JTextField();
    JButton button = new JButton("Submit");



    public VisionWindow() {
        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 20));
        label.setVerticalAlignment(JLabel.TOP);
        textField.setBounds(0, 50, 800, 50);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField.setBackground(Color.WHITE);
        label.add(textField);
        button.setBounds(300, 200, 100, 50);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.addActionListener(this);
        label.add(button);


        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button) {
            String imageUrl = textField.getText();
            if (!isValidImageUrl(imageUrl)) {
                JOptionPane.showMessageDialog(null, "Invalid URL. Please enter a valid image URL, either a png or jpg or webp file example(https://example.com/image.png:"
                + "\nIf you are having trouble with image, make sure your URL ends with .png, .jpg, or .webp "
                + "\nIf you are using a valid format check your URL and add the correct format as .png, .jpg, or .webp at the end "
                + "\nIf you are still having trouble, try using a different image URL", "Invalid URL", JOptionPane.ERROR_MESSAGE);
                imageUrl = textField.getText();
            }
            String message = gpt.visionChat(imageUrl);
            this.dispose();
            new ChatDisplay(message);

        }
    }
}
