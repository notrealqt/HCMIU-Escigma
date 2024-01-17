package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class Fire_Sword_Projectile extends Projectile{

    GamePanel gp;

    public Fire_Sword_Projectile(GamePanel gp){
        super(gp);
        this.gp = gp;

        name ="Fire Sword";
        speed = 100;
        maxLife = 10;
        life = maxLife;
        attack = 10;
        manaCost = 1;
        alive = false;
        getImage();
    }

   public void getImage(){
        up0 = setUp("/item/weapon/flame_attack/1_flame_projectile_font_0",gp.tileSize,gp.tileSize);
        up1 = setUp("/item/weapon/flame_attack/1_flame_projectile_font_0",gp.tileSize,gp.tileSize);
        down0 = setUp("/item/weapon/flame_attack/1_flame_projectile_back_0",gp.tileSize,gp.tileSize);
        down1 = setUp("/item/weapon/flame_attack/1_flame_projectile_back_0",gp.tileSize,gp.tileSize);
        left0 = setUp("/item/weapon/flame_attack/1_flame_projectile_left_0",gp.tileSize,gp.tileSize);
        left1 = setUp("/item/weapon/flame_attack/1_flame_projectile_left_0",gp.tileSize,gp.tileSize);
        right0 = setUp("/item/weapon/flame_attack/1_flame_projectile_right_0",gp.tileSize,gp.tileSize);
        right1 = setUp("/item/weapon/flame_attack/1_flame_projectile_right_0",gp.tileSize,gp.tileSize);
        
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
