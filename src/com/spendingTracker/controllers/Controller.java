package com.spendingTracker.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    BorderPane mainPane;
    ContentA contentA;
    ContentB contentB;

    public Controller() {
        contentA = new ContentA();
        contentB = new ContentB(contentA.getData());
    }

    @FXML
    public void onBtnAClick(){
        //ContentA contentA = new ContentA();
        mainPane.setCenter(contentA);
    }

    @FXML
    public void onBtnBClick(){
        mainPane.setCenter(contentB);
    }

    @FXML
    public void onBtnCClick(){
        ContentC contentC = new ContentC();
        mainPane.setCenter(contentC);
    }

}