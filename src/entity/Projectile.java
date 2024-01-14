package entity;

import main.GamePanel ;

public class Projectile extends Entity {
    Entity user;

    public Projectile(GamePanel gp){
        super(gp);
    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;
    }

    public void update(){

        if(user == gp.player){
            int monsterIndex = gp.colDect.checkEntity(this, gp.monster);
            if(monsterIndex != 9999){
                gp.player.damageMonster(monsterIndex,this,attack,knockBackPower);
                alive = false;
            }
        }

        //monster shoot (concept)
        // if(user != gp.player){
        //     boolean hitplayer = gp.colDect.checkPlayer(this);
        //     if(gp.player.invincible==false){
        //         damagePlayer(attack);
        //         alive = false;
        //     }
        // }

        switch(direction){
            case "up": worldY -= speed; break;
            case "down": worldY += speed; break;
            case "left": worldX -= speed; break;
            case "right": worldX += speed; break;
        }

        life --;
        if(life <= 0){
            alive = false;
        }
        
        spriteCounter++;
        if(spriteCounter>12){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if (spriteNum ==2){
                spriteNum =1;
            }
            spriteCounter = 0;
   
    }
}
            public boolean haveResource(Entity user){
                boolean haveResource = false;
                    haveResource = true;
                return haveResource;
                }

            public void subtractResource(Entity user){
                user.mana -= manaCost;
            
                }
}
