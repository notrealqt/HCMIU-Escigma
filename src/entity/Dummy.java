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

        idleUp = setUp("/player/move/1_player_idle_back_0",gp.tileSize, gp.tileSize);
        idleDown = setUp("/player/move/1_player_idle_font_0",gp.tileSize, gp.tileSize);
        idleRight = setUp("/player/move/1_player_idle_right_0",gp.tileSize, gp.tileSize);
        idleLeft = setUp("/player/move/1_player_idle_left_0",gp.tileSize, gp.tileSize);

        up0 = setUp("/player/move/1_player_move_back_0",gp.tileSize, gp.tileSize);
        up1 = setUp("/player/move/1_player_move_back_1",gp.tileSize, gp.tileSize);
        up2 = setUp("/player/move/1_player_move_back_2",gp.tileSize, gp.tileSize);
        up3 = setUp("/player/move/1_player_move_back_3",gp.tileSize, gp.tileSize);
        up4 = setUp("/player/move/1_player_move_back_4",gp.tileSize, gp.tileSize);
        up5 = setUp("/player/move/1_player_move_back_5",gp.tileSize, gp.tileSize);
        up6 = setUp("/player/move/1_player_move_back_6",gp.tileSize, gp.tileSize);
        up7 = setUp("/player/move/1_player_move_back_7",gp.tileSize, gp.tileSize);

        down0 = setUp("/player/move/1_player_move_font_0",gp.tileSize, gp.tileSize);
        down1 = setUp("/player/move/1_player_move_font_1",gp.tileSize, gp.tileSize);
        down2 = setUp("/player/move/1_player_move_font_2",gp.tileSize, gp.tileSize);
        down3 = setUp("/player/move/1_player_move_font_3",gp.tileSize, gp.tileSize);
        down4 = setUp("/player/move/1_player_move_font_4",gp.tileSize, gp.tileSize);
        down5 = setUp("/player/move/1_player_move_font_5",gp.tileSize, gp.tileSize);
        down6 = setUp("/player/move/1_player_move_font_6",gp.tileSize, gp.tileSize);
        down7 = setUp("/player/move/1_player_move_font_7",gp.tileSize, gp.tileSize);

        
        left0 = setUp("/player/move/1_player_move_left_0",gp.tileSize, gp.tileSize);
        left1 = setUp("/player/move/1_player_move_left_1",gp.tileSize, gp.tileSize);
        left2 = setUp("/player/move/1_player_move_left_2",gp.tileSize, gp.tileSize);
        left3 = setUp("/player/move/1_player_move_left_3",gp.tileSize, gp.tileSize);
        left4 = setUp("/player/move/1_player_move_left_4",gp.tileSize, gp.tileSize);
        left5 = setUp("/player/move/1_player_move_left_5",gp.tileSize, gp.tileSize);
        left6 = setUp("/player/move/1_player_move_left_6",gp.tileSize, gp.tileSize);
        left7 = setUp("/player/move/1_player_move_left_7",gp.tileSize, gp.tileSize);;


        right0 = setUp("/player/move/1_player_move_right_0",gp.tileSize, gp.tileSize);
        right1 = setUp("/player/move/1_player_move_right_1",gp.tileSize, gp.tileSize);
        right2 = setUp("/player/move/1_player_move_right_2",gp.tileSize, gp.tileSize);
        right3 = setUp("/player/move/1_player_move_right_3",gp.tileSize, gp.tileSize);
        right4 = setUp("/player/move/1_player_move_right_4",gp.tileSize, gp.tileSize);
        right5 = setUp("/player/move/1_player_move_right_5",gp.tileSize, gp.tileSize);
        right6 = setUp("/player/move/1_player_move_right_6",gp.tileSize, gp.tileSize);
        right7 = setUp("/player/move/1_player_move_right_7",gp.tileSize, gp.tileSize);
        
    }
}
