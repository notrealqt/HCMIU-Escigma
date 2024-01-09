package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class m_GreenSlime extends Entity {
    GamePanel gp;

    public m_GreenSlime(GamePanel gp) {
        
        super(gp);
        this.gp = gp;
        type = type_monster;
        name = "Green Slime";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        attack = 5;
        defense = 0;

        
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }
    public void getImage(){
        up0=setUp("/monster/slime/1_slime_idle_front_0",gp.tileSize, gp.tileSize);
        up1=setUp("/monster/slime/1_slime_idle_front_1",gp.tileSize, gp.tileSize);
        up2=setUp("/monster/slime/1_slime_idle_front_2",gp.tileSize, gp.tileSize);
        up3=setUp("/monster/slime/1_slime_idle_front_3",gp.tileSize, gp.tileSize);

        down0=setUp("/monster/slime/1_slime_idle_front_0",gp.tileSize, gp.tileSize);
        down1=setUp("/monster/slime/1_slime_idle_front_1",gp.tileSize, gp.tileSize);
        down2=setUp("/monster/slime/1_slime_idle_front_2",gp.tileSize, gp.tileSize);
        down3=setUp("/monster/slime/1_slime_idle_front_3",gp.tileSize, gp.tileSize);

        left0=setUp("/monster/slime/1_slime_idle_front_0",gp.tileSize, gp.tileSize);
        left1=setUp("/monster/slime/1_slime_idle_front_1",gp.tileSize, gp.tileSize);
        left2=setUp("/monster/slime/1_slime_idle_front_2",gp.tileSize, gp.tileSize);
        left3=setUp("/monster/slime/1_slime_idle_front_3",gp.tileSize, gp.tileSize);

        right0=setUp("/monster/slime/1_slime_idle_front_0",gp.tileSize, gp.tileSize);
        right1=setUp("/monster/slime/1_slime_idle_front_1",gp.tileSize, gp.tileSize);        
        right2=setUp("/monster/slime/1_slime_idle_front_2",gp.tileSize, gp.tileSize);
        right3=setUp("/monster/slime/1_slime_idle_front_3",gp.tileSize, gp.tileSize);
        
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

    public void damagereaction(){
        actionLockCounter = 0; 
        gp.playSE(5); 
        direction = gp.player.direction;
    }
}
