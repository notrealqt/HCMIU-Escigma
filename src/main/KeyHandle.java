package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandle implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed,rightPressed,interPressed;
    //Debug
    boolean checkDrawtime = false;

   

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
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 3;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum > 3) {
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
                }
                if(gp.ui.commandNum == 3) {
                    System.exit(0);
                }
            }
        }

        //Play state
        else if(gp.gameState == gp.playState) { //stop player swing when start the game with "else"
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
            if (code == KeyEvent.VK_F) {
                interPressed = true;
            }
            // Menu
              if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState= gp.optionState;
            }

            //Debug
            if (code == KeyEvent.VK_T) {
                if(checkDrawtime == false){
                    checkDrawtime = true;
                }
                else if(checkDrawtime == true){
                    checkDrawtime = false;
                }
            }
        } 
        
        //Pause state
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
            }
        }

        //Dialogue state
        else if(gp.gameState == gp.dialogueState) {
            if(code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
        //Menu state
        else if(gp.gameState == gp.optionState) {
            if(code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
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
