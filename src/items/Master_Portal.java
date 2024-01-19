package items;

import entities.Entity;
import main.GamePanel;

public class Master_Portal extends Entity {
    GamePanel gp;
    public static final String objName = "Master Portal";
    public Master_Portal(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = objName;
        down0 = setUp("/res/objects/door/master_gate",gp.tileSize, gp.tileSize);
        collision = true;
        opening = false;
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDialogues() ;
    }

    public void setDialogues() {
        dialogues[0][0] = "You need a speacial key for this door";
    }
    public void interact() {
        if(opening == false) {
            startDialogue(this, 0);
            opening = true;
        }
    }
}