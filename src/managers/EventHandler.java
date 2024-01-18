package managers;

import entities.Entity;
import main.GamePanel;
import mics.Progress;

public class EventHandler {
    
    GamePanel gp;
    EventRect eventRect[][][];
    Entity eventMaster;

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventMaster = new Entity(gp);
        this.setDialogue();
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map = 0;
        int col = 0;
        int row = 0;
        while (map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 0;
            eventRect[map][col][row].y = 0;
            eventRect[map][col][row].width =48;
            eventRect[map][col][row].height = 48;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
            col++;

            if(col == gp.maxWorldCol) {
                col = 0;
                row++;

                if (row == gp.maxWorldRow) {
                    row = 0;
                    map++;
                }

            }
        }
    }
    //diagloue set
    public void setDialogue() {
        eventMaster.dialogues[0][0] = "You fall into a pit!" ;
        eventMaster.dialogues[1][0] = "You rest at the camp. You feel better.\nProcess has been save!";
    }
    
    public void checkEvent() {
        //Check if the player character is more than 1 tile a way from the last event
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if(distance > gp.tileSize*3) {
            canTouchEvent = true;
        }

        savePointHit(0, 76, 97);
        //This will prevent the event from happening repeatedly
        if(canTouchEvent == true) {
            if(hit(0,16,10,"any") == true) {
                damagePit(gp.dialogueState);
            }
            //Teleport WormHole
            else if(hit(0,67,83,"any") == true) {teleport(0, 81, 64);}
            else if(hit(0,81,64,"any") == true) {teleport(0, 67, 83);}
            else if(hit(0,49,57,"any") == true) {teleport(0, 17, 73);}
            else if(hit(0,17,73,"any") == true) {teleport(0,49,57);}
            else if(hit(0,23,32,"any") == true) {teleport(0, 92, 32);}
            else if(hit(0, 92, 32,"any") == true) {teleport(0,23,32);}

            else if(hit(1,13,27,"any") == true) {teleport(1, 61, 56);}
            else if(hit(1, 61, 56,"any") == true) {teleport(1,13,27);}
            else if(hit(1,86,45,"any") == true) {teleport(1, 107, 16);}
            else if(hit(1, 107, 16,"any") == true) {teleport(1,86,45);}
            else if(hit(1,100,88,"any") == true) {teleport(1, 44, 93);}
            else if(hit(1, 44, 93,"any") == true) {teleport(1,100,88);}

            else if(hit(2,97,100,"any") == true) {teleport(2, 63, 53);}
            else if(hit(2, 63, 53,"any") == true) {teleport(2,97,100);}
            else if(hit(2,38,44,"any") == true) {teleport(2, 34, 69);}
            else if(hit(2, 34, 69,"any") == true) {teleport(2,38,44);}
            else if(hit(2,98,27,"any") == true) {teleport(2, 33, 101);}
            else if(hit(2, 33, 101,"any") == true) {teleport(2,98,27);}

            else if(hit(3,14,43,"any") == true) {teleport(3, 45, 70);}
            else if(hit(3, 45, 70,"any") == true) {teleport(3,14,43);}
            else if(hit(3,45,99,"any") == true) {teleport(3, 87, 62);}
            else if(hit(3, 87, 62,"any") == true) {teleport(3,45,99);}
            else if(hit(3,96,72,"any") == true) {teleport(3, 65, 38);}
            else if(hit(3, 65, 38,"any") == true) {teleport(3,96,72);}

            //teleport to different map
            else if (hit(0, 53, 32, "any") == true) {teleport(1,15,17);}
            else if (hit(1,15,17, "any") == true) {teleport(0, 53, 32);}

            else if (hit(1, 101, 46, "any") == true) {teleport(2,56,65);}
            else if (hit(2,56,65, "any") == true) {teleport(1, 101, 46);}

            else if (hit(2, 72, 44, "any") == true) {teleport(3,15,12);}
            else if (hit(3,15,12, "any") == true) {teleport(2, 72, 44);}
            
            
            //Boss Scene
            else if(hit(3,77,39,"any") == true ||
               hit(3,77,40,"any") == true ||
               hit(3,77,38,"any") == true ||
               hit(3,77,41,"any") == true) {
                boss();
            }
            

            else if(hit(0,10,9,"any") == true) {healingPool(gp.dialogueState);}

        }
    }
    
    public void savePointHit(int map, int col, int row) {
        if(hit(map, col, row, "any") ||
            hit(map, col+2, row, "any") ||
            hit(map, col, row-1, "any") ||
            hit(map, col+1, row-1, "any") ||
            hit(map, col, row+1, "any") ||
            hit(map, col+1, row, "any") ) {
            
            healingPool(gp.dialogueState);    
            }
    }
    public boolean hit(int map, int col, int row, String reqDirection) {
        
        boolean hit = false;
        if (map == gp.currentMap ) {
            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
            
            if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
                if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;    
                    
                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }

            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }

        return hit;
    }
    
    
    public void damagePit( int gameState) {
        gp.gameState = gameState;
        gp.player.life -= 1;
        eventMaster.startDialogue(eventMaster,0);
        canTouchEvent = false;
    }
    
    public void healingPool(int gameState) {
        if(gp.KeyH.enterPressed == true) {
            gp.gameState = gameState;
            gp.player.attackCanceled = true;
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            eventMaster.startDialogue(eventMaster, 1);
            gp.aSetter.setMonster();
            gp.saveLoad.save();
        }
        gp.KeyH.enterPressed = false;
    }
    
    public void teleport (int map, int col, int row) {
        gp.currentMap = map;
        gp.player.worldX = gp.tileSize * col;
        gp.player.worldY = gp.tileSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
        System.out.println("MOVE TO MAP: " + map);
    }

    public void boss() {
        if (gp.bossBattleOn == false && Progress.defeatLog == false) {
            gp.gameState = gp.cutScene;
            gp.csManager.sceneNum = gp.csManager.boss;
        }
    }
}
