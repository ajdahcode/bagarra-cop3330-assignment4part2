/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 alden bagarra
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class item {
    private SimpleStringProperty itemName, itemDescription;
    private LocalDate date;

    public item(String itemName, LocalDate date){
        this.itemName = new SimpleStringProperty(itemName);
        this.date = date;
    }

    public item(String itemName, String itemDescription, LocalDate date){
        this.itemName = new SimpleStringProperty(itemName);
        this.itemDescription = new SimpleStringProperty(itemDescription);
        this.date = date;
    }

    public String getItemName() {
        return itemName.get();
    }

    public void setItemName(String itemName) {
        this.itemName = new SimpleStringProperty(itemName);
    }

    public String getItemDescription() {
        return itemDescription.get();
    }

    public void setItemDescription(String itemDescription) {
        this.itemName = new SimpleStringProperty(itemDescription);
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }


}
