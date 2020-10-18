package com.spendingTracker.controllers;

import com.spendingTracker.classes.Spendings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ContentA extends AnchorPane {

    @FXML
    TableView<Spendings> tblTransactions;
    private ObservableList<Spendings> data;
    @FXML
    ComboBox<String> comboSelectCategory;
    @FXML
    TextField txtAmount;
    @FXML
    DatePicker datePicker;

    public ObservableList<Spendings> getData() {
        return data;
    }

    public void setData(ObservableList<Spendings> data) {
        this.data = data;
    }

    public ContentA() {
        this.data = FXCollections.observableArrayList();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/spendingTracker/fxml/ContentA.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            TableColumn<Spendings, String> dateCol = new TableColumn<>("Date");
            dateCol.setCellValueFactory(new PropertyValueFactory<>("Date"));
            TableColumn<Spendings, String> amountCol = new TableColumn<>("Amount");
            amountCol.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            TableColumn<Spendings, String> categoryCol = new TableColumn<>("Category");
            categoryCol.setCellValueFactory(new PropertyValueFactory<>("Category"));


            data.add(new Spendings("2020-10-17", "100", "Fueling"));
            data.add(new Spendings("2020-10-17", "200", "Grocery"));
            data.add(new Spendings("2020-10-17", "300", "Fueling"));
            data.add(new Spendings("2020-10-17", "400", "Fueling"));

            dateCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));
            amountCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAmount()));
            categoryCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
            tblTransactions.setItems(data);
            tblTransactions.getColumns().addAll(dateCol, amountCol, categoryCol);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            comboSelectCategory.getItems().clear();
            Path path = Paths.get("src/com/spendingTracker/files/categories.txt");
            List<String> categoryList = Files.lines(path).collect(Collectors.toList());
            comboSelectCategory.setItems(FXCollections.observableArrayList(categoryList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onBtnClickAdd() {

        if (datePicker.getValue() != null && !txtAmount.getText().isEmpty() && comboSelectCategory.getSelectionModel().getSelectedItem() != null) {
            this.data.add(new Spendings(datePicker.getValue().toString(), txtAmount.getText(), comboSelectCategory.getSelectionModel().getSelectedItem()));
            comboSelectCategory.getSelectionModel().clearSelection();
            txtAmount.clear();
            datePicker.setValue(null);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Fill amount and select category and date!");
            alert.showAndWait();
        }

//        System.out.println("Add button clicked with " + txtAmount.getText() + " and category " + comboSelectCategory.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void onBtnClickRemove() {
        if (tblTransactions.getSelectionModel().getSelectedItem() != null) {
            System.out.println("removed item + " + tblTransactions.getSelectionModel().getSelectedItem().toString());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to remove this row from your spendings?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(okButton, noButton);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == okButton) {
                System.out.println("Yes pressed");
                this.data.remove(tblTransactions.getSelectionModel().getSelectedItem());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Select a row to remove it!");
            alert.showAndWait();
        }

    }

}