package com.example.rpgfxmaven;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class OptionsControler {


    @FXML
    private Slider volumeSlider;



    private MainWindowControler mainWindowControler;

    public void setMainWindowControler(MainWindowControler mainWindowControler) {
        this.mainWindowControler = mainWindowControler;
    }
    @FXML
    public void backButton(ActionEvent actionEvent) {
        mainWindowControler.loadMenuScreen();
    }

    @FXML
    public void initialize() {

        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Main.mediaPlayer.setVolume(volumeSlider.getValue()/100);
            }
        });
    }

}
