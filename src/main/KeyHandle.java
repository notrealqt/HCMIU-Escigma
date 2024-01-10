package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandle implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed,rightPressed,interPressed,enterPressed,attackPressed;
    //Debug
    boolean debugText = false;

   

    // Constructor to initialize the boolean variables
    public KeyHandle(GamePanel gp) {
        this.gp = gp;
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println("Key pressed: " + code);

        //Title state
        if(gp.gameState == gp.titleState) {
            titleState(code);
        }

        //Play state
        else if(gp.gameState == gp.playState) { //stop player swing when start the game with "else"
            playState(code);
        } 
        
        //Pause state
        else if (gp.gameState == gp.pauseState) {
            pauseState(code);
        }

        //Dialogue state
        else if(gp.gameState == gp.dialogueState) {
            dialogueState(code);
        }

        //Character State
        else if(gp.gameState ==gp.characterState){
            characterState(code);
        }

        //Menu state
        else if(gp.gameState == gp.optionState) {
            menuState(code);
        }
        //You lost state
        else if(gp.gameState == gp.youLostState) {
            youLostState(code);
        } 
        // guide state
        else if(gp.gameState == gp.guideState) {
            guideState(code);
        }
        //menu option state
        else if(gp.gameState == gp.menuOptionState) {
            menuOptionState(code);
        }
        else if (gp.gameState == gp.mapState) {
            mapState(code);
        }
    }

    public void titleState(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                gp.playSE(3);
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 4;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                gp.playSE(3);
                if(gp.ui.commandNum > 4) {
                    gp.ui.commandNum = 0;
                }
            }
           
            if(code == KeyEvent.VK_ENTER) {
                if(gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum == 1) {
                    //Add later
                }
                if(gp.ui.commandNum == 2) {
                    //Add later
                    gp.gameState = gp.guideState;
                }
                if(gp.ui.commandNum == 3) {
                    //Add later
                    gp.gameState = gp.menuOptionState;
                    gp.ui.commandNum = 0;
                }

                if(gp.ui.commandNum == 4) {
                    System.exit(0);
                }
            }
    }
    public void playState(int code){
        if (code == KeyEvent.VK_W) {
            upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(code == KeyEvent.VK_C){
                gp.gameState = gp.characterState;
            }
            if (code == KeyEvent.VK_F) {
                interPressed = true;
            }
            if(code== KeyEvent.VK_ENTER){
                gp.player.selectItem();
            }
// <<<<<<< HEAD
               
// =======
            if (code == KeyEvent.VK_J) {
                // gp.playSE(5);
// >>>>>>> bcaccd040d067d4b04646b740b96173561644dea
                attackPressed = true;
            }
            // Menu
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState= gp.optionState;
            }
            //map
            if(code == KeyEvent.VK_M) {
                gp.gameState = gp.mapState;
            }
            if(code == KeyEvent.VK_X) {
                if(gp.map.miniMapOn == false) {
                    gp.map.miniMapOn = true;
                }
                else { gp.map.miniMapOn = false;}
            }

            //Debug
            if (code == KeyEvent.VK_T) {
                if(debugText == false){
                    debugText = true;
                }
                else if(debugText == true){
                    debugText = false;
                }
            }
            if (code == KeyEvent.VK_R){
                switch(gp.currentMap) {
                    case 0:
                       gp.tileM.loadMap("/res/map/map02.txt", 0);
                       break;

                    //case 1: different map
                }
            }
        }
    
    public void pauseState(int code){
        if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
    }
    public void dialogueState(int code){
        if(code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
    }
    public void characterState(int code){
        if(code == KeyEvent.VK_C) {
                gp.gameState = gp.playState;
            }
            if(code == KeyEvent.VK_W){
                if(gp.ui.slotRow!=0){
                    gp.ui.slotRow--;
                    gp.playSE(3);
                }               
            }
            if(code == KeyEvent.VK_A){
                if(gp.ui.slotCol!=0){
                    gp.ui.slotCol--;
                    gp.playSE(3);
                }
            }
            if(code == KeyEvent.VK_S){ 
                if(gp.ui.slotRow!=3){
                    gp.ui.slotRow++;
                    gp.playSE(3);
                }
                
            }
            if(code == KeyEvent.VK_D){
                if(gp.ui.slotCol!=4){
                    gp.ui.slotCol++;
                    gp.playSE(3);
                }
            }
    }
    public void menuState(int code){
            if(code == KeyEvent.VK_ESCAPE) {
            gp.ui.commandNum = 0;
            gp.ui.SubState = 0;
            gp.gameState = gp.playState;
            }

            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            int maxCommandNum = 0;
            switch(gp.ui.SubState){
                case 0: maxCommandNum = 4; break;
                case 2: maxCommandNum = 2; break;
                case 4: maxCommandNum = 1;break;
                case 5: maxCommandNum = 1;break;
            }

             if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                gp.playSE(3);
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = maxCommandNum;
                }
                
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                gp.playSE(3);
                if(gp.ui.commandNum > maxCommandNum ) {
                    gp.ui.commandNum = 0;
                }
               
            }
            if (code == KeyEvent.VK_A){
                if(gp.ui.SubState == 2){
                    if(gp.ui.commandNum == 0 && gp.music.volumeScale > 0){
                        gp.music.volumeScale--;
                        gp.music.CheckVolume();
                        gp.playSE(3);
                    }
                     if(gp.ui.commandNum == 1 && gp.se.volumeScale > 0){
                        gp.se.volumeScale--;
                        gp.playSE(3);
                    }
                }
            }
            if (code == KeyEvent.VK_D){
                if(gp.ui.SubState == 2){
                    if(gp.ui.commandNum == 0 && gp.music.volumeScale < 5){
                        gp.music.volumeScale++;
                        gp.music.CheckVolume();
                        gp.playSE(3);
                    }
                    if(gp.ui.commandNum == 1 && gp.se.volumeScale < 5){
                        gp.se.volumeScale++;
                        gp.playSE(3);
                    }
                }
            }
    }
    public void youLostState(int code){

     if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                gp.playSE(3);
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1;
                }
                
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                gp.playSE(3);
                if(gp.ui.commandNum > 1 ) {
                    gp.ui.commandNum = 0;
                }
               
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.retry();
                    gp.gameState = gp.playState;
                    
                }
                else if(gp.ui.commandNum==1){
                    gp.restart();
                    gp.gameState = gp.titleState;
                }
            }
}
    public void guideState(int code){
    if(code == KeyEvent.VK_ENTER){
         if(gp.ui.commandNum == 0){
                
            gp.gameState = gp.titleState;
            gp.ui.commandNum = 2;
                    
                }
    }
}
    public void menuOptionState(int code){
        if(code == KeyEvent.VK_ENTER){
                    enterPressed = true;
                }
    
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                gp.playSE(3);
             if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
                
            }
        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            gp.playSE(3);
            if(gp.ui.commandNum > 3) {
                gp.ui.commandNum = 0;
                }
        }
         if (code == KeyEvent.VK_A){
                    if(gp.ui.commandNum == 1 && gp.music.volumeScale > 0){
                        gp.music.volumeScale--;
                        gp.music.CheckVolume();
                        gp.playSE(3);
                    }
                     if(gp.ui.commandNum == 2 && gp.se.volumeScale > 0){
                        gp.se.volumeScale--;
                        gp.playSE(3);
                    }
            }
            if (code == KeyEvent.VK_D){
                
                    if(gp.ui.commandNum == 1 && gp.music.volumeScale < 5){
                        gp.music.volumeScale++;
                        gp.music.CheckVolume();
                        gp.playSE(3);
                    }
                    if(gp.ui.commandNum == 2 && gp.se.volumeScale < 5){
                        gp.se.volumeScale++;
                        gp.playSE(3);
                    }
                
            }
    }
    public void mapState( int code ) {
        if (code == KeyEvent.VK_M) {
            gp.gameState = gp.playState;
        }
    }


    @Override
    public void keyReleased (KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println("Key released: " + code);

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
