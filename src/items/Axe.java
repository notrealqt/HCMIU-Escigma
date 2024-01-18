package items;

import entities.Entity;
import main.GamePanel;

public class Axe extends Entity {

    public Axe(GamePanel gp) {
        super(gp);
        type = type_axe;
        name = "Hacked Axe";
        down0=setUp("/res/objects/item/weapon/axe/axe",gp.tileSize,gp.tileSize);
        attackvalue = 4;
        defensevalue = 2;
        description = "["+name+"]\nAn axe that cuts down enemy!!!";
        attackArea.width = 100;
        attackArea.height = 100;
        knockBackPower = 10;
    }
    
}
