package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan extends Entity {
    
    public NPC_OldMan(GamePanel gp){
        super(gp);
        direction = "up";
        speed = 1;

        getImage();

    }
    public void getImage(){

        up0 = setUp("npc/oldman_up_1");
        up1 = setUp("npc/oldman_up_2");

        down0 = setUp("npc/oldman_down_1");
        down1 = setUp("npc/oldman_down_2");

        left0 = setUp("npc/oldman_left_1");
        left1 = setUp("npc/oldman_left_2");

        right0 = setUp("npc/oldman_right_1");
        right1 = setUp("npc/oldman_right_2");

    }
    public void setAction() {
        
        actionLockCounter ++;
        
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

    


