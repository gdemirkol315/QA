package main;


import main.com.company.java.GUI;
import main.com.company.java.QA;
import main.com.company.java.QAParser;

import java.util.ArrayList;

public class Main  {

    public static void main(String[] args) {
        QAParser qaParser = new QAParser();
        ArrayList<QA> qas = qaParser.parseQAs();
        GUI gui = new GUI(qas,false);
        }
}
