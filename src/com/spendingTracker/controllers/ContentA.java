package com.spendingTracker.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class ContentA extends AnchorPane {

    public ContentA(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/spendingTracker/fxml/ContentA.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}