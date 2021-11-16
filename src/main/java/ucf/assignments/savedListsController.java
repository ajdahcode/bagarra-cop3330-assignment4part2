/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 alden bagarra
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.List;

public class savedListsController {
    @FXML
    public ListView <String> todoList;

    FileChooser fileChooser = new FileChooser();

    public void addItemToList(String listName){
        todoList.getItems().add(listName);
    }

    public void newList(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/startList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void saveApp(ActionEvent actionEvent) {

        Window stage = todoList.getScene().getWindow();
        fileChooser.setTitle("Save List");
        fileChooser.setInitialFileName("mysave");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("text file", "*.txt"));

        File file = fileChooser.showSaveDialog(stage);
        fileChooser.setInitialDirectory(file.getParentFile());
    }

    public void loadList(ActionEvent actionEvent) {
        Window stage = todoList.getScene().getWindow();
        fileChooser.setTitle("Load List");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("text file", "*.txt"));

        File file = fileChooser.showOpenDialog(stage);
        List<File> listOfFile = fileChooser.showOpenMultipleDialog(stage);
        fileChooser.setInitialDirectory(file.getParentFile());
    }
}
