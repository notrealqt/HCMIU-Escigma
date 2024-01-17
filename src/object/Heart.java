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
        name = "Heart";
        UtilityTool uTool = new UtilityTool();
        BufferedImage image, image2, image3 = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/objects/item/stat/heart/blank.png"));
            this.image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            this.image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            this.image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
