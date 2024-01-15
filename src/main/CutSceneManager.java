package main;

import java.awt.Graphics2D;

public class CutSceneManager {
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;
    

    public final int NA = 0;
    public final int boss = 1;

    public CutSceneManager(GamePanel gp) {
        this.gp = gp;

    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;

        switch (sceneNum) {
            case boss:
                scene_boss();
                break;
        
            default:
                break;
        }
    }

    public void scene_boss() {
        if (scenePhase == 0) {
            gp.bossBatleOn = true;
            
        }
    }
}
