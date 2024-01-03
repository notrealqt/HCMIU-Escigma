package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
//sdf
    GamePanel gp;
    public BufferedImage up1, up2, up3, up0, up4, up5, up6, up7,up8,up9;
    public BufferedImage down0, down1, down2, down3, down4, down5, down6, down7, down8, down9;
    public BufferedImage left0, left1, left2, left3, left4, left5, left6, left7, left8, left9;
    public BufferedImage right0, right1, right2, right3, right4, right5, right6, right7, right8, right9;
    public BufferedImage idleUp, idleDown, idleLeft, idleRight;
    public BufferedImage upAttack1, downAttack1, leftAttack1, rightAttack1, upAttack2, downAttack2, leftAttack2, rightAttack2, upAttack3, downAttack3, leftAttack3, rightAttack3, upAttack4, downAttack4, leftAttack4, rightAttack4;
    public BufferedImage image, image2, image3, image4, image5; //heart image
    String dialogues[] = new String[30];
    //This would set solidArea for all entities, we can change it by override like in Player
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    //State sdfsdfsdf
    public int worldX, worldY;
    public String direction = "down";
    public int spriteNum = 0;
    int dialogueIndex = 0;
    public boolean collision = false;
    //take damage from monster from amount of time
    //avoid taking constantly damage
    public boolean invincible =false;
    boolean attacking=false;
    public boolean die = false;
    public boolean alive = true;
   
    //Counter
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;
    public int dieCounter =0;

    //attributes for character   
    public int speed;
    public int maxLife;
    public int life;
    public int type; //0 -> player, 1 -> npcs, 2 -> monster
    public String name;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction() {}
    public void damagereaction() {}
    public void speak() {
        if(dialogues[dialogueIndex] == null) {
            dialogueIndex = 0;
        }
        gp.ui.currentDiaglogue = dialogues[dialogueIndex];
        dialogueIndex++;
        switch(gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;    
            case "upleft":
                direction = "right";
                break;
            case "upright":
                direction = "left";
                break;
            case "downleft":
                direction = "right";
                break;
            case "downright":
                direction = "left";
                break;
        }        
    }
    public void update(){

        setAction();

        collisionOn = false;
        gp.colDect.checkTile(this);
        gp.colDect.checkObject(this, false);
        gp.colDect.checkEntity(this, gp.npc);    //check collision between entities (npc and monster)
        gp.colDect.checkEntity(this, gp.monster);
        boolean hitplayer = gp.colDect.checkPlayer(this);

        if(this.type == 2 && hitplayer == true){
            if(gp.player.invincible == false){
                //player take damage
                gp.player.life -= 1;
                gp.player.invincible = true;
            }
        }
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
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
                }
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
                //get invincible for entities
                if(invincible == true){
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
                }
                if (die == true){
                    dieAnimation(g2);
                }
                
            g2.drawImage(image, screenX, screenY, gp.tileSize,gp.tileSize, null);

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
    public void dieAnimation(Graphics2D g2){
        dieCounter++;

        if(dieCounter <= 5){changeAlpha(g2,0f);}
        if(dieCounter>5&&dieCounter<=10) {changeAlpha(g2,1f);}
        if(dieCounter>10&&dieCounter<=15) {changeAlpha(g2,0f);}
        if(dieCounter>15&&dieCounter<=20) {changeAlpha(g2,1f);}
        if(dieCounter>20&&dieCounter<=25) {changeAlpha(g2,0f);}
        if(dieCounter>25&&dieCounter<=30) {changeAlpha(g2,1f);}
        if(dieCounter>30&&dieCounter<=35) {changeAlpha(g2,0f);}
        if(dieCounter>40){
            die = false;
            alive = false;
        }
    }
        public void changeAlpha(Graphics2D g2, float alphaValue) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    };
    public BufferedImage setUp(String imagePath, int width, int height) {
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/"+imagePath+".png"));
            image = uTool.scaleImage(image, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    } 
}
