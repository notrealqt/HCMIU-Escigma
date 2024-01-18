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
        String path = "/res/npc/";
        up0 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up1 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up2 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up3 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up4 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up5 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up6 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        up7 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);



        down0 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down1 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down2 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down3 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down4 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down5 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down6 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        down7 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        
        left0 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left1 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left2 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left3 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left4 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left5 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left6 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        left7 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);

        right0 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        right1 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);        
        right2 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        right3 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        right4 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        right5 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        right6 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);
        right7 = setUp(path + "Death",gp.tileSize, gp.tileSize*2);

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



