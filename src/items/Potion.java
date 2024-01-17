package items;

import entities.Entity;
import main.GamePanel;

public class Potion extends Entity {
    
    GamePanel gp;
    int value = 0;

    public Potion(GamePanel gp, String name){
        super(gp);
        this.gp = gp;
        this.name = name;
        setDialogue();
        type = type_consumable;
        if(this.name == "HP") {
            value = 5;
            down0=setUp("/res/objects/item/consumable/potion_red",gp.tileSize,gp.tileSize);
            description = "["+name+"] \nheal your life by "+value+".";
        }
        
    }

    public void setDialogue() {
        dialogues[0][0] = "You drink the "+this.name+" potion!\nYour life has been recovered by "+value+".";
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
