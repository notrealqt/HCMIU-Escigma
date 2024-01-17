package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_Injured extends Entity {

    public NPC_Injured(GamePanel gp){
  
        super(gp);
        type = 1;
        direction = "up";
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;
        dialogueSet = -1;
        getImage();
        setDialogue();

    }
    public void getImage(){


    }
    
    public void setDialogue() {
        dialogues[0][0] = "GET OUT OF HERE";
        dialogues[0][1] = "YOU CAN'T WIN AGAINST HIM";

    }
    
    public void speak() {
        facePlayer();
        startDialogue(this, dialogueSet);

        dialogueSet++;

        if (dialogues[dialogueSet][0] == null ) {
            dialogueSet--;
        }
    }
   
}
