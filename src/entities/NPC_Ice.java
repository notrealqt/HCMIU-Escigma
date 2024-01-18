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
        String path = "/res/npc/";
        up0 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up1 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up2 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up3 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up4 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up5 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up6 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        up7 = setUp(path + "Ice",gp.tileSize, gp.tileSize);



        down0 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down1 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down2 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down3 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down4 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down5 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down6 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        down7 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        
        left0 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left1 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left2 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left3 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left4 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left5 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left6 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        left7 = setUp(path + "Ice",gp.tileSize, gp.tileSize);

        right0 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        right1 = setUp(path + "Ice",gp.tileSize, gp.tileSize);        
        right2 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        right3 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        right4 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        right5 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        right6 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
        right7 = setUp(path + "Ice",gp.tileSize, gp.tileSize);
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



