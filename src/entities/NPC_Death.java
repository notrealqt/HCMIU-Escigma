package entities;

import main.GamePanel;

public class NPC_Death extends Entity {

    public NPC_Death(GamePanel gp){
  
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
        up0 = setUp("/res/npc/Death",gp.tileSize, gp.tileSize*2);

    }
    
    public void setDialogue() {
        dialogues[0][0] = "Nahm nahm nahm nahm nahm *slurp*";
        dialogues[0][1] = "Only death awaits your traveler, please go back to where you were.";

    }

    public void speak() {
        startDialogue(this, dialogueSet);

        dialogueSet++;

        if (dialogues[dialogueSet][0] == null ) {
            dialogueSet--;
        }
    }
   
}



