package com.example.rpgfxmaven.characters;

import com.example.rpgfxmaven.GameControler;
import com.example.rpgfxmaven.logic.Rectangle;
import com.example.rpgfxmaven.logic.Vector;
import com.example.rpgfxmaven.maps.Map_Manager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Player extends Entity {

    public GameControler gc;
    public Map_Manager map = new Map_Manager(gc);

    public int bodyPosition = 1 ;
    public int bodyPositionTimer = 0;

    public String direction;

    public Image image1, image2;
    String imagePath1 = GameControler.class.getResource("media/test1.png").toString();
    String imagePath2 = GameControler.class.getResource("media/test2.png").toString();


    public void imageChanger(int num)
    {
        if(num == 1)
            this.setImage(imagePath1);
        if(num == 2)
            this.setImage(imagePath2);
    }

    public Player(Map_Manager map, int start_row, int start_col, GameControler gc) {
        position_onscreen = new Vector((GameControler.screen_length/2)- Map_Manager.sqm_size/2, (GameControler.screen_width/2)-Map_Manager.sqm_size/2);
        position_onworld = new Vector(start_row*map.sqm_size,start_col*map.sqm_size);
        currentRow = start_row;
        currentCol = start_col;
        getPlayerImage();
        direction = "down";
        colision_rectangle = new Rectangle(position_onscreen.x, position_onscreen.y, Map_Manager.sqm_size, Map_Manager.sqm_size);
        //colision_rectangle = new Rectangle((GameControler.screen_length/2)- Map_Manager.sqm_size/2, (GameControler.screen_width/2)-Map_Manager.sqm_size/2, Map_Manager.sqm_size, Map_Manager.sqm_size);
    }

    public void setImagePath(Image image, String path, Image image1, String path1) {
        image1 = new Image(path);
        image2 = new Image(path1);
    }

    public void getPlayerImage()
    {
        image1 = new Image(GameControler.class.getResource("media/test1.png").toString());
        image2 = new Image(GameControler.class.getResource("media/test2.png").toString());
    }

    //renderowanie
    public void render(GraphicsContext content)
    {
        System.out.println("Pos on Screen x = " + position_onscreen.x + ". Pos on Screen y = " + position_onscreen.y);
        System.out.println("Pos on World  x = " + position_onworld.x + ". Pos on World   y = " + position_onworld.y);
        currentCol = (int) (position_onworld.x/Map_Manager.sqm_size);
        currentRow = (int) (position_onworld.y/Map_Manager.sqm_size);
        System.out.println(currentCol +" III "+ currentRow);
        content.drawImage(image, (GameControler.screen_length/2)- Map_Manager.sqm_size/2, (GameControler.screen_width/2)-Map_Manager.sqm_size/2);
    }

}
