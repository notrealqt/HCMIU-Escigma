package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class Heart extends Entity {
    GamePanel gp;

    public Heart (GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = "Heart";
        value = 2;
        // UtilityTool uTool = new UtilityTool();
        // BufferedImage down1, image, image2, image3 = null;
        // try {
        //     down1=ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/full.png"));
        //     image = ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/full.png"));
        //     image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/half.png"));
        //     image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/blank.png"));
        //     down1 = uTool.scaleImage(down1, gp.tileSize, gp.tileSize);
        //     this.image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        //     this.image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
        //     this.image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        down1 = setUp ("/res/objects/item/stat/heart/full",gp.tileSize,gp.tileSize);
        image = setUp("/res/objects/item/stat/heart/full",gp.tileSize,gp.tileSize);
        image2 = setUp("/res/objects/item/stat/heart/half",gp.tileSize,gp.tileSize);
        image3 = setUp("/res/objects/item/stat/heart/blank",gp.tileSize,gp.tileSize);
        
    }
    public boolean use(Entity entity){

    gp.ui.addMessage ("Life +" + value);
    entity.life += value;
    if(entity.life>entity.maxLife){
        entity.life = entity.maxLife;
        }
        return true;
    }
}
