package items;

import entities.Entity;
import main.GamePanel;

public class Teleport extends Entity{

    GamePanel gp;
    public Teleport(GamePanel gp, String teleType) {
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = "Teleport";
        down0 = setUp("/res/objects/"+teleType,gp.tileSize, gp.tileSize);

    }  
}
