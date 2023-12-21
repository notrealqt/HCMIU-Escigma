package main;

import object.Key;

//instantiate objects class
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 4 * gp.tileSize;
        gp.obj[0].worldY = 2 * gp.tileSize;

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 8 * gp.tileSize;
        gp.obj[1].worldY = 4 * gp.tileSize;
    }
}
