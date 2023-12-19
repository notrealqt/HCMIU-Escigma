package entity;

import java.awt.Color;
import java.awt.Graphics2D;
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

    }

    public void setDefaultValue() {
        x= 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public void update() {
        //System.out.println("Update method called");

        if (keyH.upPressed == true) {
            y -= speed;
            //System.out.println("Up pressed: " + playerX + ", " + playerY);

        }
        else if (keyH.downPressed == true) {
            y += speed;
            //System.out.println("Down pressed: " + playerX + ", " + playerY);

        }
        else if (keyH.leftPressed == true) {
            x -= speed;
            //System.out.println("Left pressed: " + playerX + ", " + playerY);

        }
        else if ( keyH.rightPressed == true) {
            x+= speed;
            //System.out.println("Right pressed: " + playerX + ", " + playerY);

        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white); // set color to use for drawing objects
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
