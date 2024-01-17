package object;

import entity.Entity;
import main.GamePanel;

public class ManaCrystal extends Entity {
    GamePanel gp;

    public ManaCrystal(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "MP";
        image = setUp("/res/objects/item/stat/mana/full",gp.tileSize,gp.tileSize);
        image2 = setUp("/res/objects/item/stat/mana/blank",gp.tileSize,gp.tileSize);
    }
}
