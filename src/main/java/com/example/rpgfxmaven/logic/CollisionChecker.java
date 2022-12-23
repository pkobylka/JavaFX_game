package com.example.rpgfxmaven.logic;

import com.example.rpgfxmaven.GameControler;
import com.example.rpgfxmaven.characters.Entity;
import com.example.rpgfxmaven.maps.Map_Manager;


public class CollisionChecker {
    GameControler gc;

    public CollisionChecker(GameControler gc) {
        this.gc = gc;
    }

    public void checkTile(Entity entity)
    {
    int entityLeftWorldX = entity.worldX;
    int entityRightWorldX = entity.worldX + Map_Manager.sqm_size;
    int entityTopWorldY = entity.worldY;
    int entityBottomWorldY = entity.worldY + Map_Manager.sqm_size;;
    }
}
