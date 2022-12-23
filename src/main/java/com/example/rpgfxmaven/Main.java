package com.example.rpgfxmaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

     public static MediaPlayer mediaPlayer;
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("main-window.fxml"));
        StackPane stackPane=  loader.load();
        Scene scene = new Scene(stackPane, 800, 800);
                primaryStage.setScene(scene);
                primaryStage.show();
        String audio = getClass().getResource("media/main_music.wav").toString();
        Media music =  new Media(audio);
        mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
    }
}
