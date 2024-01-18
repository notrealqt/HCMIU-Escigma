package managers;

import entities.Entity;
import entities.BOSS_HumanCollector;
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
        Key key = new Key(gp);
        Master_Portal master_portal = new Master_Portal(gp);
        Chest ice_chest = new Chest(gp, "ice/open", "ice/close", new Key(gp));
        Chest forest_chest = new Chest(gp, "forest/open", "forest/close", new Key(gp));
        Chest rock_chest = new Chest(gp, "rock/open", "rock/close", new Key(gp));
        WormHole forest_worm = new WormHole(gp, "wormhole_forest");
        WormHole ice_worm = new WormHole(gp, "wormhole_ice");
        WormHole rock_worm = new WormHole(gp, "wormhole_rock");
        //Map 1:
        int mapNum1 = 0;
        int i1 = 0;
        //Map2:
        int mapNum2 = 0;
        int i2 = 0;
        //Map3:
        int mapNum3 = 0;
        int i3 = 0;
        //Map4:
        int mapNum4 = 3;
        int i4 = 0;
        setObjectAt(new Door(gp), mapNum4, i4++, 25, 25);
        setObjectAt(new Door(gp), mapNum4, i4++, 98, 19);
        setObjectAt(new Door(gp), mapNum4, i4++, 99, 19);
        setObjectAt(new Door(gp), mapNum4, i4++, 100, 19);
        setObjectAt(new Master_Portal(gp), mapNum4, i4++, 106, 16);
        setObjectAt(new Key(gp), mapNum4, i4++, 19, 19);
        setObjectAt(new Key(gp), mapNum4, i4++, 19, 20);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), mapNum4, i4++, 20, 18);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), mapNum4, i4++, 22, 102);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), mapNum4, i4++, 51, 12);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), mapNum4, i4++, 96, 26);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum4, i4++, 11, 94);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum4, i4++, 46, 71);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum4, i4++, 95, 97);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), mapNum4, i4++, 108, 100);
        setWormholeAt(new WormHole(gp, "wormhole_rock"), mapNum4, i4++, 104, 63);
        setWormholeAt(new WormHole(gp, "wormhole_rock"), mapNum4, i4++, 108, 12);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), mapNum4, i4++, 27, 27);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), mapNum4, i4++, 48, 45);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), mapNum4, i4++, 67, 16);
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
            setMonsterAt(new BOSS_HumanCollector(gp), mapNum, i++, 90, 38);
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
