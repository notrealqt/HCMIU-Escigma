package entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandle;
import main.UtilityTool;

public class Player extends Entity {

    KeyHandle keyH;
    public final int screenX;
    public final int screenY; //where player on the screen
    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandle keyH) {

        super(gp);
        type = 0;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2); //player's pos at center

        solidArea = new Rectangle(); //setting the solid area of character based on 16x3 pixels
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValue();
        getPlayerImage();

    }

    public void setDefaultValue() {
        worldX = gp.tileSize * 21; //player's pos in world map
        worldY = gp.tileSize * 18;
        speed = 4;
        direction = "down";

        //Player status
        maxLife = 10;
        life = maxLife;
    }

    public void getPlayerImage() {
        
        //old method
        try {
            //idle animation
            idleUp = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_back_0.png"));
            idleDown = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_font_0.png"));
            idleRight = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_right_0.png"));
            idleLeft = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_idle_left_0.png")); 

            //up
            up0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_8.png"));
            up9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_9.png"));

            //down
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_0.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_6.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_7.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_8.png"));
            down9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_9.png"));

            //left
            left0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_0.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_7.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_8.png"));
            left9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_9.png"));

            //right
            right0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_0.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_8.png"));
            right9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_9.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        /* 

        //new method
        idleUp = setUp("1_player_idle_back_0");
        idleDown = setUp("1_player_idle_font_0");
        idleRight = setUp("1_player_idle_right_0");
        idleLeft = setUp("1_player_idle_left_0");

        up0 = setUp("1_player_move_back_0");
        up1 = setUp("1_player_move_back_1");
        up2 = setUp("1_player_move_back_2");
        up3 = setUp("1_player_move_back_3");
        up4 = setUp("1_player_move_back_4");
        up5 = setUp("1_player_move_back_5");
        up6 = setUp("1_player_move_back_6");
        up7 = setUp("1_player_move_back_7");
        up8 = setUp("1_player_move_back_8");
        up9 = setUp("1_player_move_back_9");

        down0 = setUp("1_player_move_font_0");
        down1 = setUp("1_player_move_font_1");
        down2 = setUp("1_player_move_font_2");
        down3 = setUp("1_player_move_font_3");
        down4 = setUp("1_player_move_font_4");
        down5 = setUp("1_player_move_font_5");
        down6 = setUp("1_player_move_font_6");
        down7 = setUp("1_player_move_font_7");
        down8 = setUp("1_player_move_font_8");
        down9 = setUp("1_player_move_font_9");

        
        left0 = setUp("1_player_move_left_0");
        left1 = setUp("1_player_move_left_1");
        left2 = setUp("1_player_move_left_2");
        left3 = setUp("1_player_move_left_3");
        left4 = setUp("1_player_move_left_4");
        left5 = setUp("1_player_move_left_5");
        left6 = setUp("1_player_move_left_6");
        left7 = setUp("1_player_move_left_7");
        left8 = setUp("1_player_move_left_8");
        left9 = setUp("1_player_move_left_9");


        right0 = setUp("1_player_move_right_0");
        right1 = setUp("1_player_move_right_1");
        right2 = setUp("1_player_move_right_2");
        right3 = setUp("1_player_move_right_3");
        right4 = setUp("1_player_move_right_4");
        right5 = setUp("1_player_move_right_5");
        right6 = setUp("1_player_move_right_6");
        right7 = setUp("1_player_move_right_7");
        right8 = setUp("1_player_move_right_8");
        right9 = setUp("1_player_move_right_9");
        */
    }
    
    /* 
    public BufferedImage setUp(String imageName) {
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/player/"+imageName+".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    } 
    */

    public void update() {
        //System.out.println("Update method called");
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || (keyH.leftPressed && keyH.upPressed) == true || (keyH.rightPressed && keyH.upPressed) == true || (keyH.leftPressed && keyH.downPressed) == true || (keyH.rightPressed && keyH.downPressed == true) || keyH.interPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
                //System.out.println("Up pressed: " + playerX + ", " + playerY);
            }
            if (keyH.downPressed == true) {
                direction = "down";
                //System.out.println("Down pressed: " + playerX + ", " + playerY);

            }
            if (keyH.leftPressed == true) {
                direction = "left";
                //System.out.println("Left pressed: " + playerX + ", " + playerY);

            }
            if ( keyH.rightPressed == true) {
                direction = "right";
                //System.out.println("Right pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.upPressed && keyH.leftPressed) == true) {
                direction = "upleft";
                //System.out.println("Up left pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.upPressed && keyH.rightPressed) == true) {
                direction = "upright";
                //System.out.println("Up right pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.downPressed && keyH.leftPressed) == true) {
                direction = "downleft";
                //System.out.println("Down left pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.downPressed && keyH.rightPressed) == true) {
                direction = "downright";
                //System.out.println("Down right pressed: " + playerX + ", " + playerY);
            }

            //Check tile collision
            collisionOn = false;
            gp.colDect.checkTile(this);

            //Check object collison
            int objIndex = gp.colDect.checkObject(this, true);
            pickUpObject(objIndex);

            //Check NPC collision
            int npcIndex = gp.colDect.checkEntity(this, gp.npc);
            interactNPC(npcIndex);
            //Check event
            gp.eHandler .checkEvent();
            gp.KeyH.interPressed = false;

            //Check monster collision
            int monsterIndex = gp.colDect.checkEntity(this, gp.monster);
            encounterMonster(monsterIndex);
            
            //if collision is false, player can move 
            if (collisionOn == false && keyH.interPressed==false) {     //interact without moving
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
            gp.KeyH.interPressed = false;

            //player image changes every 6 frames
            spriteCounter++;
            if (spriteCounter >  6) {
                if (spriteNum == 0) {
                    spriteNum =1;
                }
                else if (spriteNum == 1) {
                    spriteNum =2;
                }
                else if (spriteNum == 2) {
                    spriteNum =3;
                }
                else if (spriteNum == 3) {
                    spriteNum =4;
                }
                else if (spriteNum == 4) {
                    spriteNum =5;
                }
                else if (spriteNum == 5) {
                    spriteNum =6;
                }
                else if (spriteNum == 6) {
                    spriteNum =7;
                }
                else if (spriteNum == 7) {
                    spriteNum =8;
                }
                else if (spriteNum == 8) {
                    spriteNum =9;
                }
                else if (spriteNum == 9) {
                    spriteNum =0;
                }
                spriteCounter =0;
            }
        }
    //invincible time must outside of the key if statement
    if(invincible == true){
        invincibleCounter++;
        if(invincibleCounter > 60){
            invincible = false;
            invincibleCounter = 0;
            }
        }
    }
    public void pickUpObject(int i){
        if(i!=9999){
            String objectName = gp.obj[i].name;
            switch(objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey>0){
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    else {
                        gp.ui.showMessage("You need a key to open!");
                    }
                    break;
                case "Boots":
                    gp.playSE(1);
                    speed += 2;
                    gp.obj[i] = null;
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(2);
                    break;
            }
        }
    }
    public void interactNPC(int i) {
        if(i!=9999) {
            if(gp.KeyH.interPressed == true) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        
    }
    public void encounterMonster(int i) {
        if (i!=9999){
            if(invincible == false){
                life -=1;  
                invincible = true;              
            }

        }
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white); // set color to use for drawing objects
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || (keyH.leftPressed && keyH.upPressed) == true || (keyH.rightPressed && keyH.upPressed) == true || (keyH.leftPressed && keyH.downPressed) == true || (keyH.rightPressed && keyH.downPressed) == true) {
            switch (direction) {
                case "up":
                    if (spriteNum == 0) {
                        image = up0;
                    }
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    if (spriteNum == 3) {
                        image = up3;
                    }
                    if (spriteNum == 4) {
                        image = up4;
                    }
                    if (spriteNum == 5) {
                        image = up5;
                    }
                    if (spriteNum == 6) {
                        image = up6;
                    }
                    if (spriteNum == 7) {
                        image = up7;
                    }
                    if (spriteNum == 8) {
                        image = up8;
                    }
                    if (spriteNum == 9) {
                        image = up9;
                    }
                    break;
                case "down":
                    if (spriteNum == 0) {
                        image = down0;
                    }
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = down3;
                    }
                    if (spriteNum == 4) {
                        image = down4;
                    }
                    if (spriteNum == 5) {
                        image = down5;
                    }
                    if (spriteNum == 6) {
                        image = down6;
                    }
                    if (spriteNum == 7) {
                        image = down7;
                    }
                    if (spriteNum == 8) {
                        image = down8;
                    }
                    if (spriteNum == 9) {
                        image = down9;
                    }
                    break;
                case "left":
                    if (spriteNum == 0) {
                        image = left0;
                    }
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    }
                    if (spriteNum == 4) {
                        image = left4;
                    }
                    if (spriteNum == 5) {
                        image = left5;
                    }
                    if (spriteNum == 6) {
                        image = left6;
                    }
                    if (spriteNum == 7) {
                        image = left7;
                    }
                    if (spriteNum == 8) {
                        image = left8;
                    }
                    if (spriteNum == 9) {
                        image = left9;
                    }
                    break;
                case "right":
                    if (spriteNum == 0) {
                        image = right0;
                    }
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                    if (spriteNum == 5) {
                        image = right5;
                    }
                    if (spriteNum == 6) {
                        image = right6;
                    }
                    if (spriteNum == 7) {
                        image = right7;
                    }
                    if (spriteNum == 8) {
                        image = right8;
                    }
                    if (spriteNum == 9) {
                        image = right9;
                    }
                    break;
                case "upleft":
                if (spriteNum == 0) {
                    image = up0;
                }
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                if (spriteNum == 5) {
                    image = up5;
                }
                if (spriteNum == 6) {
                    image = up6;
                }
                if (spriteNum == 7) {
                    image = up7;
                }
                if (spriteNum == 8) {
                    image = up8;
                }
                if (spriteNum == 9) {
                    image = up9;
                }
                    break;
                case "upright":
                if (spriteNum == 0) {
                    image = up0;
                }
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                if (spriteNum == 5) {
                    image = up5;
                }
                if (spriteNum == 6) {
                    image = up6;
                }
                if (spriteNum == 7) {
                    image = up7;
                }
                if (spriteNum == 8) {
                    image = up8;
                }
                if (spriteNum == 9) {
                    image = up9;
                }
                    break;
                case "downleft":
                if (spriteNum == 0) {
                    image = down0;
                }
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                if (spriteNum == 5) {
                    image = down5;
                }
                if (spriteNum == 6) {
                    image = down6;
                }
                if (spriteNum == 7) {
                    image = down7;
                }
                if (spriteNum == 8) {
                    image = down8;
                }
                if (spriteNum == 9) {
                    image = down9;
                }
                    break;
                case "downright":
                if (spriteNum == 0) {
                    image = down0;
                }
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                if (spriteNum == 5) {
                    image = down5;
                }
                if (spriteNum == 6) {
                    image = down6;
                }
                if (spriteNum == 7) {
                    image = down7;
                }
                if (spriteNum == 8) {
                    image = down8;
                }
                if (spriteNum == 9) {
                    image = down9;
                }
                    break;

            }
        }
        else {
            // Character is idle
            switch (direction) {
                case "up":
                    image = idleUp;
                    break;
                case "down":
                    image = idleDown;
                    break;
                case "left":
                    image = idleLeft;
                    break;
                case "right":
                    image = idleRight;
                    break;
        }
        }
            if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // //DEBUG monster hit player
        // g2.setFont(new Font("Arial", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invincible:"+invincibleCounter,10,400);
    }
}
