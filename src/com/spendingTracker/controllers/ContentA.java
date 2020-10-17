package com.spendingTracker.controllers;

import com.spendingTracker.classes.Spendings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class ContentA extends AnchorPane {

    @FXML
    TableView<Spendings> tblTransactions;
    private ObservableList<Spendings> data;

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
    }

}