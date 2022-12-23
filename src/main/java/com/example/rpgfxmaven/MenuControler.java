package com.example.rpgfxmaven;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuControler {

    private GameControler gameControler = new GameControler();
    private MainWindowControler mainWindowControler;
    private Stage primaryStage = new Stage();


    public void setMainWindowControler(MainWindowControler mainWindowControler) {
        this.mainWindowControler = mainWindowControler;
    }

    @FXML
    public void initialize() {}

    @FXML
    public void options_clicked(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("options-view.fxml"));
        AnchorPane optionspane = null;
        try {
            optionspane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String css = this.getClass().getResource("styles.css").toExternalForm();
        optionspane.getStylesheets().add(css);
        OptionsControler optionsControler = loader.getController();
        optionsControler.setMainWindowControler(mainWindowControler);
        mainWindowControler.setScreen(optionspane);
    }
    @FXML
    public void newgame_clicked() {
    Main.mediaPlayer.stop();
        try {
            gameControler.start(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void exit_clicked(){
        Platform.exit();
    }


}