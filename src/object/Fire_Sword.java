package object;

import entity.Entity;
import main.GamePanel;

public class Fire_Sword extends Entity {

    public Fire_Sword(GamePanel gp) {
        super(gp);
        type = type_sword;
        name = "Fire Sword";
        down0=setUp("/item/weapon/fire sword/fire_sword",gp.tileSize,gp.tileSize);
        attackvalue = 99;
        defensevalue = 1;
        description = "["+name+"]\nA fire sword which used belong to\nan Australian painter";
        attackArea.width = 200;
        attackArea.height = 100;
        knockBackPower = 0;

        //TODO Auto-generated constructor stub
    }
    
}
