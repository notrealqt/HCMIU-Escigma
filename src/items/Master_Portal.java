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
        collision = false;
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDialogues() ;
    }

    public void setDialogues() {
        dialogues[0][0] = "You have the master key";
        dialogues[0][1] = "You can now escape this place.";
    }
    public boolean use( Entity entity) {
        gp.gameState = gp.cutScene;
        gp.csManager.sceneNum = gp.csManager.ending;
        return true;
    }
}
