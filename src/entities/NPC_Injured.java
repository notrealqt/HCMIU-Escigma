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
        up0 = setUp("/res/npc/Injured",gp.tileSize, gp.tileSize);
    }
    
    public void setDialogue() {

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
