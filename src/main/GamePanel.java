package main;

import javax.swing.JPanel;

import AI.PathFinder;
import data.SaveLoad;
import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile.Map;
import tile.TileManager;
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

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; //16x16 size
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //960 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels
    
    //WORLD SETTING
    public final int maxWorldCol = 120;
    public final int maxWorldRow = 120;
    public final int maxMap = 10;
    public int currentMap = 0;


    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FULL SCREEN
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    public boolean fullScrennOn = false;

    //FPS
    int FPS = 60;

    //System
    public TileManager tileM = new TileManager(this);
    public KeyHandle KeyH = new KeyHandle(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionDetector colDect = new CollisionDetector(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Config config= new Config(this);
    Map map = new Map(this);
    public PathFinder pFinder = new PathFinder(this);
    EnvironmentManager eManager = new EnvironmentManager(this);
    SaveLoad saveLoad = new SaveLoad(this);
    public CutSceneManager csManager = new CutSceneManager(this);
    Thread gameThread;

    //Entity and object
    public Player player = new Player(this, KeyH);
    public Entity obj[][] = new Entity[maxMap][1000]; // decide the number of objs
    public Entity npc[][] = new Entity[maxMap][1000];  // decide the number of npcs
    public Entity monster[][] = new Entity[maxMap][1000]; // decide the number of monsters
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    //Game state 
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionState=5;
    public final int youLostState=6;
    public final int guideState = 7;
    public final int menuOptionState = 8;
    public final int mapState = 10;
    public final int cutScene = 11;
    public int currentArea;

    public boolean bossBatleOn = false;


    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth,screenHeight));
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
        g2 = (Graphics2D)tempScreen.getGraphics();

        if(fullScrennOn == true){
            setFullScreen();
        }

    }
    
    public void setFullScreen() {
        //LOCAL SCREEN DEVICE
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);

        //FULL SCREEN WIDTH AND HEIGHT
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();

    }
    
    public void startGameThread () {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
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
            for(int i =0; i< projectileList.size(); i++){
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
        long drawStart = 0;
        if(KeyH.debugText == true){
            drawStart = System.nanoTime();
        }
        
        //Title screen
        if(gameState == titleState) {
            ui.draw(g2);
        }
        //Map screen
        else if (gameState == mapState) {
            map.drawFullMapScreen(g2);
        }
        else { 
            //Tile
            tileM.draw(g2);

            //Add entities to the list
            //Add Player
            entityList.add(player);
            //Add NPC
            for( int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null) {
                    entityList.add(npc[currentMap][i]);
                }
            }
            //Add object
            for( int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null) {
                    entityList.add(obj[currentMap][i]);
                }
            }
            //Add monster to entity list
            for(int i =0; i< monster[1].length; i++) {
                if(monster[currentMap][i] != null) {
                    entityList.add(monster[currentMap][i]);
                }
            }
            for(int i =0; i< projectileList.size(); i++) {
                if(projectileList.get(i) != null) {
                    entityList.add(projectileList.get(i));
                }
            }
            
            //Sort entities
            Collections.sort(entityList, new Comparator<Entity>() {
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });
            
            //Draw entities
            for(int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            //Empty entity list
            entityList.clear();
            //MINIMAP
            if(map.miniMapOn == true){
            map.drawMiniMap(g2);
            }
            //cutscene
            csManager.draw(g2);
            
            //eManager.draw(g2);
            //UI
            ui.draw(g2);
        }
        
        

        //Debug
        if(KeyH.debugText == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;

            g2.setFont(new Font("Arial",Font.PLAIN,20));
            g2.setColor(Color.black);
            int x = 10;
            int y = 400;
            int lineHeight = 20;

            g2.drawString("X coord: " + player.worldX,x,y); y+= lineHeight;
            g2.drawString("Y coord: " + player.worldY,x,y); y+= lineHeight;
            g2.drawString("Col "+(player.worldX+player.solidArea.x)/tileSize,x,y); y+= lineHeight;
            g2.drawString("Row "+(player.worldY+player.solidArea.y)/tileSize,x,y); y+= lineHeight;
            g2.drawString("Draw Time: "+passed, x, y);
            //System.out.println("Draw Time: "+passed);
        }
    }

    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0,screenWidth2,screenHeight2,null);
        g.dispose();

    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSE(int i){
        se.setFile(i);
        se.play();
    }

    public void resetGame (boolean restart) {
        removeTempEntity();
        bossBatleOn = false;
        player.setDefaultLife();
        player.setDefaultPosition();
        aSetter.setNPC();
        aSetter.setMonster();
        if (restart == true) {
            player.setDefaultValue();
        }
    }

    public void removeTempEntity() {
        for (int mapNum = 0; mapNum < maxMap; mapNum++) {
            for (int i =0; i < obj[1].length; i++) {
                if (obj[mapNum][i] != null && obj[mapNum][i].temp == true) {
                    obj[mapNum][i] = null;
                }
            }
        }
    }
}
