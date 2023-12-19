package entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandle;

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandle keyH;

    public Player(GamePanel gp, KeyHandle keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        x= 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            //up
            up0 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_8.png"));
            up9 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_font_9.png"));







            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_back_1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_left_1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/1_player_move_right_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        //System.out.println("Update method called");

        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
            //System.out.println("Up pressed: " + playerX + ", " + playerY);

        }
        else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
            //System.out.println("Down pressed: " + playerX + ", " + playerY);

        }
        else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
            //System.out.println("Left pressed: " + playerX + ", " + playerY);

        }
        else if ( keyH.rightPressed == true) {
            direction = "right";
            x+= speed;
            //System.out.println("Right pressed: " + playerX + ", " + playerY);

        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white); // set color to use for drawing objects
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
