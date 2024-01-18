package entities;

import main.GamePanel;

public class BOSS_HumanCollector extends Entity {
    GamePanel gp;
    public static final String monName = "Human Collector";
    public BOSS_HumanCollector(GamePanel gp) {
        
        super(gp);
        this.gp = gp;
        boss = true;
        type = type_monster;
        name = monName;
        speed = 2;
        maxLife = 10;
        life = maxLife;
        attack = 1;
        defense = 1;
        sleep = true;
        knockBackPower = 10;

        solidArea.x = 4;
        solidArea.y = 4;
        solidArea.width = 40;
        solidArea.height = 44;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        attackArea.width = 48;
        attackArea.height = 48;
        motion1_duration = 40;
        motion2_duration = 50;
        motion3_duration = 60;
        motion4_duration = 80;
        

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
        upAttack1 = setUp(path + "up0", gp.tileSize, gp.tileSize*2);
        upAttack2 = setUp(path + "up1", gp.tileSize, gp.tileSize*2);
        upAttack3 = setUp(path + "up2", gp.tileSize, gp.tileSize*2);
        upAttack4 = setUp(path + "up3", gp.tileSize, gp.tileSize*2);

        downAttack1 = setUp(path + "down0", gp.tileSize, gp.tileSize*2);
        downAttack2 = setUp(path + "down1", gp.tileSize, gp.tileSize*2);
        downAttack3 = setUp(path + "down2", gp.tileSize, gp.tileSize*2);
        downAttack4 = setUp(path + "down3", gp.tileSize, gp.tileSize*2);
        
        leftAttack1 = setUp(path + "left0", gp.tileSize*2, gp.tileSize);
        leftAttack2 = setUp(path + "left1", gp.tileSize*2, gp.tileSize);
        leftAttack3 = setUp(path + "left2", gp.tileSize*2, gp.tileSize);
        leftAttack4 = setUp(path + "left3", gp.tileSize*2, gp.tileSize);

        rightAttack1 = setUp(path + "right0", gp.tileSize*2, gp.tileSize);
        rightAttack2 = setUp(path + "right1", gp.tileSize*2, gp.tileSize);
        rightAttack3 = setUp(path + "right2", gp.tileSize*2, gp.tileSize);
        rightAttack4 = setUp(path + "right3", gp.tileSize*2, gp.tileSize);
    }

    public void setAction(){
      
        if (getTileDistance(gp.player) < 10) {
            chasePlayer(60);
        }
        else {
            checkChasing(gp.player, 5, 40);
            getRandomDirection(120);
        }
        if (attacking == false && getTileDistance(gp.player) < 2) {
            checkAttack(10,gp.tileSize*5,gp.tileSize);
        }
        if (rage == false && life < maxLife/2) {
            rage = true;
            defaultSpeed += 2;
            speed = defaultSpeed;
            attack *= 2;
            
        }
    }

    public void damageReaction(){
        actionLockCounter = 0; 
        //direction = gp.player.direction;
        onPath = true;
    }

    public void setDialogue() {
        dialogues[0][0] = "Injured: Flee! You can't possibly win this, just run for your life!";
        dialogues[0][1] = "Boss: ....................................................";
        dialogues[0][2] = "Boss: Well, well, what do we have here? Seems like fate has thrown us into the arena of destiny.";
        dialogues[0][3] = "Boss: Do you yearn to escape?";
        dialogues[0][4] = "Boss: Conquer me before I unleash the full fury that will shatter what's left of your existence!";
        dialogues[0][5] = "Injured: The shadows of defeat loom, but I won't surrender to your darkness!";
        dialogues[0][6] = "Boss: ....................................................";
        dialogues[0][7] = "Boss: Oh, the desperation in your eyes, the futile struggle against the inevitable.";
        dialogues[0][8] = "Boss: Do you feel the weight of your choices pressing down on you?";
        dialogues[0][9] = "Boss: Victory is a distant dream; your only hope is to survive my impending onslaught!";
        
    }


}   
