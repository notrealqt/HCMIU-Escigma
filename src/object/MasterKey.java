package object;

import entity.Entity;
import main.GamePanel;

public class MasterKey extends Entity {
    GamePanel gp;
    public static final String objName = "Master Key";

    public MasterKey(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = objName;
        down0=setUp("objects/master_key",gp.tileSize,gp.tileSize);

        //setDialogues();
    }

    public void setDialogues() {
        //dialogues[0][0] = "You pick up the master key";

    }
    
}
