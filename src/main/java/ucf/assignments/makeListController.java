/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 alden bagarra
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.List;

public class makeListController {

    @FXML
    public TextField listName;

    @FXML
    public ListView <item> itemList;

    private item selectItem;

    ObservableList<item> items = FXCollections.observableArrayList();


    public void getItem(List<item> list){
        itemList.getItems().addAll(list);

        itemList.setCellFactory(param -> new ListCell<item>() {
            @Override
            protected void updateItem(item item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getItemName() == null || item.getDate() == null) {
                    setText(null);
                } else {
                    setText(item.getItemName()+"\tDue: "+item.getDate());
                }
            }
        });


    }

    @FXML
    public void makeItemButton(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/makeItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void finishList(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/savedLists.fxml"));

        String nameOfList = listName.getText();
        Parent root = fxmlLoader.load();

        savedListsController makeList = fxmlLoader.getController();
        makeList.addItemToList(nameOfList);

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void selectItem(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/makeItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        makeItemController itemController = fxmlLoader.getController();
        itemController.itemInformation(itemList.getSelectionModel().getSelectedItem());

        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void clearItems(ActionEvent actionEvent) {
        itemList.getItems().clear();
    }

    @FXML
    public void deleteItem(ActionEvent actionEvent) {
        int selectedItem = itemList.getSelectionModel().getSelectedIndex();
        itemList.getItems().remove(selectedItem);
    }

}
