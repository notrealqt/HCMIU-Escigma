package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class m_GreenSlime extends Entity {
    public m_GreenSlime(GamePanel gp) {
        super(gp);

        type = 2;
        name = "Green Slime";
        speed = 1;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage(){
        up0=setUp("/monster/slime/1_slime_idle_front_0");
        up1=setUp("/monster/slime/1_slime_idle_front_1");
        up2=setUp("/monster/slime/1_slime_idle_front_2");
        up3=setUp("/monster/slime/1_slime_idle_front_3");

        down0=setUp("/monster/slime/1_slime_idle_front_0");
        down1=setUp("/monster/slime/1_slime_idle_front_1");
        down2=setUp("/monster/slime/1_slime_idle_front_2");
        down3=setUp("/monster/slime/1_slime_idle_front_3");

        left0=setUp("/monster/slime/1_slime_idle_front_0");
        left1=setUp("/monster/slime/1_slime_idle_front_1");
        left2=setUp("/monster/slime/1_slime_idle_front_2");
        left3=setUp("/monster/slime/1_slime_idle_front_3");

        right0=setUp("/monster/slime/1_slime_idle_front_0");
        right1=setUp("/monster/slime/1_slime_idle_front_1");        
        right2=setUp("/monster/slime/1_slime_idle_front_2");
        right3=setUp("/monster/slime/1_slime_idle_front_3");
        
    }
    public void setAction(){
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
