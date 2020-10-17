package com.spendingTracker.classes;

import java.util.Date;

public class Spendings {
    private String date;
    private String amount;
    private String category;

    public Spendings(String date, String amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}
