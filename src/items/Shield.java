package items;

import entities.Entity;
import main.GamePanel;

public class Shield extends Entity {

    public Shield(GamePanel gp) {
        super(gp);
        type = type_shield;
        name = "Shit shield";
        //down0=setUp("/item/shield/shield_wood",gp.tileSize,gp.tileSize);
        attackvalue = 0;
        defensevalue = 2;
        description = "["+name+"]\nAn old shield";
        attackArea.width = 36;
        attackArea.height = 36;
        knockBackPower = 0;

        //TODO Auto-generated constructor stub
    }
    
}
