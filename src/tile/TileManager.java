package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

import AI.Node;
import main.GamePanel;
import main.UtilityTool;

import java.awt.Color;
import java.awt.Graphics2D;
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][]; 
    boolean drawPath = true;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[100000000]; //10 types of tiles
    
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/res/map/map4.txt",0);
        loadMap("/res/map/map1.txt",1);
    }

    public void getTileImage() {
        try {
        setUp(0, "map_00", true);
        setUp(1, "map_01", true);
        setUp(2, "map_02", true);
        setUp(3, "map_03", true);
        setUp(4, "map_04", true);
        setUp(5, "map_05", true);
        setUp(6, "map_06", true);
        setUp(7, "map_07", false);
        setUp(8, "map_08", false);
        setUp(9, "map_09", false);
        setUp(10, "map_10", false);
        setUp(11, "map_11", false);
        setUp(12, "map_12", false);
        setUp(13, "map_13", false);
        setUp(14, "map_14", false);
        setUp(15, "map_15", false);
        setUp(16, "map_16", false);
        setUp(17, "map_17", false);
        setUp(18, "map_18", false);
        setUp(19, "map_19", false);
        setUp(20, "map_20", false);
        setUp(21, "map_21", false);
        setUp(22, "map_22", false);
        setUp(23, "map_23", false);
        setUp(24, "map_24", true);
        setUp(25, "map_25", true);
        setUp(26, "map_26", true);
        setUp(27, "map_27", true);
        setUp(28, "map_28", true);
        setUp(29, "map_29", true);
        setUp(30, "map_30", false);
        setUp(31, "map_31", false);
        setUp(32, "map_32", false);
        setUp(33, "map_33", false);
        setUp(34, "map_34", false);
        setUp(35, "map_35", false);
        setUp(36, "map_36", false);
        setUp(37, "map_37", false);
        setUp(38, "map_38", false);
        setUp(39, "map_39", false);
        setUp(40, "map_40", false);
        setUp(41, "map_41", false);
        setUp(42, "map_42", false);
        setUp(43, "map_43", false);
        setUp(44, "map_44", false);
        setUp(45, "map_45", true);
        setUp(46, "map_46", true);
        setUp(47, "map_47", true);
        setUp(48, "map_48", true);
        setUp(49, "map_49", true);
        setUp(50, "map_50", true);
        setUp(51, "map_51", false);
        setUp(52, "map_52", false);
        setUp(53, "map_53", false);
        setUp(54, "map_54", false);
        setUp(55, "map_55", false);
        setUp(56, "map_56", false);
        setUp(57, "map_57", false);
        setUp(58, "map_58", false);
        setUp(59, "map_59", false);
        setUp(60, "map_60", false);
        setUp(61, "map_61", false);
        setUp(62, "map_62", false);
        setUp(63, "map_63", false);
        setUp(64, "map_64", false);
        setUp(65, "map_65", false);
        setUp(66, "map_66", false);
        setUp(67, "map_67", false);
        setUp(68, "map_68", false);
        setUp(69, "map_69", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
     
    public void setUp(int index, String imageName, boolean collision) {
        collision = false;
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/maptile/"+imageName+".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadMap(String filePath, int map) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filePath)))) {
            int col = 0;
            int row = 0;
    
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
    
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    mapTileNum[map][col][row] = Integer.parseInt(numbers[col]);
                    col++;
                }
    
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;
        int tileSize = gp.tileSize;
        int playerWorldX = gp.player.worldX;
        int playerWorldY = gp.player.worldY;
        int playerScreenX = gp.player.screenX;
        int playerScreenY = gp.player.screenY;
    
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];
    
            int worldX = worldCol * tileSize;
            int worldY = worldRow * tileSize;
            int screenX = worldX - playerWorldX + playerScreenX;
            int screenY = worldY - playerWorldY + playerScreenY;
    
            if (worldX + tileSize > playerWorldX - playerScreenX &&
                    worldX - tileSize < playerWorldX + playerScreenX &&
                    worldY + tileSize > playerWorldY - playerScreenY &&
                    worldY - tileSize < playerWorldY + playerScreenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, tileSize, tileSize, null);
            }
    
            worldCol++;
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    
        if (drawPath) {
            g2.setColor(new Color(255, 0, 0, 70));
    
            for (Node node : gp.pFinder.pathList) {
                int worldX = node.col * tileSize;
                int worldY = node.row * tileSize;
                int screenX = worldX - playerWorldX + playerScreenX;
                int screenY = worldY - playerWorldY + playerScreenY;
    
                g2.fillRect(screenX, screenY, tileSize, tileSize);
            }
        }
    }
}