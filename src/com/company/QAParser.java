package com.company;

import java.io.*;
import java.util.ArrayList;

//TODO: fix parsing
public class QAParser {

    private Object OutputStream;
    final private static String Q_PATTERN = "Q[0-9]{3}:.*";
    final private static String A_PATTERN = "A[0-9]{3}:.*";

    public ArrayList<QA> parseQAs() {

        String nextLine;
        String question = new String();
        String answer = new String();
        QA qa;
        ArrayList<QA> parsedQAs = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/questions.txt")));
            nextLine = reader.readLine();
            while (nextLine != null) {
                qa = new QA();
                while (!nextLine.matches(A_PATTERN)) {
                    if (nextLine.matches(Q_PATTERN)) {
                        question = nextLine;
                        nextLine = reader.readLine();
                    } else {
                        question = question + " " + nextLine;
                        nextLine = reader.readLine();
                    }
                }
                qa.setQuestion(question);

                while (!nextLine.matches(Q_PATTERN)) {
                    if (nextLine.matches(A_PATTERN)) {
                        answer = nextLine;
                        nextLine = reader.readLine();
                    } else {
                        answer = answer + " " + nextLine;
                        nextLine = reader.readLine();
                    }
                }
                qa.setAnswer(question);
                parsedQAs.add(qa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedQAs;
    }
}

