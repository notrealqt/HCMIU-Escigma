package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import entity.Entity;
import main.GamePanel;

public class SaveLoad {
   GamePanel gp;

   public SaveLoad(GamePanel gp) {
      this.gp = gp;
   }
   /* 
   public Entity getObject (String itemName) {
      Entity obj = null;
      switch(itemName) {
         
         case "Axe": obj = new AXE(gp)

   
      }
      return obj;
   }
   */
   public void save() {
      try {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
         DataStorage ds = new DataStorage();
         ds.maxLife = gp.player.maxLife;
         ds.maxMana = gp.player.maxMana;
         ds.life = gp.player.life;
         ds.mana = gp.player.mana;
         ds.strength = gp.player.strength;
         ds.dexterity = gp.player.dexterity;
         ds.coin = gp.player.coin;

         for (int i = 0; i < gp.player.inventory.size(); i++) {
            ds.itemNames.add(gp.player.inventory.get(i).name);
            //ds.itemAmounts.add(gp.player.inventory.get(i).amount);

         }

         ds.currentWeaponSlot = gp.player.getCurrentWeap();

         ds.mapObjectNames = new String[gp.maxMap][gp.obj[1].length];
         ds.mapObjectWorldX = new int[gp.maxMap][gp.obj[1].length];
         ds.mapObjectWorldY = new int[gp.maxMap][gp.obj[1].length];
         ds.mapObjectLootNames = new String[gp.maxMap][gp.obj[1].length];
         ds.mapObjectOpened = new boolean[gp.maxMap][gp.obj[1].length];

         for ( int mapNum = 0; mapNum < gp.maxMap ; mapNum ++) {
            for (int i =0; i< gp.obj[1].length; i++) {
               if (gp.obj[mapNum][i] == null) {
                  ds.mapObjectNames[mapNum][i] = "NA";

               }
               else {
                  ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].name;
                  ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].worldX;
                  ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].worldY;
                  if (gp.obj[mapNum][i].loot != null) {
                     ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].loot.name;
                  }
                  ds.mapObjectOpened[mapNum][i] = gp.obj[mapNum][i].opened;
               }
            }
         }
         oos.writeObject(ds);

      }
      catch( Exception e) {
         System.out.println("Save Exception");
      }
   }

   public void load() {
      try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
         //read
         DataStorage ds = (DataStorage)ois.readObject();
         gp.player.maxLife = ds.maxLife;
         gp.player.life = ds.life;
         gp.player.maxMana = ds.maxMana;
         gp.player.strength = ds.strength;
         gp.player.dexterity = ds.dexterity;
         gp.player.coin = ds.coin;

         gp.player.inventory.clear();
         for (int i = 0; i< ds.itemNames.size(); i++) {
            //gp.player.inventory.add(getObject(ds.itemNames.get(i)));
         }
         gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeaponSlot);
         gp.player.getAttack();
         gp.player.getDefense();
         gp.player.getPlayerattackImgage();

         for ( int mapNum = 0; mapNum < gp.maxMap ; mapNum ++) {
            for (int i =0; i< gp.obj[1].length; i++) {
               if (ds.mapObjectNames[mapNum][i].equals("NA")) {
                  gp.obj[mapNum][i] = null;
               }
               else {
                  //gp.obj[mapNum][i] = getObject(ds.mapObjectNames[mapNum][i]);
                  gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
                  gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];
                  if (ds.mapObjectLootNames[mapNum][i] != null) {
                     //gp.obj[mapNum][i].loot = getObject(ds.mapObjectNames[mapNum][i]);
                  }
                  gp.obj[mapNum][i].opened = ds.mapObjectOpened[mapNum][i];
                  if(gp.obj[mapNum][i].opened == true) {
                     gp.obj[mapNum][i].down1 = gp.obj[mapNum][i].image2;
                  }
               }
            }
         }
      } catch (Exception e) {
         System.out.println("Load Exception");
      }   
   }
}
