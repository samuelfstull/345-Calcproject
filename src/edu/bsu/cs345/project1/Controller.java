package edu.bsu.cs345.project1;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public TextArea outputfield;
    public TextField gradefield;
    private ArrayList<Integer> percents = new ArrayList<>();
    private int finalpercent=0;

    @SuppressWarnings({"unused", "ForLoopReplaceableByForEach"})//for required and unused for action event
    public void CalculateGrade(ActionEvent actionEvent) {
        try {
            ArrayList<Integer> integers = stringToArrayList(gradefield);

            percents.clear();
            finalpercent = 0;
            for (int x = 0; x < integers.size(); x++) {
                AddPercents(integers.get(x));
            }
            SummingPercents();
            outputfield.setText(Integer.toString(finalpercent) + "%");
        }
        catch (Exception e){
            outputfield.setText("error");
        }
    }

    private void AddPercents (int grade){
        if (grade==0){
            percents.add(45);
        }
        else if (grade==1){
            percents.add(60);
        }
        else if (grade==2){
            percents.add(75);
        }
        else if (grade==3){
            percents.add(100);
        }

    }
    @SuppressWarnings("ForLoopReplaceableByForEach")//the value of i is needed
    private void SummingPercents(){
        int size=percents.size();
        for (int i=0; i<size;i++){
                    finalpercent= finalpercent+percents.get(i);
        }
        finalpercent= finalpercent/size;
    }
    private ArrayList<Integer> stringToArrayList(TextField textField){
        ArrayList<Integer> tokens = new ArrayList<>();

        try{
            String userInput = textField.getText();
            Scanner scanner = new Scanner(userInput);
            scanner.useDelimiter("[,]");

            while (scanner.hasNext()){
                String string = scanner.next();
                string = string.replace(" ", "");
                string = string.replace("{", "");
                string = string.replace("}", "");
                string = string.replace(" ", "");
                string = string.replaceAll("\\p{P}", "");
                int integer = Integer.parseInt(string);
                tokens.add(integer);
            }
        }
        catch (Exception e){
            //MainViewController.infoBox("Invalid input", "NOTICE!");
            return tokens;
        }
        return tokens;
    }


}
