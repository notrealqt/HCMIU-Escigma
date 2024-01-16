package object;

import entity.Entity;
import main.GamePanel;

public class Sword extends Entity {

    public Sword(GamePanel gp) {
        super(gp);
        type = type_sword;
        name = "Shit Sword";
        down0=setUp("/item/weapon/sword",gp.tileSize,gp.tileSize);
        attackvalue = 1;
        defensevalue = 1;
        description = "["+name+"]\nAn old sword";
        attackArea.width = 36;
        attackArea.height = 36;
        knockBackPower = 3;

        //TODO Auto-generated constructor stub
    }
    
}
