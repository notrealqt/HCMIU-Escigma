package main;

import object.Key;
import object.Lantern;
import object.WormHole;
import object.Chest;
import object.Door;
import entity.NPC_OldMan;
import monster.m_Boss;
import monster.m_GreenSlime;
import object.Axe;
import object.Boots;

//instantiate objects class
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int mapNum = 0;
        int i = 0;

        gp.obj[mapNum][i] = new Key(gp);
        gp.obj[mapNum][i].worldX = 19 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 19 * gp.tileSize;
        i++;

        //gp.obj[mapNum][i] = new Axe(gp);
        //gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
        //gp.obj[mapNum][i].worldY = 20 * gp.tileSize;
        //i++;

        gp.obj[mapNum][i] = new Door(gp);
        gp.obj[mapNum][i].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 25 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Chest(gp, "chest_ice_open_0", "chest_ice_close_0", new Key(gp));
        gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Lantern(gp);
        gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Chest(gp, "chest_forest_open_0", "chest_forest_close_0", new Key(gp));
        gp.obj[mapNum][i].worldX = 22 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 102 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Chest(gp, "chest_ice_open_0", "chest_ice_close_0", new Key(gp));
        gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Chest(gp, "chest_rock_open_0", "chest_rock_close_0", new Key(gp));
        gp.obj[mapNum][i].worldX = 96 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 26 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_forest");
        gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 94 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_forest");
        gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 71 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_forest");
        gp.obj[mapNum][i].worldX = 95 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 97 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_forest");
        gp.obj[mapNum][i].worldX = 108 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 100 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_rock");
        gp.obj[mapNum][i].worldX = 104 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 63 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_rock");
        gp.obj[mapNum][i].worldX = 108 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_ice");
        gp.obj[mapNum][i].worldX = 27 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 27 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_ice");
        gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new WormHole(gp, "wormhole_ice");
        gp.obj[mapNum][i].worldX = 67 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
        i++;

    }
    
    public void setNPC(){
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPC_OldMan(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*15;
        gp.npc[mapNum][0].worldY = gp.tileSize*15;

    }

    public void setMonster(){
        int mapNum = 0;
        int i = 1;
        gp.monster[mapNum][i] = new m_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*24;
        gp.monster[mapNum][i].worldY = gp.tileSize*24;  
        i++;
        gp.monster[mapNum][i] = new m_Boss(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize*24;
        gp.monster[mapNum][i].worldY = gp.tileSize*25;  
        
    }
}
