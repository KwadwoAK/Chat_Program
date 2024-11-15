package dev.KwadwoAK.Windows;

import javax.swing.*;
import java.awt.*;

public class AntFrame extends JFrame {
    JButton antButton = new JButton("Chat Model");
    JButton visionButton = new JButton("Vision Model");
    JLabel introLabel = new JLabel("Welcome to the Anthropic Chat Program please select a model to use ");
    ImageIcon antIcon = new ImageIcon("images/ant.png");
    //ImageIcon antIconScaled = new ImageIcon(antIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    ImageIcon visionIcon = new ImageIcon("images/visions.png");
    ImageIcon visionIconScaled = new ImageIcon(visionIcon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));
    ImageIcon chatIcon = new ImageIcon("images/chats.png");
    ImageIcon chatIconScaled = new ImageIcon(chatIcon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));


    public AntFrame(){
        //Intro Label
        introLabel.setBounds(50, 0, 900, 400);
        introLabel.setHorizontalAlignment(JLabel.CENTER);
        introLabel.setFont(new Font(null, Font.BOLD, 25));
        introLabel.setIcon(antIcon);
        introLabel.setHorizontalTextPosition(JLabel.CENTER);
        introLabel.setVerticalTextPosition(JLabel.BOTTOM);

        //Anthropic Button
        antButton.setBounds(100, 400, 200, 200);
        antButton.setFont(new Font(null, Font.BOLD, 18));
        antButton.setIcon(chatIconScaled);
        antButton.setVerticalTextPosition(JButton.BOTTOM);
        antButton.setHorizontalTextPosition(JButton.CENTER);

        //Vision Button
        visionButton.setBounds(700, 400, 200, 200);
        visionButton.setFont(new Font(null, Font.BOLD, 18));
        visionButton.setIcon(visionIconScaled);
        visionButton.setVerticalTextPosition(JButton.BOTTOM);
        visionButton.setHorizontalTextPosition(JButton.CENTER);

        this.setTitle("Anthropic Chat Program");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 800);
        this.setLayout(null);
        this.add(introLabel);
        this.add(antButton);
        this.add(visionButton);
        this.setVisible(true);


    }

}
