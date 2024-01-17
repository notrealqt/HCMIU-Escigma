package entity;

import main.GamePanel;

public class Dummy extends Entity {
    public static final String npcName = "Dummy";
    Player player = new Player(gp, null);
    public Dummy(GamePanel gp) {
        super(gp);
        name = npcName;
        getPlayerImage();
    }
    public void getPlayerImage() {

        idleUp = setUp("/res/player/move/idle_back",gp.tileSize, gp.tileSize);
        idleDown = setUp("/res/player/move/idle_font",gp.tileSize, gp.tileSize);
        idleRight = setUp("/res/player/move/idle_right",gp.tileSize, gp.tileSize);
        idleLeft = setUp("/res/player/move/idle_left",gp.tileSize, gp.tileSize);

        up0 = setUp("/res/player/move/down0",gp.tileSize, gp.tileSize);
        up1 = setUp("/res/player/move/down1",gp.tileSize, gp.tileSize);
        up2 = setUp("/res/player/move/down2",gp.tileSize, gp.tileSize);
        up3 = setUp("/res/player/move/down3",gp.tileSize, gp.tileSize);
        up4 = setUp("/res/player/move/down4",gp.tileSize, gp.tileSize);
        up5 = setUp("/res/player/move/down5",gp.tileSize, gp.tileSize);
        up6 = setUp("/res/player/move/down6",gp.tileSize, gp.tileSize);
        up7 = setUp("/res/player/move/down7",gp.tileSize, gp.tileSize);

        down0 = setUp("/res/player/move/up0",gp.tileSize, gp.tileSize);
        down1 = setUp("/res/player/move/up1",gp.tileSize, gp.tileSize);
        down2 = setUp("/res/player/move/up2",gp.tileSize, gp.tileSize);
        down3 = setUp("/res/player/move/up3",gp.tileSize, gp.tileSize);
        down4 = setUp("/res/player/move/up4",gp.tileSize, gp.tileSize);
        down5 = setUp("/res/player/move/up5",gp.tileSize, gp.tileSize);
        down6 = setUp("/res/player/move/up6",gp.tileSize, gp.tileSize);
        down7 = setUp("/res/player/move/up7",gp.tileSize, gp.tileSize);

        
        left0 = setUp("/res/player/move/left0",gp.tileSize, gp.tileSize);
        left1 = setUp("/res/player/move/left1",gp.tileSize, gp.tileSize);
        left2 = setUp("/res/player/move/left2",gp.tileSize, gp.tileSize);
        left3 = setUp("/res/player/move/left3",gp.tileSize, gp.tileSize);
        left4 = setUp("/res/player/move/left4",gp.tileSize, gp.tileSize);
        left5 = setUp("/res/player/move/left5",gp.tileSize, gp.tileSize);
        left6 = setUp("/res/player/move/left6",gp.tileSize, gp.tileSize);
        left7 = setUp("/res/player/move/left7",gp.tileSize, gp.tileSize);;


        right0 = setUp("/res/player/move/right0",gp.tileSize, gp.tileSize);
        right1 = setUp("/res/player/move/right1",gp.tileSize, gp.tileSize);
        right2 = setUp("/res/player/move/right2",gp.tileSize, gp.tileSize);
        right3 = setUp("/res/player/move/right3",gp.tileSize, gp.tileSize);
        right4 = setUp("/res/player/move/right4",gp.tileSize, gp.tileSize);
        right5 = setUp("/res/player/move/right5",gp.tileSize, gp.tileSize);
        right6 = setUp("/res/player/move/right6",gp.tileSize, gp.tileSize);
        right7 = setUp("/res/player/move/right7",gp.tileSize, gp.tileSize);
        
    }
}
