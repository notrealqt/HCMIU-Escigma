package monster;

import java.util.Random;
import entity.Entity;
import main.GamePanel;

public class m_GreenSlime extends Entity {
    GamePanel gp;

    public m_GreenSlime(GamePanel gp) {
        
        super(gp);
        this.gp = gp;
        boss = false;
        type = type_monster;
        name = "Green Slime";
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
        
        if (onPath == true) {
            checkStop(gp.player, 15, 100);
            searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
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
