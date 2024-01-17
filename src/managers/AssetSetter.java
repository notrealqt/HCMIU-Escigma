package managers;

import entities.Entity;
import entities.m_Boss;
import items.*;
import main.GamePanel;
import mics.Progress;



//instantiate objects class
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        Door door = new Door(gp);
        Key key = new Key(gp);
        Master_Portal master_portal = new Master_Portal(gp);
        Chest ice_chest = new Chest(gp, "ice/open", "ice/close", new Key(gp));
        Chest forest_chest = new Chest(gp, "forest/open", "forest/close", new Key(gp));
        Chest rock_chest = new Chest(gp, "rock/open", "rock/close", new Key(gp));
        WormHole forest_worm = new WormHole(gp, "wormhole_forest");
        WormHole ice_worm = new WormHole(gp, "wormhole_ice");
        WormHole rock_worm = new WormHole(gp, "wormhole_rock");
        //Map 1:
        //Map2:
        //Map3:
        //Map4:
        int mapNum = 0;
        int i = 0;
        setObjectAt(door, mapNum, i++, 25, 25);
        setObjectAt(door, mapNum, i++, 98, 19);
        setObjectAt(door, mapNum, i++, 99, 19);
        setObjectAt(door, mapNum, i++, 100, 19);
        setObjectAt(master_portal, mapNum, i++, 106, 16);
        setObjectAt(key, mapNum, i++, 19, 19);
        setObjectAt(ice_chest, mapNum, i++, 20, 18);
        setObjectAt(forest_chest, mapNum, i++, 22, 102);
        setObjectAt(ice_chest, mapNum, i++, 51, 12);
        setObjectAt(rock_chest, mapNum, i++, 96, 26);
        setWormholeAt(forest_worm, mapNum, i++, 91, 94);
        setWormholeAt(forest_worm, mapNum, i++, 46, 71);
        setWormholeAt(forest_worm, mapNum, i++, 95, 97);
        setWormholeAt(forest_worm, mapNum, i++, 108, 100);
        setWormholeAt(rock_worm, mapNum, i++, 104, 63);
        setWormholeAt(rock_worm, mapNum, i++, 108, 12);
        setWormholeAt(ice_worm, mapNum, i++, 27, 27);
        setWormholeAt(ice_worm, mapNum, i++, 48, 45);
        setWormholeAt(ice_worm, mapNum, i++, 67, 16);
    }   
    public void setNPC() {
        int mapNum = 0;
        int i = 0;
        //setNPCAt(new NPC_OldMan(gp), mapNum, i++, 15, 15);

    }
    public void setMonster() {
        int mapNum = 0;
        int i = 0;

        //setMonsterAt(new m_GreenSlime(gp), mapNum, i++, 24, 24);

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
