package object;

import entity.Entity;
import main.GamePanel;

public class Lantern extends Entity {

    public Lantern(GamePanel gp) {
        super(gp);
        type = type_light;
        name = "Lantern";
        down1 = setUp("objects/Lantern",gp.tileSize, gp.tileSize);
        lightRadius = 250;

    }
    
}
