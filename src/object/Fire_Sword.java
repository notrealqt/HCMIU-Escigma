package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class Fire_Sword extends Projectile{

    GamePanel gp;

    public Fire_Sword(GamePanel gp){
        super(gp);
        this.gp = gp;

        name ="Fire Sword";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 10;
        manaCost = 1;
        alive = false;
        getImage();
    }

   public void getImage(){
        String path = "/res/objects/item/weapon/fire sword/flame_attack/";
        
   }
   
   public boolean haveResource(Entity user){
    boolean haveResource = false;
    if(user.mana >= manaCost){
        haveResource = true;
    
        }
    return haveResource;
    }

    public void subtractResource(Entity user){
        user.mana -= manaCost;

    }
}
