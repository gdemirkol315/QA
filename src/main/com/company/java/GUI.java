package main.com.company.java;

import main.com.company.java.utils.Converter;
import main.com.company.java.utils.GUIAction;

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
    private static ArrayList<QA> qas;

    //TODO add flag button to GUI for flagging a question
    //TODO flag/unflag questions with actions
    //TODO add another button for calling all flagged questions
    //TODO optimize GUI Layout (increase label size, make it more readable, etc.)

    public GUI(ArrayList<QA> qas, boolean questionsRandomized) {
        this.qas = qas;
        frame = new JFrame();
        panel = new JPanel();
        qLabel = new JLabel("<html>Question:<br>" + addNewLines(qas.get(qCounter).getQuestion()) + "</html>");
        aLabel = new JLabel();
        aEntryField = new JTextField();
        qCounter++;
        nextButton = new JButton("Next Question");
        hintButton = new JButton("Hint");

        hintButton.addActionListener(this);
        nextButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(qLabel);
        panel.add(aEntryField);
        panel.add(hintButton);
        panel.add(nextButton);
        panel.add(aLabel);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exam Practice");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GUIAction guiAction = GUIAction.INITIAL_STATE;
        guiAction = Converter.getAction(e.getActionCommand());
        String label;
        if (guiAction.equals(GUIAction.HINT)) {
            label = addNewLines(qas.get(qCounter).getAnswer());
            aLabel.setText("<html>Answer:<br>" + label + "</html>");

        } else if (guiAction.equals(GUIAction.NEXT_QUESTION)) {
            qCounter++;
            label = addNewLines(qas.get(qCounter).getQuestion());
            qLabel.setText("<html>Question:<br>" + label + "</html>");
            aLabel.setText("");
        } else if (guiAction.equals(GUIAction.FLAG)) {

        }
    }

    private String addNewLines(String label) {
        String adjustedLabel = label;
        int charCount = Math.toIntExact(adjustedLabel.chars().count());
        int newLineCharCount = 100;
        while (charCount > newLineCharCount) {
            adjustedLabel = adjustedLabel.substring(0, charCount) + "<br>" +
                    adjustedLabel.substring(charCount, (int) adjustedLabel.chars().count());
            charCount = charCount - newLineCharCount;
        }

        return adjustedLabel;

    }
}
