package object;

import entity.Entity;
import main.GamePanel;

public class Sword extends Entity {

    public Sword(GamePanel gp) {
        super(gp);
        name = "Shit Sword";
        down1=setUp("/item/weapon/sword",gp.tileSize,gp.tileSize);
        attackvalue = 4;
        defensevalue = 1;
        //TODO Auto-generated constructor stub
    }
    
}
