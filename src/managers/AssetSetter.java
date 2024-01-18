package managers;

import entities.Entity;
import entities.MON_FloatingEye;
import entities.MON_Mimic;
import entities.MON_Slime;
import entities.NPC_Forest;
import entities.NPC_Ice;
import entities.NPC_Rock;
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
        int map1 = 0;
        int i1 = 0;
        setObjectAt(new Key(gp), map1, i1++, 25, 18);
        setObjectAt(new Key(gp), map1, i1++, 35, 32);
        setObjectAt(new Key(gp), map1, i1++, 57, 89);
        setObjectAt(new Key(gp), map1, i1++, 63, 68);
        setObjectAt(new Key(gp), map1, i1++, 102, 94);
        setObjectAt(new Key(gp), map1, i1++, 109, 64);
        setObjectAt(new Key(gp), map1, i1++, 79, 31);

        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 14, 22);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 19, 47);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 35, 103);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 74, 97);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 89, 45);

        //Map2:
        int map2 = 1;
        int i2 = 0;
        setObjectAt(new Key(gp), map2, i2++, 24, 16);
        setObjectAt(new Key(gp), map2, i2++, 13, 26);
        setObjectAt(new Key(gp), map2, i2++, 16, 66);
        setObjectAt(new Key(gp), map2, i2++, 85, 86);
        setObjectAt(new Key(gp), map2, i2++, 86, 28);
        setObjectAt(new Key(gp), map2, i2++, 62, 13);
        
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 35, 23);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 24, 69);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 16, 86);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 74, 45);

        //Map3:
        int map3 = 2;
        int i3 = 0;
        setObjectAt(new Key(gp), map3, i3++, 29, 32);
        setObjectAt(new Key(gp), map3, i3++, 34, 60);
        setObjectAt(new Key(gp), map3, i3++, 46, 26);
        setObjectAt(new Key(gp), map3, i3++, 28, 52);
        setObjectAt(new Key(gp), map3, i3++, 21, 86);
        setObjectAt(new Key(gp), map3, i3++, 58, 101);
        setObjectAt(new Key(gp), map3, i3++, 87, 106);
        setObjectAt(new Key(gp), map3, i3++, 87, 84);
        setObjectAt(new Key(gp), map3, i3++, 101, 76);
        setObjectAt(new Key(gp), map3, i3++, 90, 53);
        setObjectAt(new Key(gp), map3, i3++, 95, 25);
        setObjectAt(new Key(gp), map3, i3++, 59, 22);
        setObjectAt(new Key(gp), map3, i3++, 38, 23);

        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 14, 31);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 60, 89);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 33, 71);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 23, 61);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 38, 53);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 68, 74);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 79, 58);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 83, 18);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 71, 17);

        //Map4:
        int map4 = 3;
        int i4 = 0;
        setObjectAt(new Heart(gp),map4,i4++,25,27);
        setObjectAt(new Master_Portal(gp), map4, i4++, 106, 16);
        setObjectAt(new Key(gp), map4, i4++, 19, 19);
        setObjectAt(new Key(gp), map4, i4++, 19, 20);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map4, i4++, 20, 18);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map4, i4++, 22, 102);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map4, i4++, 51, 12);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map4, i4++, 96, 26);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), map4, i4++, 11, 94);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), map4, i4++, 46, 71);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), map4, i4++, 95, 97);
        setWormholeAt(new WormHole(gp, "wormhole_forest"), map4, i4++, 108, 100);
        setWormholeAt(new WormHole(gp, "wormhole_rock"), map4, i4++, 104, 63);
        setWormholeAt(new WormHole(gp, "wormhole_rock"), map4, i4++, 108, 12);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), map4, i4++, 27, 27);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), map4, i4++, 48, 45);
        setWormholeAt(new WormHole(gp, "wormhole_ice"), map4, i4++, 67, 16);
    }   
    public void setNPC() {
        //map1:
        int map1 = 0;
        int i1= 0;
        setNPCAt(new NPC_Forest(gp), map1, i1++,20 , 13);
        setNPCAt(new NPC_Forest(gp), map1, i1++,18 , 71);

        //map2:
        int map2 =1;
        int i2 = 0;
        setNPCAt(new NPC_Ice(gp), map2, i2++,16 , 12);
        setNPCAt(new NPC_Ice(gp), map2, i2++,105 , 87);

        //map3 
        int map3 = 2;
        int i3 = 0;
        setNPCAt(new NPC_Rock(gp), map3, i3++,18 , 16);
        setNPCAt(new NPC_Rock(gp), map3, i3++,98 , 94);

        //map4;
        int map4 = 3;
        int i4 = 0;
        //setNPCAt(new NPC_OldMan(gp), mapNum, i++, 15, 15);

    }
    public void setMonster() {
        //map1:
        String monType1 = "forest/";
        String monType2 = "ice/";
        String monType3 = "rock/";

        int map1 = 0;
        int i1= 0;
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 18, 56);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 30, 78);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 26, 94);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 51, 91);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 57, 102);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 89, 87);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 102, 105);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 82, 18);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 95, 21);
        //map2:
        int map2 =1;
        int i2 = 0;
        setObjectAt(new MON_Mimic(gp), map2, i2++, 32, 31);
        setObjectAt(new MON_Mimic(gp), map2, i2++, 45, 38);
        setObjectAt(new MON_Mimic(gp), map2, i2++, 36, 87);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 50, 88);
        setMonsterAt(new MON_Slime(gp, monType2), map2, i2++, 72, 49);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 109, 64);
        //map3 
        int map3 = 2;
        int i3 = 0;
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 28, 20);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 19, 29);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 23, 42);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 28, 53);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 38, 58);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 19, 64);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 16, 74);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 16, 81);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 39, 82);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 28, 92);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 46, 99);   
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 63, 97);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 71, 104);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 80, 98);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 84, 89);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 91, 82);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 75, 54);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 91, 61);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 85, 39);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 101, 19);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 101, 25);   
        
        //map4
        int map4 = 3;
        int i4 = 0;
        if (!Progress.defeatLog) {
            setMonsterAt(new BOSS_HumanCollector(gp), map4, i4++, 90, 38);
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
        gp.npc[mapNum][index] = npc;
        npc.worldX = worldX * gp.tileSize;
        npc.worldY = worldY * gp.tileSize;
    }

    public void setMonsterAt(Entity mon, int mapNum, int index, int worldX, int worldY) {
        gp.monster[mapNum][index] = mon; 
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
