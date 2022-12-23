//package com.example.rpgfxmaven.objects;
//
//import com.example.rpgfxmaven.GameControler;
//import com.example.rpgfxmaven.characters.Player;
//import com.example.rpgfxmaven.maps.Map_Manager;
//import javafx.scene.canvas.GraphicsContext;
//
//public class ObjectsLists {
//
//    public void render(GraphicsContext content, Player hero) {
//        int worldCol = 0;
//        int worldRow = 0;
//
//        while (worldRow < map_rows && worldCol < map_cols) {
//            int tileNum = mapTile[worldRow][worldCol];
//
//            int worldX = worldCol * Map_Manager.sqm_size;
//            int worldY = worldRow * Map_Manager.sqm_size;
//
//            int screenX = (int) (worldX - hero.position_onworld.x + ((GameControler.screen_length/2)- Map_Manager.sqm_size/2));
//            int screenY = (int) (worldY - hero.position_onworld.y + ((GameControler.screen_width/2)- Map_Manager.sqm_size/2));
//
//            if     ((worldX + Map_Manager.sqm_size > hero.position_onworld.x - ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)) &&
//                    (worldX - Map_Manager.sqm_size < hero.position_onworld.x + ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)) &&
//                    (worldY + Map_Manager.sqm_size > hero.position_onworld.y - ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)) &&
//                    (worldY - Map_Manager.sqm_size < hero.position_onworld.y + ((GameControler.screen_length/2)- Map_Manager.sqm_size/2)))
//                content.drawImage(kwadracik[tileNum].image, screenX, screenY, sqm_size, sqm_size);
//            worldCol++;
//            if (worldCol == map_cols) {
//                worldCol = 0;
//                worldRow++;
//            }
//}
