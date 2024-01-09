package main;

import object.Key;
import object.Chest;
import object.Door;
import entity.NPC_OldMan;
import monster.m_GreenSlime;
import object.Boots;

//instantiate objects class
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }


    public void setObject() {
        int mapNum = 0;

        gp.obj[mapNum][0] = new Key(gp);
        gp.obj[mapNum][0].worldX = 4 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 2 * gp.tileSize;

        gp.obj[mapNum][1] = new Key(gp);
        gp.obj[mapNum][1].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 4 * gp.tileSize;

        gp.obj[mapNum][2] = new Door(gp);
        gp.obj[mapNum][2].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 8 * gp.tileSize;

        gp.obj[mapNum][3] = new Door(gp);
        gp.obj[mapNum][3].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 10 * gp.tileSize;

        gp.obj[mapNum][4] = new Door(gp);
        gp.obj[mapNum][4].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][4].worldY = 12 * gp.tileSize;

        gp.obj[mapNum][5] = new Chest(gp);
        gp.obj[mapNum][5].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 5 * gp.tileSize;

        gp.obj[mapNum][6] = new Key(gp);
        gp.obj[mapNum][6].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][6].worldY = 12 * gp.tileSize;

        gp.obj[mapNum][7] = new Boots(gp);
        gp.obj[mapNum][7].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][7].worldY = 20 * gp.tileSize;

        gp.obj[mapNum][8] = new Key(gp);
        gp.obj[mapNum][8].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][8].worldY = 14 * gp.tileSize;

        gp.obj[mapNum][9] = new Key(gp);
        gp.obj[mapNum][9].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][9].worldY = 16 * gp.tileSize;

        gp.obj[mapNum][10] = new Key(gp);
        gp.obj[mapNum][10].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][10].worldY = 18 * gp.tileSize;

        
    }
    public void setNPC(){
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPC_OldMan(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*13;
        gp.npc[mapNum][0].worldY = gp.tileSize*20;

    }

    //place slime onto the map
    public void setMonster(){
        int mapNum = 0;
        gp.monster[mapNum][0] = new m_GreenSlime(gp);
        gp.monster[mapNum][0].worldX = gp.tileSize*15;
        gp.monster[mapNum][0].worldY = gp.tileSize*15;

        gp.monster[mapNum][1] = new m_GreenSlime(gp);
        gp.monster[mapNum][1].worldX = gp.tileSize*18;
        gp.monster[mapNum][1].worldY = gp.tileSize*18;        
    }
}
