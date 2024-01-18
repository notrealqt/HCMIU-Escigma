package entities;

import java.util.Random;
import main.GamePanel;

public class MON_Mushroom extends Entity {
    GamePanel gp;
    public static final String monName = "Mushroom";
    public MON_Mushroom(GamePanel gp, String typeMon) {
        
        super(gp);
        this.gp = gp;
        boss = false;
        type = type_mine;
        name = monName;
        maxLife = 4;
        life = maxLife;
        attack = 5;
        defense = 0;
        knockBackPower = 5;
        coin = 5;
        speed = 0;
        defaultSpeed = speed;
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage(typeMon);
    }


    public void getImage(String type){
        String path = "/res/monster/mushroom/" + type + "/";
        mineIdle = setUp(path + "idle",gp.tileSize, gp.tileSize);

        mineExpl0 = setUp(path + "explode0",gp.tileSize, gp.tileSize);
        mineExpl1 = setUp(path + "explode1",gp.tileSize, gp.tileSize);
        mineExpl2 = setUp(path + "explode2",gp.tileSize, gp.tileSize);
        mineExpl3 = setUp(path + "explode3",gp.tileSize, gp.tileSize);
        mineExpl4 = setUp(path + "explode4",gp.tileSize, gp.tileSize);
        mineExpl5 = setUp(path + "explode5",gp.tileSize, gp.tileSize);
        mineExpl6 = setUp(path + "explode6",gp.tileSize, gp.tileSize);
        mineExpl7 = setUp(path + "explode7",gp.tileSize, gp.tileSize);
        mineExpl8 = setUp(path + "explode8",gp.tileSize, gp.tileSize);

        
    }




    // public void setAction(){
        
    //     if (getTileDistance(gp.player) < 10) {
    //         chasePlayer(60);
    //     }
    //     else {
    //         checkChasing(gp.player, 5, 100);
    //         getRandomDirection(120);
    //     }    
    // }

    public void damageReaction(){
        actionLockCounter = 0; 
        //direction = gp.player.direction;
        onPath = true;
    }

}
