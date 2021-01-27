package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel qLabel;
    private JLabel aLabel;

    public GUI() {
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Next question");
        qLabel = new JLabel("Question: Q");
        aLabel = new JLabel("Answer: A");

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(qLabel);
        panel.add(aLabel);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exam Practice");
        frame.pack();
        frame.setVisible(true);

        //JButton.addActionListener();
    }
    public static void main(String[] args) {
        //GUI g = new GUI();
        QAParser qaParser = new QAParser();
        ArrayList<QA> qas = qaParser.parseQAs();
        for (QA qa:qas){
            qa.getQuestion();
            qa.getAnswer();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
