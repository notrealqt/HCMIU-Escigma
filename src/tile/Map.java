package tile;

import main.GamePanel;
import java.awt.image.BufferedImage;

public class Map extends TileManager {
    GamePanel gp;
    BufferedImage worldMap[];

    public boolean miniMapOn = false;

    public Map(GamePanel gp) {
        super(gp);
        this.gp = gp;

    }

    public void createWorldMap() {
        //worldMap = new BufferedImage[gp.maxMap];
        int worldMapWidth = gp.tileSize * gp.maxWorldCol;

    }
    
    
}
