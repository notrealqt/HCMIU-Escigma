package managers;

import entities.Entity;
import entities.MON_FloatingEye;
import entities.MON_Mimic;
import entities.MON_Mushroom;
import entities.MON_Slime;
import entities.NPC_Death;
import entities.NPC_Forest;
import entities.NPC_Ice;
import entities.NPC_Injured;
import entities.NPC_Rock;
import entities.BOSS_HumanCollector;
import items.*;
import main.GamePanel;
import mics.Progress;

//instantiate objects class
public class AssetSetter {
    GamePanel gp;
    public String monType1 = "forest/", monType2 = "ice/", monType3 = "rock/";
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        //Map 1:
        int map1 = 0;
        int i1 = 0;
        setObjectAt(new SavePoint(gp, "forest"), map1, i1++, 76, 97);
        setObjectAt(new Key(gp), map1, i1++, 25, 18);
        setObjectAt(new Key(gp), map1, i1++, 35, 32);
        setObjectAt(new Key(gp), map1, i1++, 57, 89);
        setObjectAt(new Key(gp), map1, i1++, 63, 68);
        setObjectAt(new Key(gp), map1, i1++, 102, 94);
        setObjectAt(new Key(gp), map1, i1++, 109, 64);
        setObjectAt(new Key(gp), map1, i1++, 79, 31);
        setObjectAt(new Key(gp), map1, i1++, 28, 44);
        setObjectAt(new Key(gp), map1, i1++, 63, 57);
        setObjectAt(new Key(gp), map1, i1++, 95, 13);
        setObjectAt(new Key(gp), map1, i1++, 108, 12);
        setObjectAt(new Key(gp), map1, i1++, 97, 59);
        setObjectAt(new Key(gp), map1, i1++, 98, 86);

        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 14, 22);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 19, 47);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 35, 103);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 74, 97);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 89, 45);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 22, 78);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 30, 42);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 53, 39);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map1, i1++, 80, 43);

        setTeleportAt(new Teleport(gp, "enter_map1"), map1, i1++, 64, 104);
        setTeleportAt(new Teleport(gp, "exit_map1"), map1, i1++, 53, 32);

        setTeleportAt(new WormHole(gp, "wormhole_forest"), map1, i1++, 67, 83);
        setTeleportAt(new WormHole(gp, "wormhole_forest"), map1, i1++, 81, 64);
        setTeleportAt(new WormHole(gp, "wormhole_forest"), map1, i1++, 49, 57);
        setTeleportAt(new WormHole(gp, "wormhole_forest"), map1, i1++, 17, 73);
        setTeleportAt(new WormHole(gp, "wormhole_forest"), map1, i1++, 23, 32);
        setTeleportAt(new WormHole(gp, "wormhole_forest"), map1, i1++, 92, 32);
        
        
        //Map2:
        int map2 = 1;
        int i2 = 0;
        setObjectAt(new Key(gp), map2, i2++, 24, 16);
        setObjectAt(new Key(gp), map2, i2++, 13, 26);
        setObjectAt(new Key(gp), map2, i2++, 16, 66);
        setObjectAt(new Key(gp), map2, i2++, 85, 86);
        setObjectAt(new Key(gp), map2, i2++, 86, 28);
        setObjectAt(new Key(gp), map2, i2++, 62, 13);
        setObjectAt(new Key(gp), map2, i2++, 25, 13);
        setObjectAt(new Key(gp), map2, i2++, 104, 19);
        setObjectAt(new Key(gp), map2, i2++, 88, 69);
        setObjectAt(new Key(gp), map2, i2++, 103, 92);
        setObjectAt(new Key(gp), map2, i2++, 17, 102);

        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 35, 23);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 24, 69);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 16, 86);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 74, 45);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 25, 21);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 104, 15);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 81, 52);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map2, i2++, 62, 102);
        
        setTeleportAt(new Teleport(gp, "enter_map2"), map2, i2++, 15, 17);
        setTeleportAt(new Teleport(gp, "exit_map2"), map2, i2++, 101, 46);
        
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map2, i2++, 13, 27);
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map2, i2++, 86,45);
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map2, i2++, 61, 56);
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map2, i2++, 107,16);        
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map2, i2++, 100, 88);
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map2, i2++, 44,93);

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
        setObjectAt(new Key(gp), map3, i3++, 57, 60);
        setObjectAt(new Key(gp), map3, i3++, 52, 38);
        setObjectAt(new Key(gp), map3, i3++, 20, 70);

        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 14, 31);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 60, 89);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 33, 71);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 23, 61);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 38, 53);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 68, 74);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 79, 58);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 83, 18);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 71, 17);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 20, 101);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 63, 94);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 78, 101);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map3, i3++, 107, 56);
       
        setTeleportAt(new Teleport(gp, "enter_map3"), map3, i3++, 56, 65);
        setTeleportAt(new Teleport(gp, "exit_map3"), map3, i3++, 72, 44);
        
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map3, i3++, 97, 100);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map3, i3++, 63, 53);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map3, i3++, 38, 44);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map3, i3++, 34, 69);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map3, i3++, 98, 27);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map3, i3++, 33, 101);


        
        //Map4:
        int map4 = 3;
        int i4 = 0;
        setObjectAt(new Heart(gp),map4,i4++,25,27);
        setObjectAt(new Master_Portal(gp), map4, i4++, 106, 16);

        setObjectAt(new Key(gp), map4, i4++, 37, 30);
        setObjectAt(new Key(gp), map4, i4++, 46, 93);
        setObjectAt(new Key(gp), map4, i4++, 22, 31);
        setObjectAt(new Key(gp), map4, i4++, 38, 104);

        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map4, i4++, 20, 18);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map4, i4++, 22, 102);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map4, i4++, 51, 12);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map4, i4++, 96, 26);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)),map4, i4++, 32, 21);
        setObjectAt(new Chest(gp, "ice/open", "ice/close", new Key(gp)), map4, i4++, 65, 32);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map4, i4++, 86, 23);
        setObjectAt(new Chest(gp, "rock/open", "rock/close", new Key(gp)), map4, i4++, 101, 63);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map4, i4++, 101, 89);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map4, i4++, 68, 102);
        setObjectAt(new Chest(gp, "forest/open", "forest/close", new Key(gp)), map4, i4++, 19, 66);


        setTeleportAt(new WormHole(gp, "wormhole_forest"), map4, i4++, 45, 70);
        setTeleportAt(new WormHole(gp, "wormhole_forest"), map4, i4++, 45, 99);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map4, i4++, 87, 62);
        setTeleportAt(new WormHole(gp, "wormhole_rock"), map4, i4++, 96, 72);
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map4, i4++, 14, 43);
        setTeleportAt(new WormHole(gp, "wormhole_ice"), map4, i4++, 65,38);

        setTeleportAt(new Teleport(gp, "enter_map2"), map4, i4++, 15, 12);

    }   
    
    public void setNPC() {
        //map1:
        int map1 = 0;
        int i1= 0;
        setNPCAt(new NPC_Forest(gp), map1, i1++,51 , 30);
        setNPCAt(new NPC_Forest(gp), map1, i1++,68 , 97);

        //map2:
        int map2 =1;
        int i2 = 0;
        setNPCAt(new NPC_Ice(gp), map2, i2++,16 , 12);
        setNPCAt(new NPC_Ice(gp), map2, i2++,100 , 40);

        //map3 
        int map3 = 2;
        int i3 = 0;
        setNPCAt(new NPC_Rock(gp), map3, i3++,49 , 63);
        setNPCAt(new NPC_Rock(gp), map3, i3++,75 , 42);

        //map4;
        int map4 = 3;
        int i4 = 0;
        setNPCAt(new NPC_Death(gp), map4, i4++,68 , 39);
        setNPCAt(new NPC_Injured(gp), map4, i4++,83 , 37);

    }
    public void setMine(){
        //map1
        int map1 = 0;
        int i1 = 0;
        setMineAt(new MON_Mushroom(gp, monType1), map1, i1++, 18, 18);
        //map2
        int map2 = 1;
        int i2 = 0;
        setMineAt(new MON_Mushroom(gp, monType2), map2, i2++, 18, 18);
        //map3
        int map3 = 2;
        int i3 = 0;
        setMineAt(new MON_Mushroom(gp, monType3), map3, i3++, 18, 18);
        //map4
        int map4 = 3;
        int i4 = 0;
        setMineAt(new MON_Mushroom(gp, monType1), map4, i4++, 18, 18);
    }
    
    public void setMonster() {
        //map1:
        

        int map1 = 0;
        int i1= 0;
        setMonsterAt(new MON_Mushroom(gp, monType1),map1,i1++,16,16);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 18, 56);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 30, 78);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 26, 94);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 51, 91);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 57, 102);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 89, 87);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 102, 105);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 82, 18);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 95, 21);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 71, 99);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 14, 103);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 17, 80);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 89, 97);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 107, 44);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 89, 12);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 54, 50);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 57, 44);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 63, 49);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map1, i1++, 17, 17);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 31, 26);
        setMonsterAt(new MON_Slime(gp, monType1), map1, i1++, 40, 60);
        
        
        //map2:
        int map2 =1;
        int i2 = 0;
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 32, 31);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 45, 38);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 36, 87);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 50, 88);
        setMonsterAt(new MON_Slime(gp, monType2), map2, i2++, 72, 49);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 109, 64);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 22, 14);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 19, 20);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 79, 15);
        setMonsterAt(new MON_Slime(gp, monType2), map2, i2++, 83, 32);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 107, 41);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 84, 70);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 100, 91);
        setMonsterAt(new MON_Slime(gp, monType2), map2, i2++, 62, 86);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map2, i2++, 22, 94);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 17, 47);
        setMonsterAt(new MON_Mimic(gp), map2, i2++, 15, 28);


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
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 56, 69);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 66, 60);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 88, 52);   
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 106, 37);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 94, 27);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 83, 30);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 69, 24);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 73, 36);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 50, 24);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 15, 17);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 29, 83);
        setMonsterAt(new MON_Slime(gp, monType3), map3, i3++, 52, 103);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map3, i3++, 102, 98);   
    
        //map4
        int map4 = 3;
        int i4 = 0;
        if (!Progress.defeatLog) {
            setMonsterAt(new BOSS_HumanCollector(gp), map4, i4++, 90, 38);
        }
        setMonsterAt(new MON_Slime(gp, monType3), map4, i4++, 91, 15);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map4, i4++, 82, 32);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map4, i4++, 105, 30);   
        setMonsterAt(new MON_Slime(gp, monType3), map4, i4++, 81, 47);
        setMonsterAt(new MON_FloatingEye(gp, monType3), map4, i4++, 87, 44);
        setMonsterAt(new MON_Slime(gp, monType3), map4, i4++, 98, 36);
        setMonsterAt(new MON_Slime(gp, monType3), map4, i4++, 99, 47);
        setMonsterAt(new MON_Slime(gp, monType3), map4, i4++, 105, 42);

        setMonsterAt(new MON_Mimic(gp), map4, i4++, 16, 16);
        setMonsterAt(new MON_Mimic(gp), map4, i4++, 36, 34);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map4, i4++, 25, 49);
        setMonsterAt(new MON_Slime(gp, monType2), map4, i4++, 73, 14);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map4, i4++, 34, 13);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map4, i4++, 53, 53);
        setMonsterAt(new MON_FloatingEye(gp, monType2), map4, i4++, 62, 31);

        setMonsterAt(new MON_Slime(gp, monType1), map4, i4++, 102, 77);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map4, i4++, 101, 86);
        setMonsterAt(new MON_Slime(gp, monType1), map4, i4++, 90, 87);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map4, i4++, 78, 102);
        setMonsterAt(new MON_Slime(gp, monType1), map4, i4++, 96, 103);
        setMonsterAt(new MON_Slime(gp, monType1), map4, i4++, 13, 97);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map4, i4++, 67, 103);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map4, i4++, 44, 85);
        setMonsterAt(new MON_Slime(gp, monType1), map4, i4++, 27, 66);
        setMonsterAt(new MON_Slime(gp, monType1), map4, i4++, 20, 79);
        setMonsterAt(new MON_FloatingEye(gp, monType1), map4, i4++, 36, 92);
    }

    public void setObjectAt(Entity object, int mapNum, int index, int worldX, int worldY) {
        gp.obj[mapNum][index] = object;
        object.worldX = worldX * gp.tileSize;
        object.worldY = worldY * gp.tileSize;
    }

    private void setTeleportAt(WormHole wormhole, int mapNum, int index, int worldX, int worldY) {
        gp.obj[mapNum][index] = wormhole;
        setWorldCoordinates(wormhole, worldX, worldY);
    }
    
    private void setTeleportAt(Teleport teleport, int mapNum, int index, int worldX, int worldY) {
        gp.obj[mapNum][index] = teleport;
        setWorldCoordinates(teleport, worldX, worldY);
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
    public void setMineAt(Entity mine, int mapNum, int index, int worldX, int worldY) {
        gp.mine[mapNum][index] = mine; 
        mine.worldX = worldX * gp.tileSize;
        mine.worldY = worldY * gp.tileSize;
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
