package items;

import entities.Entity;
import main.GamePanel;

public class Shield extends Entity {

    public Shield(GamePanel gp) {
        super(gp);
        type = type_shield;
        name = "Wood shield";
        down0=setUp("/res/objects/item/shield/shield_wood",gp.tileSize,gp.tileSize);
        attackvalue = 0;
        defensevalue = 4;
        description = "["+name+"]\nAn old shield";
        attackArea.width = 36;
        attackArea.height = 36;
        knockBackPower = 0;

        //TODO Auto-generated constructor stub
    }
    
}
