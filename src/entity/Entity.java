package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

    GamePanel gp;
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, up3, up0, up4, up5, up6, up7,up8,up9;
    public BufferedImage down0, down1, down2, down3, down4, down5, down6, down7, down8, down9;
    public BufferedImage left0, left1, left2, left3, left4, left5, left6, left7, left8, left9;
    public BufferedImage right0, right1, right2, right3, right4, right5, right6, right7, right8, right9;
    public BufferedImage idleUp, idleDown, idleLeft, idleRight;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 0;
    
    //This would set solidArea for all entities, we can change it by override like in Player
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction() {

    }
    public void update(){

        setAction();

        collisionOn = false;
        gp.colDect.checkTile(this);
        gp.colDect.checkObject(this, false);
        gp.colDect.checkPlayer(this);
        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                case "upleft":
                    worldX -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    worldY -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    break;
                case "upright":
                    worldX += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    worldY -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    break;
                case "downleft":
                    worldX -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    worldY += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    break;
                case "downright":
                    worldX += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    worldY += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                    break;
            }
        }

        //npc image changes every 12 frames
        spriteCounter++;
        if (spriteCounter >  12) {
            if (spriteNum == 0) {
                spriteNum = 1;
            }
            else if (spriteNum == 1) {
                spriteNum = 0;
            }
            spriteCounter = 0;
        }
    } 


    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                
                switch (direction) {
                    case "up":
                        if (spriteNum == 0) {
                            image = up0;
                        }
                        if (spriteNum == 1) {
                            image = up1;
                        }
                        break;
                    case "down":
                        if (spriteNum == 0) {
                            image = down0;
                        }
                        if (spriteNum == 1) {
                            image = down1;
                        }
                        break;
                    case "left":
                        if (spriteNum == 0) {
                            image = left0;
                        }
                        if (spriteNum == 1) {
                            image = left1;
                        }
                        break;
                    case "right":
                        if (spriteNum == 0) {
                            image = right0;
                        }
                        if (spriteNum == 1) {
                            image = right1;
                        }
                        break;
                    case "upleft":
                        if (spriteNum == 0) {
                            image = up0;
                        }
                        if (spriteNum == 1) {
                            image = up1;
                        }
                        break;
                    case "upright":
                        if (spriteNum == 0) {
                            image = up0;
                        }
                        if (spriteNum == 1) {
                            image = up1;
                        }
                        break;
                    case "downleft":
                        if (spriteNum == 0) {
                            image = down0;
                        }
                        if (spriteNum == 1) {
                            image = down1;
                        }
                        break;
                    case "downright":
                        if (spriteNum == 0) {
                            image = down0;
                        }
                        if (spriteNum == 1) {
                            image = down1;
                        }
                        break;
    
                }
            g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);
        }
    }
    public BufferedImage setUp(String imagePath) {
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/"+imagePath+".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    } 
}
