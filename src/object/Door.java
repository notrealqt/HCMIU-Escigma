package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;

public class Door extends Entity{

    GamePanel gp;
    public Door(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_obstacle;
        name = "Door";
        down0 = setUp("objects/Door",gp.tileSize, gp.tileSize);
        collision = true;
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDialogue();
    } 
    public void setDialogue() {
        dialogues[0][0] = "You need a key to open this door";
    }
    public void interact() {
        
        startDialogue(this, 0);
    }
}
