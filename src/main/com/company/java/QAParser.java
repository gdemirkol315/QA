package main.com.company.java;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QAParser {

    final private static String Q_REGEX = "(Q[0-9]{3}:)(.*)";
    final private static String A_REGEX = "(A[0-9]{3}:)(.*)";
    final private static Pattern Q_PATTERN = Pattern.compile(Q_REGEX);
    final private static Pattern A_PATTERN = Pattern.compile(A_REGEX);

    public ArrayList<QA> parseQAs() {

        String readLine;
        String question = new String();
        String answer = new String();
        QA qa;
        ArrayList<QA> parsedQAs = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/questions.txt")));
            readLine = reader.readLine();
            while (readLine != null) {
                qa = new QA();
                while (!readLine.matches(A_REGEX)) {
                    if (readLine.matches(Q_REGEX)) {
                        Matcher qMatcher = Q_PATTERN.matcher(readLine);
                        if(qMatcher.find()) {
                            question = qMatcher.group(2);
                        }
                        readLine = reader.readLine();
                    } else {
                        question = question + " " + readLine;
                        readLine = reader.readLine();
                    }
                }
                qa.setQuestion(question);

                while (!readLine.matches(Q_REGEX)) {
                    if (readLine.matches(A_REGEX)) {
                        Matcher aMatcher = A_PATTERN.matcher(readLine);
                        if (aMatcher.find()) {
                            answer = aMatcher.group(2);
                        }
                    } else {
                        answer = answer + " " + readLine;
                    }
                    readLine = reader.readLine();
                    if (readLine==null) {
                        break;
                    }
                }
                qa.setAnswer(answer);
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

