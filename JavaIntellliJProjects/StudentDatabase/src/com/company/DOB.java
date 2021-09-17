package com.company;

public class DOB {
    private String date, month, year;

    public void setDOB(String date, String month, String year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getDOB() {
        return date +"-"+ month +"-"+ year;
    }
}
