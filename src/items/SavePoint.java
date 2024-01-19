package items;

import java.io.IOException;
import javax.imageio.ImageIO;

import entities.Entity;
import main.GamePanel;

public class SavePoint extends Entity{

    GamePanel gp;
    public SavePoint(GamePanel gp, String savePointType) {
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = "SavePoint";
        down0 = setUp("/res/objects/Save Point/"+savePointType+"/active1",gp.tileSize*3, gp.tileSize*2);
        collision = true;
        solidArea.x = 0;
        solidArea.y  = 24;
        solidArea.width = gp.tileSize*3;
        solidArea.height = 72;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }  
}