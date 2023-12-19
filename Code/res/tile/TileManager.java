package res.tile;

import java.io.IOException;

import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10]; //10 types of tiles
        //getTileImage();
    }

    /*public void getTileImage() {
        try {
            tile[0] = new Tile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
}
