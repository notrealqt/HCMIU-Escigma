package main;

import javax.swing.JPanel;
import entity.Player;
import object.SuperObject;
import tile.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; //16x16 size
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    //WORLD SETTING
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandle KeyH = new KeyHandle();
    Sound sound = new Sound();
    Thread gameThread;
    public CollisionDetector colDect = new CollisionDetector(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, KeyH);
    public SuperObject obj[] = new SuperObject[10]; // decide the number of objs


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);

    }

    public void setupGame() {
        aSetter.setObject();
        playMusic(0);
    }

    public void startGameThread () {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while (gameThread != null) {
            double drawInterval = 1000000000/FPS;
            double nextDrawTime = System.nanoTime() + drawInterval;
            update();

           //System.out.println("Repaint method called");

            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {
        player.update();
    }
    //draw things 
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required whenever creating this method.
        Graphics2D g2 = (Graphics2D)g;
        //Tile
        tileM.draw(g2);

        //Object
        for( int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        //Player
        player.draw(g2);

        g2.dispose();
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }
}
