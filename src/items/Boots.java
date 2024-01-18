package items;

import entities.Entity;
import main.GamePanel;

public class Boots extends Entity{
    public Boots(GamePanel gp) {
        super(gp);
        type = type_consumable;
        name = "Boots";
        defensevalue = 2;
        down0 = setUp("/res/objects/item/armor/boots",gp.tileSize, gp.tileSize); 
        description = "["+name+"]\nHermes' boots";
        stackable = false;
        speed = 1;
    } 
}
