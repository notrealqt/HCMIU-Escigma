package entities;

import main.GamePanel;

public class Dummy extends Entity {
    public static final String npcName = "Dummy";
    public Dummy(GamePanel gp) {
        super(gp);
        name = npcName;
        getPlayerImage();
    }
    
    public void getPlayerImage() {
        String path = "/res/player/move/";
        idleUp = setUp(path + "idle_up",gp.tileSize, gp.tileSize);
        idleDown = setUp(path + "idle_down",gp.tileSize, gp.tileSize);
        idleRight = setUp(path + "idle_right",gp.tileSize, gp.tileSize);
        idleLeft = setUp(path + "idle_left",gp.tileSize, gp.tileSize);

        up0 = setUp(path + "up0",gp.tileSize, gp.tileSize);
        up1 = setUp(path + "up1",gp.tileSize, gp.tileSize);
        up2 = setUp(path + "up2",gp.tileSize, gp.tileSize);
        up3 = setUp(path + "up3",gp.tileSize, gp.tileSize);
        up4 = setUp(path + "up4",gp.tileSize, gp.tileSize);
        up5 = setUp(path + "up5",gp.tileSize, gp.tileSize);
        up6 = setUp(path + "up6",gp.tileSize, gp.tileSize);
        up7 = setUp(path + "up7",gp.tileSize, gp.tileSize);

        down0 = setUp(path + "down0",gp.tileSize, gp.tileSize);
        down1 = setUp(path + "down1",gp.tileSize, gp.tileSize);
        down2 = setUp(path + "down2",gp.tileSize, gp.tileSize);
        down3 = setUp(path + "down3",gp.tileSize, gp.tileSize);
        down4 = setUp(path + "down4",gp.tileSize, gp.tileSize);
        down5 = setUp(path + "down5",gp.tileSize, gp.tileSize);
        down6 = setUp(path + "down6",gp.tileSize, gp.tileSize);
        down7 = setUp(path + "down7",gp.tileSize, gp.tileSize);

        
        left0 = setUp(path + "left0",gp.tileSize, gp.tileSize);
        left1 = setUp(path + "left1",gp.tileSize, gp.tileSize);
        left2 = setUp(path + "left2",gp.tileSize, gp.tileSize);
        left3 = setUp(path + "left3",gp.tileSize, gp.tileSize);
        left4 = setUp(path + "left4",gp.tileSize, gp.tileSize);
        left5 = setUp(path + "left5",gp.tileSize, gp.tileSize);
        left6 = setUp(path + "left6",gp.tileSize, gp.tileSize);
        left7 = setUp(path + "left7",gp.tileSize, gp.tileSize);;


        right0 = setUp(path + "right0",gp.tileSize, gp.tileSize);
        right1 = setUp(path + "right1",gp.tileSize, gp.tileSize);
        right2 = setUp(path + "right2",gp.tileSize, gp.tileSize);
        right3 = setUp(path + "right3",gp.tileSize, gp.tileSize);
        right4 = setUp(path + "right4",gp.tileSize, gp.tileSize);
        right5 = setUp(path + "right5",gp.tileSize, gp.tileSize);
        right6 = setUp(path + "right6",gp.tileSize, gp.tileSize);
        right7 = setUp(path + "right7",gp.tileSize, gp.tileSize);
        
    }
}
