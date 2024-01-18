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
        String path = "/res/npc/";
        up0 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up1 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up2 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up3 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up4 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up5 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up6 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        up7 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);



        down0 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down1 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down2 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down3 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down4 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down5 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down6 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        down7 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        
        left0 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left1 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left2 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left3 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left4 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left5 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left6 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        left7 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);

        right0 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        right1 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);        
        right2 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        right3 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        right4 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        right5 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        right6 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);
        right7 = setUp(path + "Injured",gp.tileSize, gp.tileSize*2);    }
    
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
