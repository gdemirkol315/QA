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

    //TODO add flag to GUI for flagging a question, flag/unflag questions with actions
    // then add another button for calling all flagged questions

    public GUI(ArrayList<QA> qas, boolean questionsRandomized) {
        this.qas = qas;
        frame = new JFrame();
        panel = new JPanel();
        qLabel = new JLabel("Question:\n" + qas.get(qCounter).getQuestion());
        aLabel = new JLabel();
        aEntryField = new JTextField();
        qCounter++;
        nextButton = new JButton("Next Question");
        hintButton = new JButton("Hint");

        hintButton.addActionListener(this);
        nextButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
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

        if (guiAction.equals(GUIAction.HINT)) {
            aLabel.setText("Answer:\n" + qas.get(qCounter).getAnswer());

        } else if (guiAction.equals(GUIAction.NEXT_QUESTION)) {
            qCounter++;
            qLabel.setText("Question:\n" + qas.get(qCounter).getQuestion());
            aLabel.setText("");
        } else if (guiAction.equals(GUIAction.FLAG)) {

        }

    }
}
