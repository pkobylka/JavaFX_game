package com.example.rpgfxmaven.maps;

import com.example.rpgfxmaven.GameControler;
import com.example.rpgfxmaven.characters.Player;
import javafx.scene.canvas.GraphicsContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Map_Manager {


    public static final int sqm_size = 50; // 50 pixels
    public final int map_rows = 20; // 20 rows
    public final int map_cols = 30; // 30 cols
    public final int world_length = sqm_size * map_cols; // 1000 pixels
    public final int world_width = sqm_size * map_rows; // 1500 pixels

    public Kwadraciki[] kwadracik;
    public int[][] mapTile;

    GameControler gc;
    public Player hero;

    public Map_Manager(GameControler gc) {
        this.gc = gc;
        kwadracik = new Kwadraciki[10];
        mapTile = new int[map_rows][map_cols];
        GetMap_Menager();
        loadMap(mapTile);
    }

    public void loadMap(int[][] mapTileArray) {
        String path = GameControler.class.getResource("map/map_data.txt").getPath();

        File file = new File(path);  //plik na którym będziemy operować
        if (file.exists() && !file.isDirectory()) {
            System.out.println("taki plik  już istnieje, funkcja kończy działanie");
        } else {
            System.out.println("taki plik nie istnieje, zostanie teraz utworzony");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Utworzono plik o nazwie: " + file.getName());
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int col = 0;
            int row = 0;
            while (row < map_rows && col < map_cols) {
                String line = br.readLine();
                //System.out.println(line); //printuje mape
                while (col < map_cols) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileArray[row][col] = num;
                    col++;
                }
                if (col == map_cols) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetMap_Menager() {
        kwadracik[0] = new Kwadraciki();
        kwadracik[0].setImage(GameControler.class.getResource("map/grass.png").toString());
        kwadracik[1] = new Kwadraciki();
        kwadracik[1].setImage(GameControler.class.getResource("map/water.png").toString());
        kwadracik[1].collision = true;
        kwadracik[2] = new Kwadraciki();
        kwadracik[2].setImage(GameControler.class.getResource("map/earth.png").toString());
        kwadracik[3] = new Kwadraciki();
        kwadracik[3].setImage(GameControler.class.getResource("map/tree.png").toString());
        kwadracik[3].collision = true;

    }

    public void render(GraphicsContext content, Player hero) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldRow < map_rows && worldCol < map_cols) {
            int tileNum = mapTile[worldRow][worldCol];

            int worldX = worldCol * Map_Manager.sqm_size;
            int worldY = worldRow * Map_Manager.sqm_size;

            int screenX = (int) (worldX - hero.position_onworld.x + ((GameControler.screen_length/2)- Map_Manager.sqm_size/2));
            int screenY = (int) (worldY - hero.position_onworld.y + ((GameControler.screen_width/2)- Map_Manager.sqm_size/2));

            if     ((worldX + Map_Manager.sqm_size > hero.position_onworld.x - ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)) &&
                    (worldX - Map_Manager.sqm_size < hero.position_onworld.x + ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)) &&
                    (worldY + Map_Manager.sqm_size > hero.position_onworld.y - ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)) &&
                    (worldY - Map_Manager.sqm_size < hero.position_onworld.y + ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)))
                content.drawImage(kwadracik[tileNum].image, screenX, screenY, sqm_size, sqm_size);
            worldCol++;
            if (worldCol == map_cols) {
                worldCol = 0;
                worldRow++;
            }

        }
    }
}
