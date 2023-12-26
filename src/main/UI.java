package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.Heart;
import object.Key;
import object.SuperObject;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font tnr_20, tnr_40, tnr_80;
    BufferedImage keyImage, heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDiaglogue;
    public int commandNum = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        tnr_20 = new Font("Times new Ronman", Font.TRUETYPE_FONT, 20);
        tnr_40 = new Font("Times new Ronman", Font.PLAIN, 40);
        tnr_80 = new Font("Times new Ronman", Font.BOLD, 80);
        Key key = new Key(gp);
        keyImage = key.image;

        //Create hud object
        SuperObject heart = new Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        //Game finished UI
        if(gameFinished == true) {
            
            String text;
            int x;
            int y;
            
            g2.setFont(tnr_40);
            g2.setColor(Color.white);
            text = "You found the treasure!";
            x = getXforCenteredText(text);
            y = gp.screenHeight/2 - gp.tileSize*3;
            g2.drawString(text, x, y);

            g2.setFont(tnr_40);
            g2.setColor(Color.blue);
            text = "Your Time is: "+ dFormat.format(playTime)+". This is world record";
            x = getXforCenteredText(text);
            y = gp.screenHeight/2;
            g2.drawString(text, x, y);

            g2.setFont(tnr_80);
            g2.setColor(Color.red);
            text = "CoNgRaTuLaTiOnS";
            x = getXforCenteredText(text);
            y = gp.screenHeight/2 + gp.tileSize*2;
            g2.drawString(text, x, y);
            
            g2.setFont(tnr_20);
            g2.setColor(Color.yellow);
            text = "Bruh :v";
            x = getXforCenteredText(text);
            y = gp.screenHeight/2 + gp.tileSize*4;
            g2.drawString(text, x, y);
            
            gp.gameThread = null;

        }
        else {
            g2.setFont(tnr_40);
            g2.setColor(Color.black);
            g2.drawImage(keyImage, 15, 500, gp.tileSize, gp.tileSize, null);
            g2.drawString("x"+ gp.player.hasKey, 65, 545);
            
            //Time
            //playTime +=(double)1/60;
            //g2.drawString("Time: "+dFormat.format(playTime), 10, gp.tileSize);


            // Message
            if(messageOn == true){
                
                g2.setFont(g2.getFont().deriveFont(20));
                g2.drawString(message, (gp.screenWidth-g2.getFontMetrics().stringWidth(message))/2 , 550);
                
                messageCounter++;

                if(messageCounter > 120){
                    messageCounter = 0;
                    messageOn = false;
                }
            }    
        }
        
        //Title state
        if(gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        //Play state
        if(gp.gameState == gp.playState) {
            drawPlayerLife();
        }

        //Pause state
        if(gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }

        //Dialogue state
        if(gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }
        
    }
    public void drawPlayerLife() {
        
        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //Draw blank heart
        while(i < gp.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;    
        }

        //Reset
        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;
        
        //Draw current life
        while(i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }
    public void drawTitleScreen() {
        
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        //Title name
        g2.setFont(tnr_80);
        String text = "Maze Raider";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*2;
        //Shadow
        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        //Main color
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        //Main character image
        x = gp.screenWidth/2 - (gp.tileSize*4)/2;
        y += gp.tileSize;
        g2.drawImage(gp.player.down1, x, y, gp.tileSize*4, gp.tileSize*4, null);
        
        //Menu
        g2.setFont(tnr_40);

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*5;
        g2.drawString(text, x, y);
        if(commandNum == 0) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "CONTINUE";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "OPTION";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 3) {
            g2.drawString(">", x-gp.tileSize, y);
        }

    }
    public void drawPauseScreen(){
        g2.setFont(tnr_40);
        String text  = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    public void drawDialogueScreen() {
        //Window
        int x = gp.tileSize*3;
        int y = 420;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*3;
        drawSubWindow(x, y, width, height);

        g2.setFont(tnr_20);
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDiaglogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
        
    }
    public void drawSubWindow(int x, int y, int width, int height) {
        
        Color c = new Color(0,0,0,230);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 100, 100);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 95, 95);

    }
    public int getXforCenteredText(String text){

        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        return x;
    }
    
}
