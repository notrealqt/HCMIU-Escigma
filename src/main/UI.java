package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import entity.Entity;
import object.Heart;
import object.Key;

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
    int SubState = 0;


    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        tnr_20 = new Font("Times new Ronman", Font.TRUETYPE_FONT, 20);
        tnr_40 = new Font("Times new Ronman", Font.PLAIN, 40);
        tnr_80 = new Font("Times new Ronman", Font.BOLD, 80);
        Entity key = new Key(gp);
        keyImage = key.down0;

        //Create hud object
        Heart heart = new Heart(gp);
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
        //Menu State
         if(gp.gameState == gp.optionState) {
            drawOptionScreen();
        }
        //Character State
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
        }
        //You lost state
         if(gp.gameState == gp.youLostState) {
            drawYouLostScreen();
        }
        // guide State
         if(gp.gameState == gp.guideState)
            drawGuideScreen();
        // menu option state
         if(gp.gameState == gp.menuOptionState)
            drawMenuOptionScreen();
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
        
        // switch (SubState) {
        //    case 0: 
        // }
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
        g2.drawImage(gp.player.down1, x, y, gp.tileSize*3, gp.tileSize*3, null);
        
        //Menu
        g2.setFont(tnr_40);

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
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
        text = "GUIDE";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2) {
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "OPTION";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 3) {
            g2.drawString(">", x-gp.tileSize, y);
            //   if(gp.KeyH.enterPressed == true){
                    
            //            drawOptionMenuScreen();
            //     }
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 4) {
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

    public void drawCharacterScreen(){
        //make a frame
        final int frameX = gp.tileSize*2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize*5;
        final int frameHeight = gp.tileSize*10;
        drawSubWindow (frameX, frameY, frameWidth, frameHeight);

        //some text
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));

        int textX = frameX + 20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 32;

        //Name
        g2.drawString("Life", textX, textY);
        textY += lineHeight;
        g2.drawString("Str", textX, textY);
        textY += lineHeight;
        g2.drawString("Dex", textX, textY);
        textY += lineHeight;
        g2.drawString("Atk", textX, textY);
        textY += lineHeight;
        g2.drawString("Def", textX, textY);
        textY += lineHeight;
        g2.drawString("Coin", textX, textY);
        textY += lineHeight;
        g2.drawString("Weapon", textX, textY+60);
        textY += lineHeight;
        
        //value
        int tailX = (frameX + frameWidth) - 30;
        //reset textY
        textY = frameY + gp.tileSize;
        String value;

        value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.strength);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.dexterity);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.coin);
        textX = getXforAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        g2.drawImage(gp.player.currentWeapon.down1,tailX - gp.tileSize, textY+=35, null);
        textY += lineHeight;


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
    public int getXforAlignToRightText(String text, int tailX){
            
            int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x = tailX - length;
            return x;
    }
    public void drawOptionScreen(){
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        //Sub Window
        int frameX = gp.tileSize*6;
        int frameY = gp.tileSize;
        int frameWidth=gp.tileSize*8;
        int frameHeight = gp.tileSize*10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        switch (SubState) {
            case 0: options_top(frameX , frameY);break;
            case 1: options_FullScreenNotification(frameX,frameY); break;
            case 2: options_Volume(frameX,frameY); break;
            case 3: options_Guide(frameX,frameY); break;
            case 4: options_EndGameComfirmation(frameX,frameY); break;
            case 5: options_QuitGameComfirmation(frameX,frameY); break;
        }
      gp.KeyH.enterPressed=false;

    }
    public void options_top(int frameX,int frameY){
            int textX;
            int textY;
            //Title
            String text = "Menu" ;
            textX = getXforCenteredText(text);
            textY = frameY + gp.tileSize;
            g2.drawString(text, textX, textY);
            // Full Screen mode ON/OFF
            textX = frameX + gp.tileSize;
            textY += gp.tileSize*2;
            g2.drawString("Full Screen", textX, textY);
            if(commandNum == 0){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    if(gp.fullScrennOn == false){
                        gp.fullScrennOn = true;
                    }else if(gp.fullScrennOn == true){
                        gp.fullScrennOn = false;}
                        SubState = 1;
                }
            }
            //Volume 
            textY += gp.tileSize;
            g2.drawString("Volume", textX, textY);
             if(commandNum == 1){
                g2.drawString("👉", textX-40, textY);
                 if(gp.KeyH.enterPressed == true){
                    
                        SubState = 2;
                        commandNum =0;
                }
            }
            //Guide
            textY += gp.tileSize;
            g2.drawString("Guide", textX, textY);
             if(commandNum == 2){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                
                        SubState = 3;
                        commandNum =0;
                }
            }
            //Return to Title
             textY += gp.tileSize;
            g2.drawString("Back to title screen", textX, textY);
             if(commandNum == 3){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                
                        SubState = 4;
                        commandNum =0;
                }
            }
            //Exit
             textY += gp.tileSize;
            g2.drawString("Exit", textX, textY);
             if(commandNum == 4){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                
                        SubState = 5;
                        commandNum =0;
                }
            }
            //FullScrenn Check BOX
            textX= frameX + gp.tileSize*5;
            textY= frameY + gp.tileSize*3;
            g2.drawString("✰", textX, textY);
            if(gp.fullScrennOn== true){
                g2.drawString("★", textX, textY);
            }
            gp.config.saveConfig();
        }
    public void options_FullScreenNotification(int frameX,int frameY){
            int textX= frameX + gp.tileSize;
            int textY= frameY + gp.tileSize*3;
            currentDiaglogue= "The change will be \neffect after restart";
            for (String line: currentDiaglogue.split("\n")){
                g2.drawString(line, textX, textY);
                textY += 40;
            }
            //Back
            textY = frameY + gp.tileSize*9;
            g2.drawString("Back", textX, textY);
            if (commandNum == 0) {
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    SubState = 0;
                }
            }else{commandNum = 0;}
            
            
           
        }
    public void options_Volume(int frameX,int frameY){
            
           int textY ;
            int textX ;
             String text = "Volume";
            textX= getXforCenteredText(text);
            textY = frameY + gp.tileSize;
            g2.drawString(text, textX, textY);
            //Music 
            textX= frameX + gp.tileSize;
            textY += gp.tileSize;
            g2.drawString("Music", textX, textY);
            if(commandNum == 0){
                g2.drawString("👉", textX-40, textY);
            }
            
            //Sound Effect
            textY += gp.tileSize*2;
            g2.drawString("SE", textX, textY);
             if(commandNum == 1){
                g2.drawString("👉", textX-40, textY);
            } 
            //Back
            textY = frameY + gp.tileSize*9;
            g2.drawString("Back", textX, textY);
             if(commandNum == 2){
                g2.drawString("👉", textX-40, textY);
            }
            if (commandNum == 2) {
                if(gp.KeyH.enterPressed == true){
                    SubState = 0;
                    commandNum = 1;
                }
            }
            
             //Music CheckBox
            textX= frameX + gp.tileSize*4;
            textY= frameY - 20 + gp.tileSize*2;
            g2.drawRect(textX, textY , 120, 24);
            int volumeWidth= 24 * gp.music.volumeScale;
            g2.fillRect(textX, textY, volumeWidth, 24);;

            // Sound Effect Check Box
            textY += gp.tileSize*2;
            g2.drawRect(textX, textY , 120, 24);
            volumeWidth= 24 * gp.se.volumeScale;
            g2.fillRect(textX, textY, volumeWidth, 24);
           gp.config.saveConfig();
        }
    public void options_Guide(int frameX,int frameY){
            int textY ;
            int textX  ;

            //Title
            String text = "Guide";
            textX= getXforCenteredText(text);
            textY = frameY + gp.tileSize;
            g2.drawString(text, textX, textY);

            textX= frameX + gp.tileSize;
            textY += gp.tileSize;
            g2.drawString("Move", textX, textY);  textY += gp.tileSize;
            g2.drawString("Interact", textX, textY);  textY += gp.tileSize;
            g2.drawString("Pause", textX, textY);  textY += gp.tileSize;
            // g2.drawString("Move", textX, textY);  textY += gp.tileSize;
            // g2.drawString("Move", textX, textY);  textY += gp.tileSize;
            // g2.drawString("Move", textX, textY);  textY += gp.tileSize;

            textX= frameX + gp.tileSize*5;
            textY = frameY + gp.tileSize*2;
            g2.drawString("WASD", textX, textY);  textY += gp.tileSize;
            g2.drawString("F", textX, textY);  textY += gp.tileSize;
            g2.drawString("P", textX, textY);  textY += gp.tileSize;
            //Back
            textX= frameX + gp.tileSize;
            textY = frameY + gp.tileSize*9;
            g2.drawString("Back", textX, textY);
            if (commandNum == 0) {
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    SubState = 0;
                    commandNum=2;
                }
            }else{commandNum = 0;}
        }
    public void options_EndGameComfirmation(int frameX,int frameY){
            int textX= frameX + gp.tileSize;
            int textY= frameY + gp.tileSize*3;
            currentDiaglogue= "Quit the game and \nreturn title screen ?";
            for (String line: currentDiaglogue.split("\n")){
                g2.drawString(line, textX, textY);
                textY += 40;
            }
            //YES
            String text="Yes";
            textX = getXforCenteredText(text);
            textY += gp.tileSize*3;
            g2.drawString(text, textX, textY);
            if(commandNum == 0){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    SubState=0;
                    gp.restart();
                    gp.gameState = gp.titleState;
                }
            }
            //NO
              text="No";
            textX = getXforCenteredText(text);
            textY += gp.tileSize;
            g2.drawString(text, textX, textY);
            if(commandNum == 1){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    SubState=0;
                    commandNum=3;
                }
            }
        }
    public void options_QuitGameComfirmation(int frameX,int frameY){
            int textX= frameX + gp.tileSize;
            int textY= frameY + gp.tileSize*3;
            currentDiaglogue= "Do you want \nto quit the game ?";
            for (String line: currentDiaglogue.split("\n")){
                g2.drawString(line, textX, textY);
                textY += 40;
            }
            //YES
            String text="Yes";
            textX = getXforCenteredText(text);
            textY += gp.tileSize*3;
            g2.drawString(text, textX, textY);
            if(commandNum == 0){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    SubState=0;
                    System.exit(0);
                    
                }
            }
            //NO
              text="No";
            textX = getXforCenteredText(text);
            textY += gp.tileSize;
            g2.drawString(text, textX, textY);
            if(commandNum == 1){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    SubState=0;
                    commandNum=4;
                }
            }
        }

        
    public void drawYouLostScreen(){
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));

        text = "You Lost";
        //Shadow for You Lost
        g2.setColor(Color.black);
        x= getXforCenteredText(text);
        y= gp.tileSize*4;
        g2.drawString(text, x, y);
        // Main text 
        g2.setColor(Color.red);
        x= getXforCenteredText(text);
        y= gp.tileSize*4;
        g2.drawString(text, x-4, y-4);

        //Retry
          g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getXforCenteredText(text);
        y += gp.tileSize*4;
        g2.drawString(text, x, y);
         if(commandNum == 0){
                g2.drawString("👉", x-50, y);
         }

        //Back to the title screen
         text = "Quit";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text, x, y);
        if(commandNum == 1){
                g2.drawString("👉", x-50, y);
         }
    }
    public void drawGuideScreen(){
       g2.setColor(Color.black);;
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        //Sub Window
        int frameX = gp.tileSize*6;
        int frameY = gp.tileSize;
        int frameWidth=gp.tileSize*8;
        int frameHeight = gp.tileSize*10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        int textY ;
            int textX  ;

            //Title
            String text = "Guide";
            textX= getXforCenteredText(text);
            textY = frameY + gp.tileSize;
            g2.drawString(text, textX, textY);

            textX= frameX + gp.tileSize;
            textY += gp.tileSize;
            g2.drawString("Move", textX, textY);  textY += gp.tileSize;
            g2.drawString("Interact", textX, textY);  textY += gp.tileSize;
            g2.drawString("Pause", textX, textY);  textY += gp.tileSize;
            // g2.drawString("Move", textX, textY);  textY += gp.tileSize;
            // g2.drawString("Move", textX, textY);  textY += gp.tileSize;
            // g2.drawString("Move", textX, textY);  textY += gp.tileSize;

            textX= frameX + gp.tileSize*5;
            textY = frameY + gp.tileSize*2;
            g2.drawString("WASD", textX, textY);  textY += gp.tileSize;
            g2.drawString("F", textX, textY);  textY += gp.tileSize;
            g2.drawString("P", textX, textY);  textY += gp.tileSize;
            //Back
            textX= frameX + gp.tileSize;
            textY = frameY + gp.tileSize*9;
            g2.drawString("Back", textX, textY);
            if (commandNum == 0) {
                g2.drawString("👉", textX-40, textY);
            }else{commandNum = 0;}

      gp.KeyH.enterPressed=false;

    }

    public void drawMenuOptionScreen(){
       g2.setColor(Color.black);;
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        //Sub Window
        int frameX = gp.tileSize*4;
        int frameY = gp.tileSize;
        int frameWidth=gp.tileSize*12;
        int frameHeight = gp.tileSize*10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        int textY ;
            int textX  ;

            //Title
            String text = "Setting";
            textX= getXforCenteredText(text);
            textY = frameY + gp.tileSize;
            g2.drawString(text, textX, textY);

            
             // Full Screen mode ON/OFF
            textX = frameX + gp.tileSize;
            textY += gp.tileSize;
            g2.drawString("Full Screen", textX, textY);
            if(commandNum == 0){
                g2.drawString("👉", textX-40, textY);
                if(gp.KeyH.enterPressed == true){
                    if(gp.fullScrennOn == false){
                        gp.fullScrennOn = true;
                    }else if(gp.fullScrennOn == true){
                        gp.fullScrennOn = false;}
                       
                }
            }
             //Music 
           textY += gp.tileSize;
            g2.drawString("Music", textX, textY);
            if(commandNum == 1){
                g2.drawString("👉", textX-40, textY);
            }
            
            //Sound Effect
           textY += gp.tileSize;
            g2.drawString("SE", textX, textY);
             if(commandNum == 2){
                g2.drawString("👉", textX-40, textY);
            } 
             //FullScrenn Check BOX
            textX= frameX + gp.tileSize*5;
            textY= frameY + gp.tileSize*2;
            g2.drawString("✰ Change after restart", textX, textY);
            if(gp.fullScrennOn== true){
                g2.drawString("★ Change after restart", textX, textY);
            }
             //Music CheckBox
            textX= frameX + gp.tileSize*5;
            textY= frameY - 20 + gp.tileSize*3;
            g2.drawRect(textX, textY , 120, 24);
            int volumeWidth= 24 * gp.music.volumeScale;
            g2.fillRect(textX, textY, volumeWidth, 24);;

            // Sound Effect Check Box
            textY += gp.tileSize;
            g2.drawRect(textX, textY , 120, 24);
            volumeWidth= 24 * gp.se.volumeScale;
            g2.fillRect(textX, textY, volumeWidth, 24);
            
            

            gp.config.saveConfig();
            //Back
            textX= frameX + gp.tileSize;
            textY = frameY + gp.tileSize*9;
            g2.drawString("Back", textX, textY);
            if (commandNum == 3) {
                g2.drawString("👉", textX-40, textY);    
            }
             if (commandNum == 3) {
                if(gp.KeyH.enterPressed == true){
                    gp.gameState = gp.titleState;
                    commandNum = 3;
                }
            }

      gp.KeyH.enterPressed=false;

    }

    }
