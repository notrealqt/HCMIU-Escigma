package items;

import entities.Entity;
import main.GamePanel;

public class Sword extends Entity {

    public Sword(GamePanel gp) {
        super(gp);
        type = type_sword;
        name = "Beginner's Sword";
        down0=setUp("/res/objects/item/weapon/sword/sword",gp.tileSize,gp.tileSize);
        attackvalue = 2;
        defensevalue = 2;
        description = "["+name+"]\nAn old sword";
        attackArea.width = 36;
        attackArea.height = 36;
        knockBackPower = 3;

        //TODO Auto-generated constructor stub
    }
    
}
