package com.example.rpgfxmaven;

import com.example.rpgfxmaven.characters.Monster;
import com.example.rpgfxmaven.characters.Player;
import com.example.rpgfxmaven.logic.CollisionChecker;
import com.example.rpgfxmaven.maps.Map_Manager;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameControler {

    public static final int screen_length = 550;
    public static final int screen_width = 550;

    //rysowanie mapy
    Map_Manager map = new Map_Manager(this);

    //klasa kolizji
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    public Player hero;

    @FXML
    BorderPane borderpane;
    @FXML
    Canvas canvaspane;


    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("maingame-window.fxml"));
        borderpane =  loader.load();
        Scene scene = new Scene(borderpane);
        stage.setScene(scene);

        //ustawienia canvasa
        canvaspane = new Canvas(screen_length,screen_width);
        GraphicsContext content = canvaspane.getGraphicsContext2D();
        borderpane.setCenter(canvaspane);
        content.setFill(Color.GREEN);
        content.fillRect(0,0, map.world_length,map.world_width);

        //tworzymy bohaterq i przeciwników
        String css_monster = getClass().getResource("media/test3.png").toString();
        String css_castle = getClass().getResource("media/test4.png").toString();
        String css_hero1 = getClass().getResource("media/test1.png").toString();
        String css_hero2 = getClass().getResource("media/test2.png").toString();


//        Towns castle = new Towns();
//        castle.position.set(100, 1);
//        castle.setImage(css_castle);
//        castle.draw(content);

        hero = new Player(map,10, 10, this);
        hero.setImagePath(hero.image1, css_hero1, hero.image2, css_hero2);
        hero.setImage(css_hero1);
        hero.render(content);

        //rysowanie przeciwników
        ArrayList<Monster> skeletons = new ArrayList<>();
        int skeletonsCounter = 5;
        for (int n=0; n<skeletonsCounter; n++)
        {
            Monster skeleton = new Monster(200, 200, 15);
            double x = (Math.random()*321)+100;
            double y = (Math.random()*364)+231;
            skeleton.setPosition(x,y);
            skeleton.setImage(css_monster);
            skeletons.add(skeleton);
        }

        //lista do której będziemy wrzucać który przycisk przycisneliśmy
        ArrayList<String> inputList = new ArrayList<>();

        //eventy przycisków
        scene.setOnKeyPressed(
                (KeyEvent event) ->
                {
                    String keyName= event.getCode().toString();
                    if(!inputList.contains(keyName))
                        inputList.add(keyName);
                }
        );

        scene.setOnKeyReleased(
                (KeyEvent event) ->
                {
                    String keyName= event.getCode().toString();
                        inputList.remove(keyName);
                }
        );


        //gameloop
        AnimationTimer gameloop = new AnimationTimer() {
            private long lastUpdate = 0 ;
            @Override
            public void handle(long a) {
                if (a - lastUpdate >= 500000000)
                {
                    if (inputList.contains("LEFT")) {
                        hero.bodyPositionTimer++;
                        hero.direction = "up";
                        System.out.println("Kolumny i Rowy przed ruchem "+ hero.currentCol + " " + hero.currentRow);
//  prowizoryczny sposób na kolizje                     int number = map.mapTile[hero.currentRow][hero.currentCol-1];
//                                                      if(map.kwadracik[number].collision == false)
                        hero.position_onworld.x -= Map_Manager.sqm_size;
                    }
                if (inputList.contains("RIGHT")) {
                    hero.bodyPositionTimer++;
                    hero.direction = "down";
                    hero.position_onworld.x += Map_Manager.sqm_size;
                }
                if (inputList.contains("UP")) {
                    hero.bodyPositionTimer++;
                    hero.direction = "up";
                    hero.position_onworld.y -= Map_Manager.sqm_size;
                }
                if (inputList.contains("DOWN")) {
                    hero.bodyPositionTimer++;
                    hero.direction = "down";
                    hero.position_onworld.y += Map_Manager.sqm_size;
                }


                hero.collisionON = false;
                collisionChecker.checkTile(hero);
                //sprawdzanie czy bohater spotkał przeciwnika
//                for (int i = 0; i < skeletons.size(); i++) {
//                    Creature skeleton = skeletons.get(i);
//                    System.out.println((int)hero.colision_rectangle.x + "X    " + (int)hero.colision_rectangle.y + "Y");
//                    if (hero.overlaps(skeleton)) {
//                        skeletons.remove(skeleton);
//                    }
//                }


                //odświeżeni canvasa
                content.fillRect(0, 0, map.world_length, map.world_width);
                map.render(content, hero);

                //dodanie potworów
                for (int i = 0; i < skeletons.size(); i++) {
                    skeletons.get(i).render(content);
                }
                //rysowanie obiektów
//                castle.draw(content);

                if (inputList.size() > 0) {
                    //rysowanie bohatera
                    switch (hero.direction) {
                        case "up":
                            if (hero.bodyPosition == 1) {
                                hero.imageChanger(1);
                            }
                            if (hero.bodyPosition == 2) {
                                hero.imageChanger(2);
                            }
                            break;
                        case "down":
                            if (hero.bodyPosition == 2) {
                                hero.imageChanger(1);
                            }
                            if (hero.bodyPosition == 1) {
                                hero.imageChanger(2);
                            }
                            break;
                    }
                    if (hero.bodyPositionTimer > 0.2) {
                        if (hero.bodyPosition == 1)
                            hero.bodyPosition = 2;
                        else if (hero.bodyPosition == 2) {
                            hero.bodyPosition = 1;
                        }
                        hero.bodyPositionTimer = 0;
                    }
                }
                hero.render(content);
                lastUpdate = a;
            }
            }
        };
        gameloop.start();


        // show na końcu
        stage.show();

    }


}