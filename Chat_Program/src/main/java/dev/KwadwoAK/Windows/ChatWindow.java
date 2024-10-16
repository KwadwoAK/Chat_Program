package dev.KwadwoAK.Windows;

import dev.KwadwoAK.GPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements ActionListener {
    GPT gpt = new GPT();
    JFrame frame = new JFrame("Chat Model");
    JLabel label = new JLabel("Enter your prompt:");
    JTextField textField = new JTextField();
    JButton button = new JButton("Submit");

    public ChatWindow() {
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
        frame.pack();
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button) {
            String text = textField.getText();
            String message = gpt.chatWithString(text);
            this.dispose();
            new ChatDisplay(message);


        }
    }
}
