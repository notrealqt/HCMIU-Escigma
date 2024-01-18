package items;

import entities.Entity;
import main.GamePanel;

public class Potion_Health extends Entity {
    
    GamePanel gp;
    int value = 0;

    public Potion_Health(GamePanel gp, String name){
        super(gp);
        this.gp = gp;
        this.name = name;
        setDialogue();
        type = type_consumable;
        stackable = true;
        if(this.name == "HP") {
            value = 5;
            down0=setUp("/res/objects/item/consumable/potion_pink",gp.tileSize,gp.tileSize);
            description = "["+name+"] \nheal your life by "+value+".";
        }
    }

    public void setDialogue() {
        dialogues[0][0] = "You drink the "+this.name+" potion!\nYour health has been recovered by "+value+".";
    }

    public boolean use(Entity entity) {
        setDialogue();
        gp.gameState = gp.dialogueState;
        if(this.name == "HP") {
            startDialogue(this, 0);
            entity.life += value;
            if(gp.player.life > gp.player.maxLife) {
                gp.player.life = gp.player.maxLife;
            }
        }
        else {
            startDialogue(this, 0);
        }
        return true;
    }
}
