package tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.UtilityTool;
import java.awt.Graphics2D;
public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][]; 

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[100000000]; //10 types of tiles
    
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/res/map/map02.txt");
    }

    public void getTileImage() {
        try {
        setUp(0, "grass00", false);
        setUp(1, "wall", true);
        setUp(2, "grass00", false);
            //forest theme
                //wall
                    //wall
                    setUp(10, "forest/wall/map_wall_forest_01", true);
                    setUp(11, "forest/wall/map_wall_forest_02", true);
                    setUp(12, "forest/wall head/map_wallhead_forest_01", true);
                    setUp(13, "forest/wall head/map_wallhead_forest_02", true);
                    //corner
                    setUp(14, "forest/wall head bot corner/map_wallhead_botcorner_1", true);
                    setUp(15, "forest/wall head bot corner/map_wallhead_botcorner_2", true);
                //floor
                    //floor
                    setUp(16, "forest/floor/map_floor_forest_01", false);
                    setUp(17, "forest/floor/map_floor_forest_02", false);
                    setUp(18, "forest/floor/map_floor_forest_03", false);
                    setUp(19, "forest/floor/map_floor_forest_04", false);
                    //underwall floor
                    setUp(20, "forest/underwall floor/map_underwall_floor_forest_1", false);
                    setUp(21, "forest/underwall floor/map_underwall_floor_forest_2", false);
                    setUp(22, "forest/underwall floor/map_underwall_floor_forest_3", false);
                    setUp(23, "forest/underwall floor/map_underwall_floor_forest_4", false);

        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
     
    public void setUp(int index, String imageName, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/"+imageName+".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while(col< gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while(col < gp.maxWorldCol ) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol ) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        //50x50 map
        while ( worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            } //better image rendering only draw as player moves
            worldCol++;
            if (worldCol == gp.maxWorldCol ) {
                worldCol = 0;
                worldRow++;
            }
        }

    }
}
