package main;

import javax.swing.JPanel;

import entities.Entity;
import entities.Player;
import managers.AssetSetter;
import managers.CollisionDetector;
import managers.Config;
import managers.CutSceneManager;
import managers.EnvironmentManager;
import managers.EventHandler;
import managers.KeyHandle;
import managers.Sound;
import managers.UI;
import map.Map;
import map.TileManager;
import mics.PathFinder;
import mics.SaveLoad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable, GameConstants {
    BufferedImage tempScreen;
    Graphics2D g2;
    public int currentMap = 0;
    int originalTileSize = 16, scale = 3, maxScreenCol = 20, maxScreenRow = 12;
    public int tileSize = originalTileSize * scale;
    public int maxWorldCol = 120, maxWorldRow = 120, maxMap = 10, FPS = 60;

    public int  worldWidth = tileSize * maxWorldCol,
                worldHeight = tileSize * maxWorldRow,
                screenWidth = tileSize * maxScreenCol,
                screenHeight = tileSize * maxScreenRow,
                screenWidth2 = screenWidth,
                screenHeight2 = screenHeight;

    // Game state
    public int  titleState = 0, playState = 1, pauseState = 2, 
                dialogueState = 3, characterState = 4, optionState = 5, 
                youLostState = 6, guideState = 7, menuOptionState = 8,
                mapState = 10, cutScene = 11;

    // System
    public TileManager tileM = new TileManager(this);
    public KeyHandle KeyH = new KeyHandle(this);
    public Sound music = new Sound();
    public Sound se = new Sound();
    public CollisionDetector colDect = new CollisionDetector(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    public Config config = new Config(this);
    public Map map = new Map(this);
    public PathFinder pFinder = new PathFinder(this);
    EnvironmentManager eManager = new EnvironmentManager(this);
    public SaveLoad saveLoad = new SaveLoad(this);
    public CutSceneManager csManager = new CutSceneManager(this);
    public Thread gameThread;

    // Entity and object
    public Player player = new Player(this, KeyH);
    public Entity obj[][] = new Entity[maxMap][1000];
    public Entity npc[][] = new Entity[maxMap][1000];
    public Entity monster[][] = new Entity[maxMap][1000];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    // Game state
    public int gameState, currentArea;
    public boolean fullScreenOn = false, bossBattleOn = false;

    
    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.black);
        setDoubleBuffered(true);
        addKeyListener(KeyH);
        setFocusable(true);
        eManager.setup();
    }
    
    public void setupGame() {
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        playMusic(0);
        stopMusic();
        gameState = titleState;
    
        tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = tempScreen.createGraphics();
    
        if (fullScreenOn) {
            setFullScreen();
        }
    }
    
    public void setFullScreen() {
        // LOCAL SCREEN DEVICE
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);
    
        // FULL SCREEN WIDTH AND HEIGHT
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
    }
    
    public void startGameThread () {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += ( currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                drawToTempScreen();
                drawToScreen();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update() {

        if(gameState == playState){
            player.update();
            for(int i = 0; i< npc[1].length; i++){
                if(npc[currentMap][i] != null) {
                    npc[currentMap][i].update();
                }
            }
            for(int i =0; i< monster[1].length; i++){
                if(monster[currentMap][i] != null) {
                    if(monster[currentMap][i].alive==true && monster[currentMap][i].die==false){
                        monster[currentMap][i].update();
                    }
                    if(monster[currentMap][i].alive==false) {monster[currentMap][i]=null;}
                }
            }
            for(int i =0; i<projectileList.size(); i++){
                if(projectileList.get(i) != null) {
                    if(projectileList.get(i).alive== true){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive==false) {projectileList.remove(i);}
                }
            }
        }
        if(gameState == pauseState){

        }
        
    }
    
    public void drawToTempScreen() {
        long drawStart = KeyH.debugText ? System.nanoTime() : 0;
    
        // Title screen
        if (gameState == titleState) {
            ui.draw(g2);
        }
        // Map screen
        else if (gameState == mapState) {
            map.drawFullMapScreen(g2);
        } else {
            // Draw Tile
            tileM.draw(g2);
    
            // Add entities to the list
            entityList.add(player);
            addEntitiesToList(npc[currentMap]);
            addEntitiesToList(obj[currentMap]);
            addEntitiesToList(monster[currentMap]);
            entityList.addAll(projectileList);
    
            // Sort entities
            Collections.sort(entityList, Comparator.comparingInt(e -> e.worldY));
    
            // Draw entities
            for (Entity entity : entityList) {
                entity.draw(g2);
            }
            // Clear entity list
            entityList.clear();
    
            // Draw MiniMap
            if (map.miniMapOn) {
                map.drawMiniMap(g2);
            }
            //light
            //eManager.draw(g2);

            // Draw cutscene
            csManager.draw(g2);
    
            // Draw UI
            ui.draw(g2);
        }
    
        // Debug
        if (KeyH.debugText) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
    
            g2.setFont(new Font("Arial", Font.PLAIN, 20));
            g2.setColor(Color.black);
            int x = 10;
            int y = 400;
            int lineHeight = 20;
    
            g2.drawString("X coord: " + player.worldX, x, y);
            y += lineHeight;
            g2.drawString("Y coord: " + player.worldY, x, y);
            y += lineHeight;
            g2.drawString("Col " + (player.worldX + player.solidArea.x) / tileSize, x, y);
            y += lineHeight;
            g2.drawString("Row " + (player.worldY + player.solidArea.y) / tileSize, x, y);
            y += lineHeight;
            g2.drawString("Draw Time: " + passed, x, y);
            y += lineHeight;
            g2.drawString("God Mode:" + KeyH.godMode, x, y);
        }
    }
    
    private void addEntitiesToList(Entity[] entities) {
        for (Entity entity : entities) {
            if (entity != null) {
                entityList.add(entity);
            }
        }
    }
    
    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
        g.dispose();
    }
    
    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    
    public void stopMusic() {
        music.stop();
    }
    
    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }
    
    public void resetGame(boolean restart) {
        removeTempEntity();
        player.inventory.clear();
        player.setDefaultValue();
        bossBattleOn = false;
        player.setDefaultLife();
        player.setDefaultPosition();
        aSetter.setNPC();
        aSetter.setMonster();
        
        if (restart) {
            player.inventory.clear();
            player.setDefaultValue();
        }
    }
    
    public void removeTempEntity() {
        for (int mapNum = 0; mapNum < maxMap; mapNum++) {
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[mapNum][i] != null && obj[mapNum][i].temp) {
                    obj[mapNum][i] = null;
                }
            }
        }
    }
    
    /*
    public void changeArea() {
        if (nextArea != currentArea) {
            eSetter.setNPC();
        }
    }
    currentArea = nextArea;
    aSetter.setMonster();
     */
}
