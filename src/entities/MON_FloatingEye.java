package entities;

import java.util.Random;
import main.GamePanel;

public class MON_FloatingEye extends Entity {
    GamePanel gp;
    public static final String monName = "Floating Eye";
    public MON_FloatingEye(GamePanel gp) {
        
        super(gp);
        this.gp = gp;
        boss = false;
        type = type_monster;
        name = monName;
        defaultSpeed = 1;
        speed = defaultSpeed;
        maxLife = 4;
        life = maxLife;
        attack = 5;
        defense = 0;
        knockBackPower = 5;
        coin = 5;
        
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
        
        if (getTileDistance(gp.player) < 10) {
            chasePlayer(60);
        }
        else {
            checkChasing(gp.player, 5, 100);
            getRandomDirection(120);
        }    
    }

    public void damageReaction(){
        actionLockCounter = 0; 
        //direction = gp.player.direction;
        onPath = true;
    }

}
