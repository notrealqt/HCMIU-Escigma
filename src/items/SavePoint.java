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
        down0 = setUp("/res/objects/Save Point/"+savePointType+"/active0",gp.tileSize*2, gp.tileSize);
        collision = true;
        solidArea.x = 1;
        solidArea.y  = 16;
        solidArea.width = 94;
        solidArea.height = 31;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }  
}