/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 alden bagarra
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class makeItemController {

    @FXML
    public TextField nameOfItem;
    @FXML
    public TextArea descriptionOfItem;
    @FXML
    public DatePicker datePicker;

    private item selectedItem;

//    descriptionOfItem.setOnKeyTyped(event ->{
//        int maxCharacters = 5;
//        if(tfInput.getText().length() > maxCharacters) event.consume();
//    });

    public void setDescriptionMaxChar() {
        // Set the maximum characters to 256
        descriptionOfItem.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 256 ? change : null));
    }

    public void itemInformation(item item){
        selectedItem = item;
        nameOfItem.setText(selectedItem.getItemName());
        descriptionOfItem.setText(selectedItem.getItemDescription());
        datePicker.setAccessibleText(selectedItem.getDate().toString());
    }

    public void saveThisItem(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/makeList.fxml"));

        // Save information of item name
        String itemName = nameOfItem.getText();
        // Save information of Date
        String date = String.valueOf(datePicker.getValue());
        // Save information of description
        String itemDescription = descriptionOfItem.getText();


        Parent root = fxmlLoader.load();


        // Send information to the other controller
        makeListController makeList = fxmlLoader.getController();
        makeList.getItem(itemName+"\tDue: "+date);


        /* try to do if date is null return "no date" */
//        if(date == null){
//            makeList.makeListOfItems(itemName+"\tDue: no date");
//        }
//        else if (date != null){
//            makeList.makeListOfItems(itemName+"\tDue: "+date);
//        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}