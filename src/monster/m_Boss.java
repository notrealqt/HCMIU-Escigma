package monster;

import java.awt.image.BufferedImage;
import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class m_Boss extends Entity {
    GamePanel gp;

    public m_Boss(GamePanel gp) {
        
        super(gp);
        this.gp = gp;
        boss = true;
        type = type_monster;
        name = "Human Collector";
        speed = 2;
        maxLife = 10;
        life = maxLife;
        attack = 1;
        defense = 5;
        knockBackPower = 100;

        solidArea.x = 4;
        solidArea.y = 4;
        solidArea.width = 40;
        solidArea.height = 44;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 48;
        attackArea.height = 48;
        motion1_duration = 40;
        motion2_duration = 45;

        getImage();
        getAttackImage();
    }

    public void getImage(){
        up0=setUp("monster/boss/boss_corpse collector_move_font_0",gp.tileSize, gp.tileSize);
        up1=setUp("monster/boss/boss_corpse collector_move_font_1",gp.tileSize, gp.tileSize);
        up2=setUp("monster/boss/boss_corpse collector_move_font_2",gp.tileSize, gp.tileSize);
        up3=setUp("monster/boss/boss_corpse collector_move_font_3",gp.tileSize, gp.tileSize);
        up4=setUp("monster/boss/boss_corpse collector_move_font_4",gp.tileSize, gp.tileSize);
        up5=setUp("monster/boss/boss_corpse collector_move_font_5",gp.tileSize, gp.tileSize);
        up6=setUp("monster/boss/boss_corpse collector_move_font_6",gp.tileSize, gp.tileSize);
        up7=setUp("monster/boss/boss_corpse collector_move_font_7",gp.tileSize, gp.tileSize);

        down0=setUp("monster/boss/boss_corpse collector_move_back_0",gp.tileSize, gp.tileSize);
        down1=setUp("monster/boss/boss_corpse collector_move_back_1",gp.tileSize, gp.tileSize);
        down2=setUp("monster/boss/boss_corpse collector_move_back_2",gp.tileSize, gp.tileSize);
        down3=setUp("monster/boss/boss_corpse collector_move_back_3",gp.tileSize, gp.tileSize);
        down4=setUp("monster/boss/boss_corpse collector_move_back_4",gp.tileSize, gp.tileSize);
        down5=setUp("monster/boss/boss_corpse collector_move_back_5",gp.tileSize, gp.tileSize);
        down6=setUp("monster/boss/boss_corpse collector_move_back_6",gp.tileSize, gp.tileSize);
        down7=setUp("monster/boss/boss_corpse collector_move_back_7",gp.tileSize, gp.tileSize);

        left0=setUp("monster/boss/boss_corpse collector_move_left_0",gp.tileSize, gp.tileSize);
        left1=setUp("monster/boss/boss_corpse collector_move_left_1",gp.tileSize, gp.tileSize);
        left2=setUp("monster/boss/boss_corpse collector_move_left_2",gp.tileSize, gp.tileSize);
        left3=setUp("monster/boss/boss_corpse collector_move_left_3",gp.tileSize, gp.tileSize);
        left4=setUp("monster/boss/boss_corpse collector_move_left_4",gp.tileSize, gp.tileSize);
        left5=setUp("monster/boss/boss_corpse collector_move_left_5",gp.tileSize, gp.tileSize);
        left6=setUp("monster/boss/boss_corpse collector_move_left_6",gp.tileSize, gp.tileSize);
        left7=setUp("monster/boss/boss_corpse collector_move_left_7",gp.tileSize, gp.tileSize);

        right0=setUp("monster/boss/boss_corpse collector_move_right_0",gp.tileSize, gp.tileSize);
        right1=setUp("monster/boss/boss_corpse collector_move_right_1",gp.tileSize, gp.tileSize);
        right2=setUp("monster/boss/boss_corpse collector_move_right_2",gp.tileSize, gp.tileSize);
        right3=setUp("monster/boss/boss_corpse collector_move_right_3",gp.tileSize, gp.tileSize);
        right4=setUp("monster/boss/boss_corpse collector_move_right_4",gp.tileSize, gp.tileSize);
        right5=setUp("monster/boss/boss_corpse collector_move_right_5",gp.tileSize, gp.tileSize);
        right6=setUp("monster/boss/boss_corpse collector_move_right_6",gp.tileSize, gp.tileSize);
        right7=setUp("monster/boss/boss_corpse collector_move_right_7",gp.tileSize, gp.tileSize);
    }

    public void getAttackImage() {
        upAttack1 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_back_0", gp.tileSize, gp.tileSize);
        upAttack2 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_back_1", gp.tileSize, gp.tileSize);
        upAttack3 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_back_2", gp.tileSize, gp.tileSize);
        upAttack4 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_back_3", gp.tileSize, gp.tileSize);

        downAttack1 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_font_0", gp.tileSize, gp.tileSize);
        downAttack2 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_font_1", gp.tileSize, gp.tileSize);
        downAttack3 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_font_2", gp.tileSize, gp.tileSize);
        downAttack4 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_font_3", gp.tileSize, gp.tileSize);
        
        leftAttack1 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_0", gp.tileSize, gp.tileSize);
        leftAttack2 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_1", gp.tileSize, gp.tileSize);
        leftAttack3 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_2", gp.tileSize, gp.tileSize);
        leftAttack4 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_3", gp.tileSize, gp.tileSize);

        rightAttack1 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_0", gp.tileSize, gp.tileSize);
        rightAttack2 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_1", gp.tileSize, gp.tileSize);
        rightAttack3 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_2", gp.tileSize, gp.tileSize);
        rightAttack4 = setUp("/monster/boss/boss_attack/boss_corpse collector_attack_left_3", gp.tileSize, gp.tileSize);

    }

    public void setAction(){
        if (rage == false && life < maxLife/2) {
            rage = true;
            defaultSpeed += 2;
            speed = defaultSpeed;
            attack *= 2;
            
        }
        if (getTileDistance(gp.player) < 10) {
            chasePlayer(60);
        }
        else {
            getRandomDirection(120);
        }
        if (attacking == false) {
            checkAttack(60, gp.tileSize, gp.tileSize);
        }
    }

    public void damageReaction(){
        actionLockCounter = 0; 
        //direction = gp.player.direction;
        onPath = true;
    }

}
