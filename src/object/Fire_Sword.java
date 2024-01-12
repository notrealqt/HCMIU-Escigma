package object;

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
        up1 = setUp("/item/weapon/flame_attack/1_flame_projectile_font_0",gp.tileSize,gp.tileSize);
        up2 = setUp("/item/weapon/flame_attack/1_flame_projectile_font_0",gp.tileSize,gp.tileSize);
        down1 = setUp("/item/weapon/flame_attack/1_flame_projectile_back_0",gp.tileSize,gp.tileSize);
        down2 = setUp("/item/weapon/flame_attack/1_flame_projectile_back_0",gp.tileSize,gp.tileSize);
        left1 = setUp("/item/weapon/flame_attack/1_flame_projectile_left_0",gp.tileSize,gp.tileSize);
        left2 = setUp("/item/weapon/flame_attack/1_flame_projectile_left_0",gp.tileSize,gp.tileSize);
        right1 = setUp("/item/weapon/flame_attack/1_flame_projectile_right_0",gp.tileSize,gp.tileSize);
        right2 = setUp("/item/weapon/flame_attack/1_flame_projectile_right_0",gp.tileSize,gp.tileSize);
        
   }

    
}