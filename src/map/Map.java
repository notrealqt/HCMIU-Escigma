package map;

import main.GamePanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Map extends TileManager {
    GamePanel gp;
    BufferedImage[] worldMap;

    public boolean miniMapOn = false;
    private double miniMapScaleFactor = 0.2;

    public Map(GamePanel gp) {
        super(gp);
        this.gp = gp;
        createWorldMap();
    }

    public void createWorldMap() {
        worldMap = new BufferedImage[gp.maxMap];
        int worldMapWidth = gp.tileSize * gp.maxWorldCol;
        int worldMapHeight = gp.tileSize * gp.maxWorldRow;

        for (int i = 0; i < gp.maxMap; i++) {
            worldMap[i] = new BufferedImage(worldMapWidth, worldMapHeight, BufferedImage.TYPE_INT_BGR);
            Graphics2D g2 = worldMap[i].createGraphics();

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                int tileNum = mapTileNum[i][col][row];
                int x = gp.tileSize * col;
                int y = gp.tileSize * row;
                g2.drawImage(tile[tileNum].image, x, y, null);

                col++;
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            g2.dispose();
        }
    }

    public void drawFullMapScreen(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.worldWidth, gp.worldHeight);

        int miniMapWidth = 500;
        int miniMapHeight = 500;
        int x = gp.screenWidth / 2 - miniMapWidth / 2;
        int y = gp.screenHeight / 2 - miniMapHeight / 2;
        g2.drawImage(worldMap[gp.currentMap], x, y, miniMapWidth, miniMapHeight, null);

        double scale = (double) (gp.tileSize * gp.maxWorldCol) / miniMapWidth;
        int playerX = (int) (x + gp.player.worldX / scale);
        int playerY = (int) (y + gp.player.worldY / scale);
        double dotScaleFactor = 3;
        int playerSize = (int) (gp.tileSize / scale * dotScaleFactor);
        g2.drawImage(gp.player.down1, playerX, playerY, playerSize, playerSize, null);

        g2.setFont(gp.ui.tnr_40.deriveFont(32f));
        g2.setColor(Color.WHITE);
        g2.drawString("Press M to close", 650, 550);
    }

    public void drawMiniMap(Graphics2D g2) {
        if (miniMapOn) {
            int miniMapWidth = 300;
            int miniMapHeight = 300;
            int x = gp.screenWidth - miniMapWidth - 50;
            int y = 50;

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
            g2.drawImage(worldMap[gp.currentMap], x, y, miniMapWidth, miniMapHeight, null);

            double scale = (double) (gp.tileSize * gp.maxWorldCol) / miniMapWidth;
            int playerX = (int) (x + gp.player.worldX / scale);
            int playerY = (int) (y + gp.player.worldY / scale);
            double dotScaleFactor = 5;
            int playerSize = (int) (gp.tileSize / scale * dotScaleFactor);
            g2.drawImage(gp.player.down1, playerX - 6, playerY - 6, playerSize, playerSize, null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
}
