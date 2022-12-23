package com.example.rpgfxmaven.objects;

import com.example.rpgfxmaven.logic.Rectangle;
import com.example.rpgfxmaven.logic.Vector;
import javafx.scene.image.Image;

public class SuperObject {

    public Vector position;
    public Image image;
    public Rectangle borders;

    public boolean collision = false;

    public void setImage(String path)
    {
        image = new Image(path);
    }
}
