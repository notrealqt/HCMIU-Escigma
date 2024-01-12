package object;

import entity.Entity;
import main.GamePanel;

public class ManaCrystal extends Entity {
    GamePanel gp;

    public ManaCrystal(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "MP";
        //image = setUp("/aosdj",gp.tileSize,gp.tileSize);
        //image2 = setUp("/aosdj",gp.tileSize,gp.tileSize);
    }
}
