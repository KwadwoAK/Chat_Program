package dev.KwadwoAK.Windows;

import javax.swing.*;
import java.awt.*;

public class ChatDisplay {
    JFrame frame = new JFrame("Chat Display");
    JPanel panel = new JPanel();
    JTextArea chatArea = new JTextArea(20,30);
    JButton button = new JButton("Submit Another Prompt");
    JButton button2 = new JButton("Go Back to Main Page");
    JButton button3 = new JButton("Exit");
    JScrollBar scrollBar = new JScrollBar(Adjustable.VERTICAL);
    JScrollPane scrollPane = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public ChatDisplay(String message){

        panel.setSize(800, 600);
        panel.setBounds(0, 0, 800, 600);

        //Button Settings
        button.setBounds(300, 200, 200, 50);
        button2.setBounds(300, 300, 200, 50);
        button3.setBounds(300, 400, 200, 50);
        button.addActionListener(e -> {new ChatWindow();frame.dispose();});
        button2.addActionListener(e -> {new ChatFrame();frame.dispose();});
        button3.addActionListener(e -> {System.exit(0);});



        //Text Display Settings
        //chatArea.setBounds(0, 0, 700, 300);
        chatArea.setFont(new Font(null, Font.PLAIN, 20));
        chatArea.setText(message);
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        //chatArea.add(scrollBar);



        panel.add(scrollPane);
        //panel.add(chatArea);
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        //frame.add(scrollPane);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

    }
}
