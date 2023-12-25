package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandle implements KeyListener {

    public boolean upPressed, downPressed, leftPressed,rightPressed;
    //Debug
    boolean checkDrawtime = false;
    // Constructor to initialize the boolean variables
    public KeyHandle() {
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
