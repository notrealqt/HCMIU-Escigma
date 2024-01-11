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
        up1 = setUp("/item/weapon/FireSword/firesword",gp.tileSize,gp.tileSize);
        down1 = setUp("/item/weapon/FireSword/",gp.tileSize,gp.tileSize);
        left1 = setUp("/item/weapon/FireSword/",gp.tileSize,gp.tileSize);
        right1 = setUp("/item/weapon/FireSword/",gp.tileSize,gp.tileSize);
        
   }

    
}
