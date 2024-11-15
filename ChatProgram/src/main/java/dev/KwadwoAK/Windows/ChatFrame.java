package dev.KwadwoAK.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatFrame extends JFrame implements ActionListener {
    JButton chatButton = new JButton("Chat Model");
    JButton visionButton = new JButton("Vision Model");
    JLabel introLabel = new JLabel("Welcome to the Chat Program please select a model to use ");
    ImageIcon chatIcon = new ImageIcon("images/chats.png");
    ImageIcon chatIconScaled = new ImageIcon(chatIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    ImageIcon visionIcon = new ImageIcon("images/visions.png");
    ImageIcon visionIconScaled = new ImageIcon(visionIcon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));
    ImageIcon aiIcon = new ImageIcon("images/ai.png");


    public ChatFrame() {
        //Intro Label
        introLabel.setBounds(50, 0, 900, 400);
        introLabel.setHorizontalAlignment(JLabel.CENTER);
        introLabel.setFont(new Font(null, Font.BOLD, 28));
        introLabel.setIcon(aiIcon);
        introLabel.setHorizontalTextPosition(JLabel.CENTER);
        introLabel.setVerticalTextPosition(JLabel.BOTTOM);

        //Chat Button
        chatButton.setBounds(100, 400, 200, 200);
        chatButton.setFont(new Font(null, Font.BOLD, 18));
        chatButton.setIcon(chatIconScaled);
        chatButton.setVerticalTextPosition(JButton.BOTTOM);
        chatButton.setHorizontalTextPosition(JButton.CENTER);
        chatButton.addActionListener(this);


        //Vision Button
        visionButton.setBounds(700, 400, 200, 200);
        visionButton.setFont(new Font(null, Font.BOLD, 18));
        visionButton.setIcon(visionIconScaled);
        visionButton.setVerticalTextPosition(JButton.BOTTOM);
        visionButton.setHorizontalTextPosition(JButton.CENTER);
        visionButton.addActionListener(this);


        this.setTitle("Chat Program");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 800);
        this.setLayout(null);
        this.add(introLabel);
        this.add(chatButton);
        this.add(visionButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == chatButton) {
            this.dispose();
            new ChatWindow();
        }
        else if(actionEvent.getSource() == visionButton) {
            this.dispose();
            new VisionWindow();
        }
    }
}

