package entities;

import main.GamePanel;

public class NPC_Forest extends Entity {

    public NPC_Forest(GamePanel gp){
  
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
        up0 = setUp("/res/npc/Forest",gp.tileSize, gp.tileSize);

    }
    
    public void setDialogue() {
        dialogues[0][0] = "Hello, traveler! Welcome to nowhere!";
        dialogues[0][1] = "I guess you're lost huh?";
        dialogues[0][2] = "Well, I don't see many people around here usually.";
        dialogues[0][3] = "I guess there was someone came here just a minute ago.";
        dialogues[1][0] = "Well you found me again.";
        dialogues[1][1] = "I guess this is goodbye since you now have solved the maze and you can go up now.";
    }

    public void speak() {
        startDialogue(this, dialogueSet);
        dialogueSet++;

        if (dialogues[dialogueSet][0] == null ) {
            dialogueSet--;
        }
    }
   
}



