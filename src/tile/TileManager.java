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

        tile = new Tile[10]; //10 types of tiles
    
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/res/map/map01.txt");
    }

    public void getTileImage() {
        try {
            /* 
            //Old method to setup tile
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/grass00.png")); 

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/wall.png"));
            tile[1].collision = true; //set the tile solid 

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tile/water00.png"));
            tile[2].collision = true; //set the tile solid 
            */
            //Improved method to setup tile (dont even need try catch)
            //setUp(index, image name, collision ? true, false)
            //Faster the code, lesser the pain :v
            setUp(0, "grass00", false);
            setUp(1, "wall", true);
            setUp(2, "water00", true);
            setUp(3, "map-ice_13", false);
            setUp(4, "map-ice_06", true);
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
