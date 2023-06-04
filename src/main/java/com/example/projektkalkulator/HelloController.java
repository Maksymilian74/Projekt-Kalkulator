package com.example.projektkalkulator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloController {
    @FXML private Pane titlePane;
    @FXML private Label buttonResult;
    @FXML private ImageView buttonMinimize;
    @FXML private ImageView buttonClose;

    private double x, y;
    private double num1 = 0;
    private String operator = "+";

    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        buttonClose.setOnMouseClicked(mouseEvent -> stage.close());
        buttonMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
        void onNumberClicked(MouseEvent event) {
            int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("button",""));
            buttonResult.setText(Double.parseDouble(buttonResult.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(buttonResult.getText())*10+value));
    }

    @FXML
        void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("button","");
        if(symbol.equals("Equals")) {
            double num2 = Double.parseDouble(buttonResult.getText());
            switch (operator) {
                case "+" -> buttonResult.setText((num1 + num2) + "");
                case "-" -> buttonResult.setText((num1 - num2) + "");
                case "*" -> buttonResult.setText((num1 * num2) + "");
                case "/" -> buttonResult.setText((num1 / num2) + "");
            }
            operator = ".";
        } else if (symbol.equals("Clear")) {
            buttonResult.setText(String.valueOf("0.0"));
            operator = ".";
        } else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
            }
            num1 = Double.parseDouble(buttonResult.getText());
            buttonResult.setText(String.valueOf(0.0));
        }
    }



}