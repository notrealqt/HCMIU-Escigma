package main;

import java.awt.Graphics2D;

import entity.Dummy;
import entity.Entity;
import monster.m_Boss;
import object.Door;

public class CutSceneManager {
    GamePanel gp;
    Graphics2D g2;
    public int sceneNum;
    public int scenePhase;
    private boolean phase1Completed = false;

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
            System.out.println("Phase: " + scenePhase);
            System.out.println("Player X: " + gp.player.worldX);
            gp.bossBatleOn = true;
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
                }
            }
            gp.player.drawing = false;
            scenePhase++;
        }

        if (scenePhase == 1) {
            gp.player.worldX += 2;
            if (gp.player.worldX >= gp.tileSize * 85 && !phase1Completed) {
                scenePhase++;
                phase1Completed = true;
            }
        }
        if (scenePhase == 2) {
            System.out.println("Phase: " + scenePhase);
            System.out.println("Player X: " + gp.player.worldX);
            boolean bossFound = false;
    
            for (int i = 0; i < gp.monster[1].length; i++) {
                if (gp.monster[gp.currentMap][i] != null && gp.monster[gp.currentMap][i] instanceof m_Boss) {
                    m_Boss m_Boss = (m_Boss) gp.monster[gp.currentMap][i];
                    m_Boss.sleep = false;
                    gp.ui.npc = m_Boss;
                    bossFound = true;
                    break;
                }
            }
    
            if (bossFound) {
                scenePhase++; // Move to the next phase only if the boss is found
            }
        }

        if (scenePhase == 3) {
            System.out.println("Phase: " + scenePhase);
            System.out.println("Player X: " + gp.player.worldX);
            gp.ui.drawDialogueScreen();
            scenePhase++;
        }
        if (scenePhase == 4) {
            for (int i = 0; i < gp.npc[1].length; i++) {
                if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].name.equals(Dummy.npcName) ) {
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
}
