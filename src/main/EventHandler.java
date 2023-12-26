package main;

import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp) {
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }
    public void checkEvent() {
        if(hit(16,10,"any") == true) {
            damagePit(gp.dialogueState);
        }
        if(hit(10,9,"any") == true) {
            healingPool(gp.dialogueState);
        }
        if(hit(15,12,"any") == true) {
            teleport(gp.dialogueState);
        }
    }
    public boolean hit(int eventCol, int eventRow, String reqDirection) {
        
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize + eventRect.y;
        
        if(gp.player.solidArea.intersects(eventRect)) {
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;            
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }
    public void teleport(int gameState) {

        gp.gameState = gameState;
        gp.ui.currentDiaglogue = "You have encounter teleportation path. Now, suffer.";
        gp.player.worldX = gp.tileSize*10;
        gp.player.worldY = gp.tileSize*18;

    }
    public void damagePit(int gameState) {
        gp.gameState = gameState;
        gp.ui.currentDiaglogue = "You fall into a pit!";
        gp.player.life -= 1;
    }
    public void healingPool(int gameState) {
        if(gp.KeyH.interPressed == true) {
            gp.gameState = gameState;
            gp.ui.currentDiaglogue = "You drink the water. Your life has been\n recovered. Why? Cuz you are made of more\n than 50% water.";
            gp.player.life = gp.player.maxLife;
        }
        gp.KeyH.interPressed = false;
    }
}
