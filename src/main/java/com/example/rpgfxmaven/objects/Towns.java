package com.example.rpgfxmaven.objects;
import com.example.rpgfxmaven.logic.Rectangle;
import com.example.rpgfxmaven.logic.Vector;
import com.example.rpgfxmaven.characters.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Towns
{
    public Vector position;
    public Vector move;
    public Image image;
    public Rectangle borders;

    public Towns() {
        position = new Vector(0, 0);
        move = new Vector(0, 0);
        borders = new Rectangle(0,0,0,0);
    }

    public void setImage(String path)
    {
        image = new Image(path);
        borders.width = image.getWidth();
        borders.height = image.getHeight();

    }
    public Rectangle getBorders()
    {
        borders.x = position.x;
        borders.y = position.y;
        return borders;
    }
    public void setPosition(double x, double y)
    {
        position.set(x,y);
    }

    public boolean overlaps(Entity other) {
        return this.getBorders().overlaps(other.getColision_rectangle());
    }
    //renderowanie
    public void draw(GraphicsContext content)
    {
        content.drawImage(image, position.x, position.y);
    }
}
