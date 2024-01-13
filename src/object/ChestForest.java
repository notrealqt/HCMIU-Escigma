package object;

import java.io.IOException;
import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;


public class ChestForest extends Entity{
    
    Entity loot;
    boolean opened = false;

    public ChestForest(GamePanel gp, Entity loot) {
        super(gp);
        this.gp = gp;
        this.loot = loot;

        type = type_obstacle;
        name = "Chest";
        image = setUp("objects/chest_forest_close_0",gp.tileSize, gp.tileSize);
        image2 = setUp("objects/chest_forest_open_0",gp.tileSize, gp.tileSize);
        down0 = image;

        collision = true;
        solidArea.x = 0;
        solidArea.y = 16;
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
        
    }  
    
    public void interact() {
        gp.gameState = gp.dialogueState;
        
        if(opened == false) {
            
            StringBuilder sb = new StringBuilder();
            sb.append("You open the chest and find something.");

            if(gp.player.inventory.size() == gp.player.maxInventorySize) {
                sb.append("\n but you cannot carry anymore.");
            }
            else {
                sb.append("\nYou obtain the "+loot.name+" of Nguyen Trong Thuan's house!");
                gp.player.inventory.add(loot);
                down0 = image2;
                opened = true;
            }
            gp.ui.currentDiaglogue = sb.toString();
        }
        else {
            gp.ui.currentDiaglogue = "It's empty";
        }
    }
}