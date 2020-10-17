package com.spendingTracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    BorderPane mainPane;



    @FXML
    public void onBtnAClick(){
        ContentA contentA = new ContentA();
        mainPane.setCenter(contentA);
    }

    @FXML
    public void onBtnBClick(){
        ContentB contentB = new ContentB();
        mainPane.setCenter(contentB);
    }

    @FXML
    public void onBtnCClick(){
        ContentC contentC = new ContentC();
        mainPane.setCenter(contentC);
    }

}