package entities;

import main.GamePanel;

public class NPC_Rock extends Entity {

    public NPC_Rock(GamePanel gp){
  
        super(gp);
        type = 1;
        direction = "up";
        speed = 1;

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
        dialogues[0][0] = "Hello, traveler! Welcome to nowhere!";
        dialogues[0][1] = "Sadly, it's nowhere. There is nothing to do";
        dialogues[0][2] = "Oh I know what to do, I'll follow you";
        dialogues[0][3] = "You can run but you can't hide, you can never hide...";
        dialogues[1][0] = " Hello world!";
        dialogues[1][1] = " No code no life";

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



