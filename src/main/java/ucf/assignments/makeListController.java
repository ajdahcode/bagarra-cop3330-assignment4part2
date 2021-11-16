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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class makeListController {

    @FXML
    public TextField listName;

    @FXML
    public ListView <item> itemList;



    ObservableList<item> items = FXCollections.observableArrayList();

    @FXML
    public void getItem(String item){
//        items.addAll(item);
//        itemList.setItems(items);

//        items.add(item.getItemName());
//        items.add(item.getDate().toString());

        items.add();
        itemList.getItems().addAll(item);

//        make 100 items in one list
//        items = itemList.getItems();
//        for(int i = 0; i < 100; i++){
//            if(!items.contains(item)){
//                itemList.getItems().addAll(item);
//            }
//        }

//        itemList.getItems().addAll(item);


//        stringSet.add(item);
//        items.setAll(stringSet);
//        itemList.setItems(items);
//        itemList.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
//        {
//            @Override
//            public ListCell<String> call(ListView<String> listView)
//            {
//                return new ListViewCell();
//            }
//        });
//        items.add(item);
//        itemList.setItems(items);


//        addNewItem.setOnAction((actionEvent) ->
//        {
//            try
//            {
//                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/makeItem.fxml"));
//                Stage secondStage = new Stage();
//                secondStage.setScene(new Scene(addNewItemLoader.load()));
//                SecondaryController addNewItemController = addNewItemLoader.getController();
//                secondStage.showAndWait();
//                Optional<String> result = addNewItemController.getNewItem();
//                if (result.isPresent()){
//                    System.out.println("Your name: " + result.get());
//                    eventsList.add(result.get());
//                }
//            }
//            catch (IOException e)
//            {
//                System.out.println(e.toString());
//            }
//        });

//        itemList.getItems().add(item);

//        if(itemList == null){
//            itemList.setItems(items);
//        }
//        items.add(item);


//        ArrayList <String> stringItems = new ArrayList();
//        stringItems.add(item);
//        for(String items: stringItems){
//            itemList.getItems().add(items);
//        }
//        itemList.getItems().forEach(i->System.out.println(i));

        // make 100 items in one list
//        for(int i = 0; i < 100; i++){
//            while(!item.equals(item)){
//                itemList.getItems().addAll(item);
//            }
//
//        }
    }

    public void makeListOfItems(){

    }

    @FXML
    public void makeItemButton(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/makeItem.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();



        
//        itemList.getItems().add(getItem());
//        getItem();
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

        makeItemController itemController = fxmlLoader.getController();
        itemController.itemInformation(itemList.getSelectionModel().getSelectedItem());

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
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
