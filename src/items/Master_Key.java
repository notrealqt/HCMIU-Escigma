package items;

import entities.Entity;
import main.GamePanel;

public class Master_Key extends Entity {
    Entity entity;
    public Master_Key(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_consumable;
        name = "Master Key";
        down0=setUp("/res/objects/item/use/master_key",gp.tileSize,gp.tileSize);
        description = "["+name+"]\nKey to open Portal\nIt's time to go home";

        setDialogue();
        
    }
    
    public void setDialogue() {
        dialogues[0][0] = "You use the " + name + " and open the Portal";
        dialogues[0][1] = "Thank you for playing our game.";
        dialogues[1][0] = "Bruh";
    }

    public boolean use(Entity entity){
        
        int objIndex = getDetected(entity, gp.obj, "Master Portal");
        if(objIndex != 9999) {
            startDialogue(this, 0);
            entity.opening = true;
            //gp.resetGame(true);
            return true;
        }
        else {
            startDialogue(this, 1);
            return false;
        }
        
    
    }
    
}
