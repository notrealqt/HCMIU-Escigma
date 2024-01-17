package object;

import entity.Entity;
import main.GamePanel;

public class Axe extends Entity {

    public Axe(GamePanel gp) {
        super(gp);
        type = type_axe;
        name = "Hacked Axe";
        down0=setUp("/item/weapon/axe",gp.tileSize,gp.tileSize);
        attackvalue = 4;
        defensevalue = 2;
        description = "["+name+"]\nAn axe!!!";
        attackArea.width = 100;
        attackArea.height = 100;
        knockBackPower = 10;
    }
    
}
