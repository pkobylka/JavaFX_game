package com.example.rpgfxmaven;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainWindowControler {
    @FXML
private StackPane mainStackPane;
    @FXML
    public void initialize() {
    loadMenuScreen();
    }


    public void loadMenuScreen(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("menu-view.fxml"));
        AnchorPane mainpane = null;
        try {
            mainpane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuControler menuControler = loader.getController();
        menuControler.setMainWindowControler(this);
        setScreen(mainpane);
        String css = this.getClass().getResource("styles.css").toExternalForm();
        mainpane.getStylesheets().add(css);
    }

    public void setScreen(AnchorPane pane)
    {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
