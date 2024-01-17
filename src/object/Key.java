package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Key extends Entity {

    public Key (GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "Key";
        down0 = setUp("/res/objects/item/use/key",gp.tileSize, gp.tileSize);
        description = "["+name+"]\nKey to open door\nWhat do you expect more?";
        /*
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("key."));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        setDialogue();
        
    }
    
    public void setDialogue() {
        dialogues[0][0] = "You use the " + name + " and open the door";
        dialogues[1][0] = "Bruh";
    }

    public boolean use(Entity entity){
        
        int objIndex = getDetected(entity, gp.obj, "Door");
        if(objIndex != 9999) {
            startDialogue(this, 0);
            gp.obj[gp.currentMap][objIndex] = null;
            return true;
        }
        else {
            startDialogue(this, 1);
            return false;
        }
    }
}
