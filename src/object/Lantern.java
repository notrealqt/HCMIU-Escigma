package object;

import entity.Entity;
import main.GamePanel;

public class Lantern extends Entity {

    public Lantern(GamePanel gp) {
        super(gp);
        type = type_light;
        name = "Lantern";
        down0 = setUp("objects/lantern",gp.tileSize, gp.tileSize);
        lightRadius = 250;

        collision = true;
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
    
}
