package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class m_Boss extends Entity {
    GamePanel gp;

    public m_Boss(GamePanel gp) {
        
        super(gp);
        this.gp = gp;
        type = type_monster;
        name = "Human Collector";
        speed = 2;
        maxLife = 10;
        life = maxLife;
        attack = 10;
        defense = 5;
        
        solidArea.x = 4;
        solidArea.y = 4;
        solidArea.width = 40;
        solidArea.height = 44;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 48;
        attackArea.height = 48;

        //getImage();
        //getAttackImage();
    }


    public void getImage(){
        up0=setUp("/monster/boss/boss_corpse collector_move_font_0",gp.tileSize, gp.tileSize);
        up1=setUp("/monster/slime/boss_corpse collector_move_font_1",gp.tileSize, gp.tileSize);
        up2=setUp("/monster/slime/boss_corpse collector_move_font_2",gp.tileSize, gp.tileSize);
        up3=setUp("/monster/slime/boss_corpse collector_move_font_3",gp.tileSize, gp.tileSize);
        up4=setUp("/monster/slime/boss_corpse collector_move_font_4",gp.tileSize, gp.tileSize);
        up5=setUp("/monster/slime/boss_corpse collector_move_font_5",gp.tileSize, gp.tileSize);
        up6=setUp("/monster/slime/boss_corpse collector_move_font_6",gp.tileSize, gp.tileSize);
        up7=setUp("/monster/slime/boss_corpse collector_move_font_7",gp.tileSize, gp.tileSize);

        down0=setUp("/monster/boss/boss_corpse collector_move_down_0",gp.tileSize, gp.tileSize);
        down1=setUp("/monster/boss/boss_corpse collector_move_down_1",gp.tileSize, gp.tileSize);
        down2=setUp("/monster/boss/boss_corpse collector_move_down_2",gp.tileSize, gp.tileSize);
        down3=setUp("/monster/boss/boss_corpse collector_move_down_3",gp.tileSize, gp.tileSize);
        down4=setUp("/monster/boss/boss_corpse collector_move_down_4",gp.tileSize, gp.tileSize);
        down5=setUp("/monster/boss/boss_corpse collector_move_down_5",gp.tileSize, gp.tileSize);
        down6=setUp("/monster/boss/boss_corpse collector_move_down_6",gp.tileSize, gp.tileSize);
        down7=setUp("/monster/boss/boss_corpse collector_move_down_7",gp.tileSize, gp.tileSize);

        left0=setUp("/monster/boss/boss_corpse collector_move_left_0",gp.tileSize, gp.tileSize);
        left1=setUp("/monster/boss/boss_corpse collector_move_left_1",gp.tileSize, gp.tileSize);
        left2=setUp("/monster/boss/boss_corpse collector_move_left_2",gp.tileSize, gp.tileSize);
        left3=setUp("/monster/boss/boss_corpse collector_move_left_3",gp.tileSize, gp.tileSize);
        left4=setUp("/monster/boss/boss_corpse collector_move_left_4",gp.tileSize, gp.tileSize);
        left5=setUp("/monster/boss/boss_corpse collector_move_left_5",gp.tileSize, gp.tileSize);
        left6=setUp("/monster/boss/boss_corpse collector_move_left_6",gp.tileSize, gp.tileSize);
        left7=setUp("/monster/boss/boss_corpse collector_move_left_7",gp.tileSize, gp.tileSize);

        right0=setUp("/monster/boss/boss_corpse collector_move_right_0",gp.tileSize, gp.tileSize);
        right1=setUp("/monster/boss/boss_corpse collector_move_right_1",gp.tileSize, gp.tileSize);
        right2=setUp("/monster/boss/boss_corpse collector_move_right_2",gp.tileSize, gp.tileSize);
        right3=setUp("/monster/boss/boss_corpse collector_move_right_3",gp.tileSize, gp.tileSize);
        right4=setUp("/monster/boss/boss_corpse collector_move_right_4",gp.tileSize, gp.tileSize);
        right5=setUp("/monster/boss/boss_corpse collector_move_right_5",gp.tileSize, gp.tileSize);
        right6=setUp("/monster/boss/boss_corpse collector_move_right_6",gp.tileSize, gp.tileSize);
        right7=setUp("/monster/boss/boss_corpse collector_move_right_7",gp.tileSize, gp.tileSize);

    }

    public void getAttackImage() {

    }

    public void setAction(){
        
        if (onPath == true) {
            checkStop(gp.player, 15, 100);
            searchPath(getGoalCol(gp.player),getGoalRow(gp.player));
        }
        else {
            checkChasing(gp.player, 5, 100);
            getRandomDirection();
        }    
    }

    public void damageReaction(){
        actionLockCounter = 0; 
        //direction = gp.player.direction;
        onPath = true;
    }

}
