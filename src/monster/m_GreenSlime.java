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
        up1=setUp("/monster/slime/slime_forest");
        up2=setUp("/monster/slime/slime_forest");
        down1=setUp("/monster/slime/slime_forest");
        down2=setUp("/monster/slime/slime_forest");
        left1=setUp("/monster/slime/slime_forest");
        left2=setUp("/monster/slime/slime_forest");
        right1=setUp("/monster/slime/slime_forest");
        right2=setUp("/monster/slmie/slime_forest");        
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
