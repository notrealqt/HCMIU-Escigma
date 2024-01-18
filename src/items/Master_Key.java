package items;

import entities.Entity;
import main.GamePanel;

public class Master_Key extends Entity {
    public Master_Key(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = "Master Key";
        down0=setUp("/res/objects/item/use/master_key",gp.tileSize,gp.tileSize);
    }
    
}
