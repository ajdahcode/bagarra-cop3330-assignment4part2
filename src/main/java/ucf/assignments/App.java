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
    // Launch Application
    public static void main(String[] args) {
        launch();
    }

    // Creates the first stage of the Application
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/startList.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }

}
