package main;

import data.Progress;
import entity.Entity;
import entity.NPC_OldMan;
import monster.m_Boss;
import monster.m_GreenSlime;
import object.*;



//instantiate objects class
public class AssetSetter {
    private GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int mapNum = 0;
        int i = 0;
        //Object
        setObjectAt(new Door(gp), mapNum, i++, 25, 25);
        setObjectAt(new Door(gp), mapNum, i++, 98, 19);
        setObjectAt(new Door(gp), mapNum, i++, 99, 19);
        setObjectAt(new Door(gp), mapNum, i++, 100, 19);
        setObjectAt(new Master_Portal(gp), mapNum, i++, 106, 16);
        setObjectAt(new Key(gp), mapNum, i++, 19, 19);
        setObjectAt(new Chest(gp, "chest_ice_open_0", "chest_ice_close_0", new Key(gp)), mapNum, i++, 20, 18);
        setObjectAt(new Lantern(gp), mapNum, i++, 18, 18);
        setObjectAt(new Chest(gp, "chest_forest_open_0", "chest_forest_close_0", new Key(gp)), mapNum, i++, 22, 102);
        setObjectAt(new Chest(gp, "chest_ice_open_0", "chest_ice_close_0", new Key(gp)), mapNum, i++, 51, 12);
        setObjectAt(new Chest(gp, "chest_rock_open_0", "chest_rock_close_0", new Key(gp)), mapNum, i++, 96, 26);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum, i++, 91, 94);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum, i++, 46, 71);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum, i++, 95, 97);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum, i++, 108, 100);
        setWormholeAt(new WormHole(gp, "wormhole_rock"), mapNum, i++, 104, 63);
        setWormholeAt(new WormHole(gp, "wormhole_rock"), mapNum, i++, 108, 12);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), mapNum, i++, 27, 27);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), mapNum, i++, 48, 45);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), mapNum, i++, 67, 16);

    }
    public void setNPC() {
        int mapNum = 0;
        int i = 0;
        setNPCAt(new NPC_OldMan(gp), mapNum, i++, 15, 15);

    }
    public void setMonster() {
        int mapNum = 0;
        int i = 0;

        setMonsterAt(new m_GreenSlime(gp), mapNum, i++, 24, 24);

        if (!Progress.defeatLog) {
            setMonsterAt(new m_Boss(gp), mapNum, i++, 90, 38);
        }
    }

    public void setObjectAt(Entity object, int mapNum, int index, int worldX, int worldY) {
        gp.obj[mapNum][index] = object;
        object.worldX = worldX * gp.tileSize;
        object.worldY = worldY * gp.tileSize;
    }

    private void setWormholeAt(WormHole wormhole, int mapNum, int index, int worldX, int worldY) {
        gp.obj[mapNum][index] = wormhole;
        setWorldCoordinates(wormhole, worldX, worldY);
    }
    
    public void setNPCAt(Entity npc, int mapNum, int index, int worldX, int worldY) {
        gp.npc[mapNum][0] = npc;
        npc.worldX = worldX * gp.tileSize;
        npc.worldY = worldY * gp.tileSize;
    }

    public void setMonsterAt(Entity mon, int mapNum, int index, int worldX, int worldY) {
        gp.monster[mapNum][index] = mon;  // Use the provided index parameter
        mon.worldX = worldX * gp.tileSize;
        mon.worldY = worldY * gp.tileSize;
    }

    private void setWorldCoordinates(Object obj, int worldX, int worldY) {
        try {
            obj.getClass().getField("worldX").set(obj, worldX * gp.tileSize);
            obj.getClass().getField("worldY").set(obj, worldY * gp.tileSize);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
