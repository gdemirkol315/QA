package com.company;


import java.util.ArrayList;

//TODO: Implement GUI, integrate QA to GUI

public class Main  {

    public static void main(String[] args) {
        QAParser qaParser = new QAParser();
        ArrayList<QA> qas = qaParser.parseQAs();
        GUI gui = new GUI(qas,false);
        }


}
