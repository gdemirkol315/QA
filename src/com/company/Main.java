package com.company;


import java.util.ArrayList;

//TODO: Implement GUI, integrate QA to GUI

public class Main  {

    public static void main(String[] args) {

        QAParser qaParser = new QAParser();
        ArrayList<QA> qas = qaParser.parseQAs();
        for (int i = 0; i < qas.size(); i++) {
            System.out.println("Question " + (i + 1) + ":\n" +
                    qas.get(i).getQuestion());
            System.out.println("Answer " + (i + 1) + ":\n" +
                    qas.get(i).getAnswer());
            System.out.println("-------------------------------------\n");
        }
    }


}
