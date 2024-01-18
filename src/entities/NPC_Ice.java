package entities;

import main.GamePanel;

public class NPC_Ice extends Entity {

    public NPC_Ice(GamePanel gp){
  
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
        up0 = setUp("/res/npc/Ice",gp.tileSize, gp.tileSize);

    }
    
    public void setDialogue() {
        dialogues[0][0] = "The winter is coming";
        dialogues[0][1] = "It is cold";
        dialogues[0][2] = "Beware of the monstersssss";
        dialogues[1][0] = "Good bye, traveler. I hope you enjoy the weather.";

    }

    public void speak() {
        startDialogue(this, dialogueSet);

        dialogueSet++;

        if (dialogues[dialogueSet][0] == null ) {
            dialogueSet--;
        }
    }
   
}



