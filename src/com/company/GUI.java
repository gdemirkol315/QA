package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JButton nextButton;
    private static JButton hintButton;
    private static JLabel qLabel;
    private static JLabel aLabel;
    private static JTextField aEntryField;
    private static int qCounter;

    public GUI(ArrayList<QA> qas, boolean questionsRandomized) {
        frame = new JFrame();
        panel = new JPanel();
        qLabel = new JLabel("Question:\n" + qas.get(qCounter).getQuestion());
        aLabel = new JLabel("Answer:\n" + qas.get(qCounter).getAnswer());
        aEntryField = new JTextField();
        qCounter++;
        nextButton = new JButton("Next Question");
        hintButton = new JButton("Hint");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(qLabel);
        panel.add(aEntryField);
        panel.add(hintButton);
        panel.add(nextButton);

        hintButton.addActionListener(this);
        nextButton.addActionListener(this);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exam Practice");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Hint")) {
            panel.add(aLabel);
            frame.add(panel);


        }


    }
}
