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
        sleep = true;
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
        setDialogue();
    }   

    public void getImage(){
        String path = "/res/monster/boss/corpse/move/";
        up0=setUp(path + "up0",gp.tileSize, gp.tileSize);
        up1=setUp(path + "up1",gp.tileSize, gp.tileSize);
        up2=setUp(path + "up2",gp.tileSize, gp.tileSize);
        up3=setUp(path + "up3",gp.tileSize, gp.tileSize);
        up4=setUp(path + "up4",gp.tileSize, gp.tileSize);
        up5=setUp(path + "up5",gp.tileSize, gp.tileSize);
        up6=setUp(path + "up6",gp.tileSize, gp.tileSize);
        up7=setUp(path + "up7",gp.tileSize, gp.tileSize);

        down0=setUp(path + "down0",gp.tileSize, gp.tileSize);
        down1=setUp(path + "down1",gp.tileSize, gp.tileSize);
        down2=setUp(path + "down2",gp.tileSize, gp.tileSize);
        down3=setUp(path + "down3",gp.tileSize, gp.tileSize);
        down4=setUp(path + "down4",gp.tileSize, gp.tileSize);
        down5=setUp(path + "down5",gp.tileSize, gp.tileSize);
        down6=setUp(path + "down6",gp.tileSize, gp.tileSize);
        down7=setUp(path + "down7",gp.tileSize, gp.tileSize);

        left0=setUp(path + "left0",gp.tileSize, gp.tileSize);
        left1=setUp(path + "left1",gp.tileSize, gp.tileSize);
        left2=setUp(path + "left2",gp.tileSize, gp.tileSize);
        left3=setUp(path + "left3",gp.tileSize, gp.tileSize);
        left4=setUp(path + "left4",gp.tileSize, gp.tileSize);
        left5=setUp(path + "left5",gp.tileSize, gp.tileSize);
        left6=setUp(path + "left6",gp.tileSize, gp.tileSize);
        left7=setUp(path + "left7",gp.tileSize, gp.tileSize);

        right0=setUp(path + "right0",gp.tileSize, gp.tileSize);
        right1=setUp(path + "right1",gp.tileSize, gp.tileSize);
        right2=setUp(path + "right2",gp.tileSize, gp.tileSize);
        right3=setUp(path + "right3",gp.tileSize, gp.tileSize);
        right4=setUp(path + "right4",gp.tileSize, gp.tileSize);
        right5=setUp(path + "right5",gp.tileSize, gp.tileSize);
        right6=setUp(path + "right6",gp.tileSize, gp.tileSize);
        right7=setUp(path + "right7",gp.tileSize, gp.tileSize);
    }

    public void getAttackImage() {
        String path = "/res/monster/boss/corpse/attack/";
        upAttack1 = setUp(path + "up0", gp.tileSize, gp.tileSize);
        upAttack2 = setUp(path + "up1", gp.tileSize, gp.tileSize);
        upAttack3 = setUp(path + "up2", gp.tileSize, gp.tileSize);
        upAttack4 = setUp(path + "up3", gp.tileSize, gp.tileSize);

        downAttack1 = setUp(path + "down0", gp.tileSize, gp.tileSize);
        downAttack2 = setUp(path + "down1", gp.tileSize, gp.tileSize);
        downAttack3 = setUp(path + "down2", gp.tileSize, gp.tileSize);
        downAttack4 = setUp(path + "down3", gp.tileSize, gp.tileSize);
        
        leftAttack1 = setUp(path + "left0", gp.tileSize, gp.tileSize);
        leftAttack2 = setUp(path + "left1", gp.tileSize, gp.tileSize);
        leftAttack3 = setUp(path + "left2", gp.tileSize, gp.tileSize);
        leftAttack4 = setUp(path + "left3", gp.tileSize, gp.tileSize);

        rightAttack1 = setUp(path + "right0", gp.tileSize, gp.tileSize);
        rightAttack2 = setUp(path + "right1", gp.tileSize, gp.tileSize);
        rightAttack3 = setUp(path + "right2", gp.tileSize, gp.tileSize);
        rightAttack4 = setUp(path + "right3", gp.tileSize, gp.tileSize);

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
            checkAttack(5,gp.tileSize,gp.tileSize);
        }
    }

    public void damageReaction(){
        actionLockCounter = 0; 
        //direction = gp.player.direction;
        onPath = true;
    }

    public void setDialogue() {
        dialogues[0][0] = "Injured: RUNNNNNNNNNNNNNNN! YOU CAN'T WIN, JUST ESCAPE";
        dialogues[0][1] = "Boss: .............................";
        dialogues[0][2] = "Boss: Would you look at that? Look like something fun come up";
        dialogues[0][3] = "Boss: You want to get out?";
        dialogues[0][4] = "Boss: Defeat me before I completely mess you up";
    }


}   
