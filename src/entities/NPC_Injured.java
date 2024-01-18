package entities;

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
        up0 = setUp("/res/npc/Injured",gp.tileSize, gp.tileSize*2);
    }
    
    public void setDialogue() {
        dialogues[0][0] = "It's like a relentless, stabbing ache—right here";
        dialogues[0][1] = "I guess you're too late";
        dialogues[0][2] = "Gooooo, and escape from here";

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
