package main;

import object.Key;
import object.Chest;
import object.Door;
import entity.NPC_OldMan;
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
    }
    public void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*20;
        gp.npc[0].worldY = gp.tileSize*20;

    }
}
