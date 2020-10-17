package com.spendingTracker.controllers;

import com.spendingTracker.classes.Spendings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ContentB extends AnchorPane {
    @FXML
    ComboBox<String> comboSelectCategory;
    @FXML
    TextField txtAmount;


    ObservableList<Spendings> data;
    public ContentB(ObservableList<Spendings> data){
        this.data = data;
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
    @FXML
    public void onBtnClickAdd(){
        data.add(new Spendings("2020-10-18",txtAmount.getText(),comboSelectCategory.getSelectionModel().getSelectedItem()));
        System.out.println("Add button clicked with " + txtAmount.getText() + " and category " + comboSelectCategory.getSelectionModel().getSelectedItem());
    }



}