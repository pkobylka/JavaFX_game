package com.example.rpgfxmaven.characters;
import com.example.rpgfxmaven.GameControler;
import com.example.rpgfxmaven.logic.Rectangle;
import com.example.rpgfxmaven.logic.Vector;
import com.example.rpgfxmaven.maps.Map_Manager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Entity
{
    public int speed;// jak szybko robbi kroki
    public double moveSize;//jak duże "kroki" robi hero

    public int bodyPosition;
    public int bodyPositionTimer;

    public Image image, image1;


    public Vector position_onscreen;
    public Vector position_onworld;
    public Rectangle colision_rectangle;

    public int worldX;
    public int worldY;

    public int currentCol;
    public int currentRow;

    public boolean collisionON = false;

    public Entity()
    {

    }
    public Entity(int x, int y, int speed) {
        worldX = x;
        worldY = y;
        position_onscreen = new Vector(x, y);
        this.speed = speed;
    }

    public void setImage(String path)
    {
        image = new Image(path);
        colision_rectangle.width = image.getWidth(); //image.getWidth();
        colision_rectangle.height = image.getHeight(); //image.getHeight();
    }
    public Rectangle getColision_rectangle()
    {
        colision_rectangle.x = position_onscreen.x;
        colision_rectangle.y = position_onscreen.y+image.getHeight();
        return colision_rectangle;
    }
    public void setPosition(double x, double y)
    {
        position_onscreen.set(x,y);
    }

    public boolean overlaps(Entity other_entity) {
        return this.getColision_rectangle().overlaps(other_entity.getColision_rectangle());
    }
    //renderowanie
    public void render(GraphicsContext content)
    {
        content.drawImage(image, (GameControler.screen_length/20)- Map_Manager.sqm_size/2, (GameControler.screen_width/20)-Map_Manager.sqm_size/2);
    }


}
