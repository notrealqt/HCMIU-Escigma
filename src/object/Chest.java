package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;


public class Chest extends Entity{
    


    public Chest(GamePanel gp, String openImage, String closeImage, Entity loot) {
        super(gp);
        this.gp = gp;
        this.loot = loot;
        type = type_obstacle;
        name = "Chest";
        image = setUp("objects/"+closeImage,gp.tileSize, gp.tileSize);
        image2 = setUp("objects/"+openImage,gp.tileSize, gp.tileSize);
        down0 = image;

        collision = true;
        solidArea.x = 0;
        solidArea.y  = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        

        /* 
        try {
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        setDialogue();
    } 
    public void setLoot (Entity loot) {
        this.loot = loot;
        setDialogue();
    }

    public void setDialogue() {
        dialogues[0][0] = "You open the chest and find something.\n...But you cannot carry anymore";
        dialogues[1][0] = "You open the chest and find something.\nYou obtain the " + loot.name + "!";
        dialogues[2][0] = "It's empty";
    }

    public void interact() {

        if(opened == false) {
            if(gp.player.inventory.size() == gp.player.maxInventorySize) {
                startDialogue(this, 0);
            }
            else {
                startDialogue(this, 1);
                down0 = image2;
                opened = true;
            }
        }
        else {
            startDialogue(this, 2);
        }
    }

}