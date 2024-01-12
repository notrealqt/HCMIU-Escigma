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
        down0 = setUp("objects/key",gp.tileSize, gp.tileSize);
        description = "["+name+"]\nKey to open door\nWhat do you expect more?";
        /*
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("key."));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        
    }
    public boolean use(Entity entity){
        gp.gameState = gp.dialogueState;
        
        int objIndex = getDetected(entity, gp.obj, "Door");
        if(objIndex != 9999) {
            gp.ui.currentDiaglogue = "You use the " + name + " and open the door";
            gp.obj[gp.currentMap][objIndex] = null;
            return true;
        }
        else {
            gp.ui.currentDiaglogue = "Bruh";
            return false;
        }
    }
}
