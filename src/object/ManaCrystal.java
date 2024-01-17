package object;

import entity.Entity;
import main.GamePanel;

public class ManaCrystal extends Entity {
    GamePanel gp;

    public ManaCrystal(GamePanel gp){
        super(gp);
        this.gp = gp;

        name = "MP";
        image = setUp("/objects/mana_full",gp.tileSize,gp.tileSize);
        image2 = setUp("/objects/mana_blank",gp.tileSize,gp.tileSize);
    }
}
