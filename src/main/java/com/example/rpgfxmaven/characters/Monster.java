package com.example.rpgfxmaven.characters;

import com.example.rpgfxmaven.GameControler;
import com.example.rpgfxmaven.logic.Rectangle;
import javafx.scene.image.Image;

public class Monster extends Entity {
    String direction;

    public Monster(int x, int y, int speed) {
        super(x, y , speed);
        getMonsterImage();
        direction = "down";
        colision_rectangle = new Rectangle(position_onscreen.x, position_onscreen.y+image.getHeight(), image.getWidth()/2, -image.getHeight()/2);
    }

    public void getMonsterImage()
    {
        image = new Image(GameControler.class.getResource("media/test2.png").toString());
        image1 = new Image(GameControler.class.getResource("media/test1.png").toString());
    }
}
