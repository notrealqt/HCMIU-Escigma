package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.Key;

public class UI {
    
    GamePanel gp;
    Font tnr_20, tnr_40, tnr_80;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        tnr_20 = new Font("Times new Ronman", Font.TRUETYPE_FONT, 20);
        tnr_40 = new Font("Times new Ronman", Font.PLAIN, 40);
        tnr_80 = new Font("Times new Ronman", Font.BOLD, 80);
        Key key = new Key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        if(gameFinished == true) {
            
            String text;
            int textLength;
            int x;
            int y;
            
            g2.setFont(tnr_40);
            g2.setColor(Color.white);
            text = "You found the treasure!";
            textLength = (int)(g2.getFontMetrics().getStringBounds(text, g2)).getWidth();
            x = (gp.screenWidth - textLength)/2;
            y = gp.screenHeight/2 - gp.tileSize*3;
            g2.drawString(text, x, y);

            g2.setFont(tnr_40);
            g2.setColor(Color.blue);
            text = "Your Time is: "+ dFormat.format(playTime)+". This is world record";
            textLength = (int)(g2.getFontMetrics().getStringBounds(text, g2)).getWidth();
            x = (gp.screenWidth - textLength)/2;
            y = gp.screenHeight/2;
            g2.drawString(text, x, y);

            g2.setFont(tnr_80);
            g2.setColor(Color.red);
            text = "CoNgRaTuLaTiOnS";
            textLength = (int)(g2.getFontMetrics().getStringBounds(text, g2)).getWidth();
            x = (gp.screenWidth - textLength)/2;
            y = gp.screenHeight/2 + gp.tileSize*2;
            g2.drawString(text, x, y);
            
            g2.setFont(tnr_20);
            g2.setColor(Color.yellow);
            text = "Bruh :v";
            textLength = (int)(g2.getFontMetrics().getStringBounds(text, g2)).getWidth();
            x = (gp.screenWidth - textLength)/2;
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
            playTime +=(double)1/60;
            g2.drawString("Time: "+dFormat.format(playTime), 10, gp.tileSize);


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
        
    }
}
