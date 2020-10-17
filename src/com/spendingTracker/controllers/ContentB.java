package com.spendingTracker.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ContentB extends AnchorPane {
    @FXML
    ComboBox<String> comboSelectCategory;

    public ContentB(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/spendingTracker/fxml/ContentB.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            comboSelectCategory.getItems().clear();
            Path path = Paths.get("src/com/spendingTracker/files/categories.txt");
            List<String> categoryList = Files.lines(path).collect(Collectors.toList());
            comboSelectCategory.setItems(FXCollections.observableArrayList(categoryList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}