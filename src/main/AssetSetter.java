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
        gp.obj[0] = new Key(gp);
        gp.obj[0].worldX = 4 * gp.tileSize;
        gp.obj[0].worldY = 2 * gp.tileSize;

        gp.obj[1] = new Key(gp);
        gp.obj[1].worldX = 8 * gp.tileSize;
        gp.obj[1].worldY = 4 * gp.tileSize;

        gp.obj[2] = new Door(gp);
        gp.obj[2].worldX = 15 * gp.tileSize;
        gp.obj[2].worldY = 8 * gp.tileSize;

        gp.obj[3] = new Door(gp);
        gp.obj[3].worldX = 15 * gp.tileSize;
        gp.obj[3].worldY = 10 * gp.tileSize;

        gp.obj[4] = new Door(gp);
        gp.obj[4].worldX = 15 * gp.tileSize;
        gp.obj[4].worldY = 12 * gp.tileSize;

        gp.obj[5] = new Chest(gp);
        gp.obj[5].worldX = 10 * gp.tileSize;
        gp.obj[5].worldY = 5 * gp.tileSize;

        gp.obj[6] = new Key(gp);
        gp.obj[6].worldX = 20 * gp.tileSize;
        gp.obj[6].worldY = 12 * gp.tileSize;

        gp.obj[7] = new Boots(gp);
        gp.obj[7].worldX = 25 * gp.tileSize;
        gp.obj[7].worldY = 20 * gp.tileSize;

        gp.obj[8] = new Key(gp);
        gp.obj[8].worldX = 20 * gp.tileSize;
        gp.obj[8].worldY = 14 * gp.tileSize;

        gp.obj[9] = new Key(gp);
        gp.obj[9].worldX = 20 * gp.tileSize;
        gp.obj[9].worldY = 16 * gp.tileSize;

        gp.obj[10] = new Key(gp);
        gp.obj[10].worldX = 20 * gp.tileSize;
        gp.obj[10].worldY = 18 * gp.tileSize;

        
    }
    public void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*13;
        gp.npc[0].worldY = gp.tileSize*20;

    }

    //place slime onto the map
    public void setMonster(){
        gp.monster[0] = new m_GreenSlime(gp);
        gp.monster[0].worldX = gp.tileSize*15;
        gp.monster[0].worldY = gp.tileSize*15;

        gp.monster[1] = new m_GreenSlime(gp);
        gp.monster[1].worldX = gp.tileSize*18;
        gp.monster[1].worldY = gp.tileSize*18;        
    }
}
