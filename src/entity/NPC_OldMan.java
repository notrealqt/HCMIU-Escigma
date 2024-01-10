package entity;

import java.util.Random;

import AI.Node;
import main.GamePanel;

public class NPC_OldMan extends Entity {
    
    public NPC_OldMan(GamePanel gp){
  
        super(gp);
        type = 1;
        direction = "up";
        speed = 2;

        getImage();
        setDialogue();
        update();
    }

    public void update() {
        setAction();
    }

    public void getImage(){

        up0 = setUp("npc/oldman_up_1",gp.tileSize, gp.tileSize);
        up1 = setUp("npc/oldman_up_2",gp.tileSize, gp.tileSize);

        down0 = setUp("npc/oldman_down_1",gp.tileSize, gp.tileSize);
        down1 = setUp("npc/oldman_down_2",gp.tileSize, gp.tileSize);

        left0 = setUp("npc/oldman_left_1",gp.tileSize, gp.tileSize);
        left1 = setUp("npc/oldman_left_2",gp.tileSize, gp.tileSize);

        right0 = setUp("npc/oldman_right_1",gp.tileSize, gp.tileSize);
        right1 = setUp("npc/oldman_right_2",gp.tileSize, gp.tileSize);

    }
    
    public void setDialogue() {
        dialogues[0] = "Hello, traveler!";
        dialogues[1] = "Welcome to nowhere!";
        dialogues[2] = "Sadly, it's nowhere";
        dialogues[3] = "There is nothing to do";
        dialogues[4] = "Being born here is miserable";
        dialogues[5] = "DGH%#&ODTT@#$M(RQ(#$Y V(%YMV(Q#$)MV)Q)$(VQ)\nCONCAC$V(%Y($YB(V##$C*#T$nv38t41n84vt19496u^B(M%(M%N))))))";

    }
    public void setAction() {
        if (onPath == true) {
            int goalCol = (gp.player.worldX + gp.player.solidArea.x) / gp.tileSize;
            int goalRow = (gp.player.worldY + gp.player.solidArea.y) / gp.tileSize;
            searchPath(goalCol,goalRow);
        }
        else {
            actionLockCounter++;
            
            if(actionLockCounter == 120){
                Random random = new Random();
                int i = random.nextInt(100)+1; //Random from 1 to 100

                if(i<=25){
                    direction = "up";
                }
                if(i>25 && i<= 50){
                    direction = "down";
                }
                if(i>50 && i<=75){
                    direction = "left";
                }
                if(i>75 && i<=100){
                    direction = "right";
                }

                actionLockCounter = 0;
            } 
        }
        
    }
    public void speak() {
        super.speak();
        
    }


    public void searchPath(int goalCol, int goalRow) {
      int startCol = (worldX + solidArea.x)/gp.tileSize;
      int startRow = (worldY + solidArea.y)/gp.tileSize;

      gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);
      if (this.gp.pFinder.search() == true) {
         int nextX = (gp.pFinder.pathList.get(0).col * gp.tileSize); 
         int nextY = (gp.pFinder.pathList.get(0).row * gp.tileSize);

         int enLeftX = worldX + solidArea.x;
         int enRightX = worldX + solidArea.x + solidArea.width;
         int enTopY = worldY + solidArea.y;
         int enBottomY = worldY + solidArea.y + solidArea.height;
       if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
          this.direction = "up";
       }
       else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
               this.direction = "down";
       }
       else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
          if (enLeftX > nextX) {
             direction = "left";
          }
          if (enLeftX < nextX) {
             direction = "right";
          }
       }
       else if (enTopY > nextY && enLeftX > nextX) {
          direction = "up";
          checkCollision();
          if (collisionOn == true) {
             direction = "left";
          }
       } 
       else if (enTopY > nextY && enLeftX < nextX) {
          direction = "up";
          checkCollision();
          if (collisionOn == true) {
             direction = "right";
          }
       } 
       else if (enTopY < nextY && enLeftX > nextX) {
          direction = "down";
          checkCollision();
          if (collisionOn == true) {
             direction = "left";
          }
       }
       else if (enTopY < nextY && enLeftX < nextX) {
          direction = "down";
          checkCollision();
          if (collisionOn == true) {
             direction = "right";
          }
       }

       int nextCol = gp.pFinder.pathList.get(0).col;
       int nextRow = gp.pFinder.pathList.get(0).row;
       if (nextCol == goalCol && nextRow == goalRow) {
          onPath = false;
       }
      }
   }
}

    


