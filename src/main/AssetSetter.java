package main;

import object.Key;
import object.Lantern;
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

        gp.obj[mapNum][i] = new Chest(gp, new Key(gp));
        gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Lantern(gp);
        gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
        i++;


        
    }
    public void setNPC(){
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPC_OldMan(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize*15;
        gp.npc[mapNum][0].worldY = gp.tileSize*15;

    }

    //place slime onto the map
    public void setMonster(){
        int mapNum = 0;
        gp.monster[mapNum][1] = new m_GreenSlime(gp);
        gp.monster[mapNum][1].worldX = gp.tileSize*24;
        gp.monster[mapNum][1].worldY = gp.tileSize*24;  
        
        gp.monster[mapNum][2] = new m_Boss(gp);
        gp.monster[mapNum][2].worldX = gp.tileSize*24;
        gp.monster[mapNum][2].worldY = gp.tileSize*25;  
        
    }
}
