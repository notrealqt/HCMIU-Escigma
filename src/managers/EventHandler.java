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
        
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map = 0;
        int col = 0;
        int row = 0;
        while (map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
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
    }
    
    public void checkEvent() {
        //Check if the player character is more than 1 tile a way from the last event
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if(distance > gp.tileSize*3) {
            canTouchEvent = true;
        }

        //This will prevent the event from happening repeatedly
        if(canTouchEvent == true) {
            if(hit(0,16,10,"any") == true) {
                damagePit(gp.dialogueState);
            }

            else if(hit(0,11,94,"any") == true) {
                wormHole(0, 45, 71);
            }
    
            else if(hit(0,46,71,"any") == true) {
                wormHole(0, 94, 97);
            }
    
            else if(hit(0,95,97,"any") == true) {
                wormHole(0, 107, 100);
            }
    
            else if(hit(0,108,100,"any") == true) {
                wormHole(0, 12, 94);
            }
    
            else if(hit(0,104,63,"any") == true) {
                wormHole(0, 107, 12);
            }
    
            else if(hit(0,108,12,"any") == true) {
                wormHole(0, 105, 63);
            }
    
            else if(hit(0,27,27,"any") == true) {
                wormHole(0, 49, 45);
            }
    
            else if(hit(0,48,45,"any") == true) {
                wormHole(0, 66, 16);
            }
    
            else if(hit(0,67,16,"any") == true) {
                wormHole(0, 26, 27);
            }
            else if(hit(3,76,39,"any") == true ||
               hit(3,76,40,"any") == true ||
               hit(3,76,38,"any") == true ||
               hit(3,76,41,"any") == true) {
                boss();
            }
            //teleport to different map
            else if (hit(0, 12, 71, "any") == true) {
                teleport(1,12,12);
            }
            else if (hit(1,12,12, "any") == true) {
                teleport(0, 12, 71);
            }
            else if (hit(1, 97, 87, "any") == true) {
                teleport(2,12,12);
            }
            else if (hit(2,12,12, "any") == true) {
                teleport(1, 97, 87);
            }
            else if (hit(2, 108, 107, "any") == true) {
                teleport(3,12,12);
            }
            else if (hit(3,12,12, "any") == true) {
                teleport(2, 108, 107);
            }


            else if(hit(0,10,9,"any") == true) {
                healingPool(gp.dialogueState);
            }

            else if(hit(0,15,12,"any") == true) {
                teleport(gp.dialogueState);
            }

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
    
    public void teleport(int gameState) {

        gp.gameState = gameState;
        gp.ui.currentDiaglogue = "You have encounter teleportation path. Now, suffer.";
        gp.player.worldX = gp.tileSize*10;
        gp.player.worldY = gp.tileSize*18;

    }
    
    public void damagePit( int gameState) {
        gp.gameState = gameState;
        gp.player.life -= 1;
        eventMaster.startDialogue(eventMaster,0);
        canTouchEvent = false;
    }
    
    public void healingPool(int gameState) {
        if(gp.KeyH.interPressed == true) {
            gp.gameState = gameState;
            gp.player.attackCanceled = true;
            gp.ui.currentDiaglogue = "You drink the water. Your life & mana has been\n recovered. Why? Cuz you are made of more\n than 50% water. \n Saved progress";
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            gp.aSetter.setMonster();
            gp.saveLoad.save();
        }
        gp.KeyH.interPressed = false;
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
    
    public void wormHole (int map, int col, int row) {
        gp.currentMap = map;
        gp.player.worldX = gp.tileSize * col;
        gp.player.worldY = gp.tileSize * row;
        previousEventX = gp.player.worldX;
        previousEventY = gp.player.worldY;
        canTouchEvent = false;
        
    }

    public void boss() {
        if (gp.bossBattleOn == false && Progress.defeatLog == false) {
            gp.gameState = gp.cutScene;
            gp.csManager.sceneNum = gp.csManager.boss;
        }
    }
}