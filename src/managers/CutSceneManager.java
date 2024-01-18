package managers;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import entities.Dummy;
import entities.Entity;
import items.Door;
import items.Master_Portal;
import main.GamePanel;

public class CutSceneManager {
    Entity npc;
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;
    int counter = 0;
    float alpha = 0f;
    int y;

    public final int NA = 0;
    public final int boss = 1;
    public final int ending = 2;

    public CutSceneManager(GamePanel gp) {
        this.gp = gp;

    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;

        switch (sceneNum) {
            case boss:
                scene_boss();
                break;
            case ending:
                scene_ending();
                break;
        }
    }

    public void scene_boss() {
        if (scenePhase == 0) {
            System.out.println("Phase: " + scenePhase);
            System.out.println("Player X: " + gp.player.worldX);
            gp.bossBattleOn = true;
            
            //Shut the door
            for (int i = 0; i < gp.obj[1].length - 1; i += 2) {
                if (gp.obj[gp.currentMap][i] == null && gp.obj[gp.currentMap][i + 1] == null) {
                    gp.obj[gp.currentMap][i] = new Door(gp);
                    gp.obj[gp.currentMap][i].worldX = 75 * gp.tileSize;
                    gp.obj[gp.currentMap][i].worldY = 39 * gp.tileSize;
                    gp.obj[gp.currentMap][i].temp = true;

                    gp.obj[gp.currentMap][i + 1] = new Door(gp);
                    gp.obj[gp.currentMap][i + 1].worldX = 75 * gp.tileSize;
                    gp.obj[gp.currentMap][i + 1].worldY = 40 * gp.tileSize;
                    gp.obj[gp.currentMap][i + 1].temp = true;
                    
                    break;
                }
            }
            // Search a vacant alot for dummy
            for (int i = 0; i < gp.npc[1].length; i++) {

                if(gp.npc[gp.currentMap][i] == null) {
                    gp.npc[gp.currentMap][i] = new Dummy(gp);
                    gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
                    gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
                    gp.npc[gp.currentMap][i].direction = gp.player.direction;
                    break;
                }
            }
            gp.player.drawing = false;
            scenePhase++;
        }

        
        if (scenePhase == 1) {
            gp.player.worldX += 2;
            if (gp.player.worldX >= gp.tileSize * 85) {
                scenePhase++;
            }
        }
          
        if (scenePhase == 2) {
            System.out.println("Phase: " + scenePhase);
            System.out.println("Player X: " + gp.player.worldX);
    
            for (int i = 0; i < gp.monster[1].length; i++) {
                if (gp.monster[gp.currentMap][i] != null && gp.monster[gp.currentMap][i].name == "Human Collector" ) {
                    gp.monster[gp.currentMap][i].sleep = false;
                    gp.ui.npc = gp.monster[gp.currentMap][i];
                    scenePhase++;
                    break;
                }
            }
        }
         
        if (scenePhase == 3) {
            gp.ui.drawDialogueScreen();
        }

        
        if (scenePhase == 4) {
            for (int i = 0; i < gp.npc[1].length; i++) {
                if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].name == "Dummy" ) {
                    gp.player.worldX = gp.npc[gp.currentMap][i].worldX;
                    gp.player.worldY = gp.npc[gp.currentMap][i].worldY;

                    gp.npc[gp.currentMap][i] = null;
                    break;
                }
            }

            gp.player.drawing = true;

            sceneNum = NA;
            scenePhase = 0;
            gp.gameState = gp.playState;
        }
        

    }

    public void scene_ending() {
        if (scenePhase == 0) {
            gp.ui.npc = new Master_Portal(gp);
            scenePhase++;   
        }
        if(scenePhase == 1) {
            gp.ui.drawDialogueScreen();
        }
        if (scenePhase == 2) {
            if (counterReached(300) == true) {
                scenePhase++;
            }
        }
        if (scenePhase == 3) {
            alpha += 0.005f;
            if(alpha > 1f) {
                alpha = 1f;
            }
            drawBlackBG(alpha);

            if (alpha == 1f) {
                alpha = 0;
                scenePhase++;
            }
        }
        if(scenePhase == 4) {
            drawBlackBG(1f);
            alpha += 0.005f;
            if(alpha > 1f) {
                alpha = 1f;
            }

            String text = "You have escaped the maze, congratulation!";
            drawString(alpha, 38f, 200, text, 70);
            if (counterReached(600) == true) {
                scenePhase++;
            }
        }
        if(scenePhase == 5) {
            drawBlackBG(1f);
            drawString(1f, 120f, gp.screenHeight/2, "Escigma", 40);

            if (counterReached(480) == true) {
                scenePhase++;

            }
        }


    }
    public boolean counterReached(int target) {
        boolean counterReached = false;
        counter++;
        if(counter > target){
            counterReached = true;
            counter = 0;
        } 
        return counterReached;
    }
    
    public void drawBlackBG(float alpha) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }

    public void drawString(float alpha, float fontSize, int y, String text, int lineHeight) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(fontSize));

        for ( String line: text.split("\n")) {
            int x = gp.ui.getXforCenteredText(line);
            g2.drawString(line, x, y);
            y+= lineHeight;
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    } 
}
