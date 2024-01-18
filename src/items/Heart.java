package items;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entities.Entity;
import main.GamePanel;
import managers.UtilityTool;

public class Heart extends Entity {
    GamePanel gp;

    public Heart (GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = "Heart";
        value = 2;
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
