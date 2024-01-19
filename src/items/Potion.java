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
        stackable = true;
        if(this.name == "HP Potion") {
            value = 2;
            down0=setUp("/res/objects/item/use/potion_heath_0",gp.tileSize,gp.tileSize);
            description = "["+name+"] \nHeal your life by "+value+".";
        }
        if(this.name == "MP Potion") {
            value = 5;
            down0=setUp("/res/objects/item/use/potion_mana_0",gp.tileSize,gp.tileSize);
            description = "["+name+"] \nRestore your mana by "+value+".";
        }
        if(this.name == "Green Potion") {
            value = 1;
            down0=setUp("/res/objects/item/consumable/potion_green",gp.tileSize,gp.tileSize);
            description = "["+name+"] \nBuff your dexterity by "+value+".";
        }
        if(this.name == "Pink Potion") {
            value = 1;
            down0=setUp("/res/objects/item/consumable/potion_pink",gp.tileSize,gp.tileSize);
            description = "["+name+"] \nBuff your strength by "+value+".";
        }
    }

    public void setDialogue() {
        dialogues[0][0] = "You drink the "+this.name+" potion!\nYour health has been recovered by "+value+".";
        dialogues[1][0] = "You drink the "+this.name+" potion!\nYour mana has been recovered by "+value+".";
        dialogues[2][0] = "You drink the "+this.name+" potion!\nYour dexterity has been upgrade by "+value+".";
        dialogues[3][0] = "You drink the "+this.name+" potion!\nYour strenght has been upgrade by "+value+".";
    }

    public boolean use(Entity entity) {
        setDialogue();
        gp.gameState = gp.dialogueState;
        if(this.name == "HP Potion") {
            startDialogue(this, 0);
            entity.life += value;
            if(gp.player.life > gp.player.maxLife) {
                gp.player.life = gp.player.maxLife;
            }
        }
        if(this.name == "MP Potion") {
            startDialogue(this, 1);
            entity.mana += value;
            if(gp.player.mana > gp.player.maxMana) {
                gp.player.mana = gp.player.maxMana;
            }
        }
        if(this.name == "Green Potion") {
            startDialogue(this, 2);
            entity.dexterity += value;
        }
        if(this.name == "Pink Potion") {
            startDialogue(this, 3);
            entity.strength += value;
        }
        
        return true;
    }
}
