package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; //16x16 size
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    KeyHandle KeyH = new KeyHandle();
    Thread gameThread;

    //set player's dafault position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }
    public void startGameThread () {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while (gameThread != null) {
            //1 Update position
            update();
            //2 draw the screen with updated information
            repaint();
        }
    }
    public void update() {
        if (KeyH.upPressed == true) {
            playerY -= playerSpeed;
        }
        else if (KeyH.downPressed == true) {
            playerY += playerSpeed;
        }
        else if (KeyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if ( KeyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }
    //draw things 
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required whenever creating this method.
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white); // set color to use for drawing objects
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();
    }
}
