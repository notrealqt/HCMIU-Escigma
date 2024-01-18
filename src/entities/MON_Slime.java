package entities;

import main.GamePanel;

public class MON_Slime extends Entity {
    GamePanel gp;
    public static final String monName = "Slime";

    public MON_Slime(GamePanel gp, String typeMon) {
        
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

        getImage(typeMon);
    }

    public void getImage(String type){
        String path = "/res/monster/slime/" + type + "/";
        up0 = setUp(path + "up0",gp.tileSize, gp.tileSize);
        up1 = setUp(path + "up1",gp.tileSize, gp.tileSize);
        up2 = setUp(path + "up2",gp.tileSize, gp.tileSize);
        up3 = setUp(path + "up3",gp.tileSize, gp.tileSize);
        up4 = setUp(path + "up4",gp.tileSize, gp.tileSize);
        up5 = setUp(path + "up5",gp.tileSize, gp.tileSize);
        up6 = setUp(path + "up0",gp.tileSize, gp.tileSize);
        up7 = setUp(path + "up1",gp.tileSize, gp.tileSize);



        down0 = setUp(path + "down0",gp.tileSize, gp.tileSize);
        down1 = setUp(path + "down1",gp.tileSize, gp.tileSize);
        down2 = setUp(path + "down2",gp.tileSize, gp.tileSize);
        down3 = setUp(path + "down3",gp.tileSize, gp.tileSize);
        down4 = setUp(path + "down4",gp.tileSize, gp.tileSize);
        down5 = setUp(path + "down5",gp.tileSize, gp.tileSize);
        down6 = setUp(path + "down0",gp.tileSize, gp.tileSize);
        down7 = setUp(path + "down1",gp.tileSize, gp.tileSize);
        
        left0 = setUp(path + "left0",gp.tileSize, gp.tileSize);
        left1 = setUp(path + "left1",gp.tileSize, gp.tileSize);
        left2 = setUp(path + "left2",gp.tileSize, gp.tileSize);
        left3 = setUp(path + "left3",gp.tileSize, gp.tileSize);
        left4 = setUp(path + "left4",gp.tileSize, gp.tileSize);
        left5 = setUp(path + "left5",gp.tileSize, gp.tileSize);
        left6 = setUp(path + "left0",gp.tileSize, gp.tileSize);
        left7 = setUp(path + "left1",gp.tileSize, gp.tileSize);

        right0 = setUp(path + "right0",gp.tileSize, gp.tileSize);
        right1 = setUp(path + "right1",gp.tileSize, gp.tileSize);        
        right2 = setUp(path + "right2",gp.tileSize, gp.tileSize);
        right3 = setUp(path + "right3",gp.tileSize, gp.tileSize);
        right4 = setUp(path + "right4",gp.tileSize, gp.tileSize);
        right5 = setUp(path + "right5",gp.tileSize, gp.tileSize);
        right6 = setUp(path + "right0",gp.tileSize, gp.tileSize);
        right7 = setUp(path + "right1",gp.tileSize, gp.tileSize);
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
