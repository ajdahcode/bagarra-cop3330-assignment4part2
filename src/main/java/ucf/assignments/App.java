/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 alden bagarra
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    /*
    Start of Notes:

    void list{
        while (list hasn't been created){
            create a max 100 unique to-do list

            title function for title of to-do list;

            for every to-do list{
                max 100 items
                item_description for item
            }
        }
    }

    public title (input){
        should take in a title given by input
        returns the title
    }

    public item_description(description){
        input of the due date: (YYYY-MM-DD)
        string of description with due-date;
        returns the string of description
    }


    void process{
//        this function will have the user inputs where we can
//        add, remove, edit, mark, display, save, and load
//        suggested by the assignment

        if the user wants to add{
            add the item into list
        }
        else (the user wants to delete){
            delete the item from list
        }
        if the user wants to mark and display{
            mark and display the item from the list
        }
        if the user wants to save{
            save the items from list
        }
        if the user wants to load{
            load the items into list
        }
    }

     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/as4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
