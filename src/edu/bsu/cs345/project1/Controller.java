package edu.bsu.cs345.project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    public TextArea outputfield;
    public TextField gradefield;
    ArrayList<Integer> percents = new ArrayList<>();
    @SuppressWarnings("unused")
    private String finalText;
    int finalpercent=0;

    public void CalculateGrade(ActionEvent actionEvent) {
            String text=gradefield.getText();

            text.replaceAll("\\s","");
           String[] eachAssign = text.split(",");
           //Integer.parseInt(myString)

        outputfield.setText(finalText);
    }

    public void AddPercents (int grade){
        if (grade==0){
            percents.add(0);
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
    public void SummingPercents(){

        for (int i=0; i<percents.size();i++){
                    finalpercent= finalpercent+percents.get(i);
        }
    }


}
