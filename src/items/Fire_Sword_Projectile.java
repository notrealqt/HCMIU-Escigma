package items;

import entities.Entity;
import entities.Projectile;
import main.GamePanel;

public class Fire_Sword_Projectile extends Projectile{

    GamePanel gp;

    public Fire_Sword_Projectile(GamePanel gp){
        super(gp);
        this.gp = gp;

        name ="Fire Sword";
        speed = 20;
        maxLife = 10;
        life = maxLife;
        attack = 10;
        manaCost = 1;
        alive = false;
        getImage();
    }

   public void getImage(){
        up0 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_font_0",gp.tileSize,gp.tileSize);
        up1 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_font_1",gp.tileSize,gp.tileSize);
        up2 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_font_2",gp.tileSize,gp.tileSize);
        up3 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_font_3",gp.tileSize,gp.tileSize);
        up4 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_font_4",gp.tileSize,gp.tileSize);

        down0 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_back_0",gp.tileSize,gp.tileSize);
        down1 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_back_1",gp.tileSize,gp.tileSize);
        down2 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_back_2",gp.tileSize,gp.tileSize);
        down3 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_back_3",gp.tileSize,gp.tileSize);
        down4 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_back_4",gp.tileSize,gp.tileSize);

        left0 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_left_0",gp.tileSize,gp.tileSize);
        left1 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_left_1",gp.tileSize,gp.tileSize);
        left2 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_left_2",gp.tileSize,gp.tileSize);
        left3 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_left_3",gp.tileSize,gp.tileSize);
        left4 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_left_4",gp.tileSize,gp.tileSize);

        right0 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_right_0",gp.tileSize,gp.tileSize);
        right1 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_right_1",gp.tileSize,gp.tileSize);
        right2 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_right_2",gp.tileSize,gp.tileSize);
        right3 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_right_3",gp.tileSize,gp.tileSize);
        right4 = setUp("/res/objects/item/weapon/fire sword/flame_attack/projectile_fade/flame_projectile_fade out_right_4",gp.tileSize,gp.tileSize);
        
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
