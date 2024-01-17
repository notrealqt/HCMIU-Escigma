package object;

import entity.Entity;
import main.GamePanel;

public class ManaCrystal extends Entity {
    GamePanel gp;

    public ManaCrystal(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = type_pickupOnly;
        value = 1;

        name = "MP";
        down1 = setUp("/res/objects/item/stat/mana/full",gp.tileSize,gp.tileSize);
        image = setUp("/res/objects/item/stat/mana/full",gp.tileSize,gp.tileSize);
        image2 = setUp("/res/objects/item/stat/mana/blank",gp.tileSize,gp.tileSize);
    }
    public boolean use(Entity entity){
        gp.ui.addMessage("Mana + "+value);
        entity.mana += value;

        return true;
    }
}
