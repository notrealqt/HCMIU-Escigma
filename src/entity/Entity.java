package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
//sdf
    protected GamePanel gp;
    public BufferedImage up1, up2, up3, up0, up4, up5, up6, up7,up8,up9;
    public BufferedImage down0, down1, down2, down3, down4, down5, down6, down7, down8, down9;
    public BufferedImage left0, left1, left2, left3, left4, left5, left6, left7, left8, left9;
    public BufferedImage right0, right1, right2, right3, right4, right5, right6, right7, right8, right9;
    public BufferedImage idleUp, idleDown, idleLeft, idleRight;
    public BufferedImage guardUp, guardDown, guardLeft, guardRight;
    public BufferedImage upAttack1, downAttack1, leftAttack1, rightAttack1, upAttack2, downAttack2, leftAttack2, rightAttack2, upAttack3, downAttack3, leftAttack3, rightAttack3, upAttack4, downAttack4, leftAttack4, rightAttack4;
    public BufferedImage image, image2, image3, image4, image5; //heart image
    public String[][] dialogues = new String[100][100];
    //This would set solidArea for all entities, we can change it by override like in Player
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public Entity attacker;
    public boolean temp = false;
    private int attackAnimationFrame = 0;


    //State 
    public int dialogueSet = 0;
    public int worldX, worldY;
    public String direction = "down";
    public int spriteNum = 0;
    public int dialogueIndex = 0;
    public Entity loot;
    public boolean opened = false;
    public boolean rage = false;
    public boolean collision = false;
    public boolean sleep = false;
    public boolean drawing = true;

    //take damage from monster from amount of time
    //avoid taking constantly damage
    public boolean invincible =false;
    public boolean attacking=false;
    public boolean die = false;
    public boolean alive = true;
    public boolean onPath = false;
    public String knockBackDirection;
    public boolean guarding = false;
    public boolean transparent = false;
    public boolean  offBalance = false;
    public boolean hpBarOn = false;

    //Counter
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;
    public int dieCounter =0;
    public int shotAvailableCounter = 0;
    int knockBackCounter = 0;
    public int guardCounter = 0;
    int offBalanceCounter = 0;
    public int hpBarCounter = 0;



    //attributes for character 
    public int defaultSpeed;  
    public String name;
    public int speed;
    public int maxLife;
    public int life;
    public int maxMana, mana;
    public int attack,defense,coin,strength,dexterity;
    public Entity currentWeapon;
    public Entity currentShield;
    public Projectile projectile;
    public Entity currentLight;
    public int motion1_duration, motion2_duration,motion3_duration,motion4_duration;
    public boolean boss;
    
    //TYPE
    public final int type_pickupOnly = 7;
    public int type; //0 -> player, 1 -> npcs, 2 -> monster
    public final int 
    type_player = 0,
    type_npc = 1,
    type_monster = 2,
    type_sword = 3,
    type_axe = 4,
    type_consumable = 5,
    type_shield = 6,
    type_obstacle = 8,
    type_light = 9;

    //ITEM ATTRIBUTES
    public int value;
    public int attackvalue;
    public int defensevalue;
    public String description = ""; //item description
    public int manaCost;
    public boolean knockBack = false;
    public int lightRadius;
    public int knockBackPower = 0;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public int getScreenX () {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        return screenX;
    }

    public int getScreenY() {
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        return screenY;
    }
    
    public int getLeftX() {
        return worldX + solidArea.x;
    }
    
    public int getRightX() {
        return worldX + solidArea.x + solidArea.width;
    }
    
    public int getTopY() {
        return worldY + solidArea.y;
    }
    
    public int getBottomY() {
        return worldY + solidArea.y + solidArea.height;
    }
    
    public int getCol() {
        return (worldX + solidArea.x)/gp.tileSize;
    }
    
    public int getRow() {
        return (worldY + solidArea.y)/gp.tileSize;
    }
    
    public int getXDistance ( Entity target) {
        int xDistance = Math.abs(getCenterX() - target.getCenterX());
        return xDistance;
    }
    
    public int getCenterX() {
        int centerX = worldX + left1.getWidth()/2;
        return centerX;
    }
    
    public int getCenterY() {
        int centerY = worldY + up1.getHeight()/2;
        return centerY;
    }

    public int getYDistance ( Entity target) {
        int yDistance = Math.abs(getCenterY() - target.getCenterY());
        return yDistance;
    }
    
    public int getTileDistance ( Entity target) {
        int tileDistance = (getXDistance(target) + getYDistance(target)) / gp.tileSize;
        return tileDistance;
    }
    
    public int getGoalCol ( Entity target) {
        int goalCol = (target.worldX +target.solidArea.x) / gp.tileSize;
        return goalCol;
    }
    
    public int getGoalRow ( Entity target) {
        int goalRow = (target.worldY +target.solidArea.y) / gp.tileSize;
        return goalRow;    
    }
    
    public void setLoot(Entity loot) {}
    
    public void setAction() {}
    
    public void damagereaction() {}
    
    public void speak() {
    }
    
    public void facePlayer() {
        switch(gp.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;    
            case "upleft":
                direction = "right";
                break;
            case "upright":
                direction = "left";
                break;
            case "downleft":
                direction = "right";
                break;
            case "downright":
                direction = "left";
                break;
        }  
    }

    public void startDialogue(Entity entity, int setNum) {
        gp.gameState = gp.dialogueState;
        gp.ui.npc = entity;
        dialogueSet = setNum;
    }
    public void interact() {}
    
    public boolean use(Entity entity) {return false;}
    
    public void checkCollision () {
        collisionOn = false;
        gp.colDect.checkTile(this);
        gp.colDect.checkObject(this, false);
        gp.colDect.checkEntity(this, gp.npc);    //check collision between entities (npc and monster)
        gp.colDect.checkEntity(this, gp.monster);
        boolean hitplayer = gp.colDect.checkPlayer(this);

        if(this.type == type_monster && hitplayer == true){
            damagePlayer(attack);
        }
    }
    
    public void update(){

        if (sleep == false) {
            if (knockBack == true) {
                checkCollision();
                if(collisionOn == true) {
                    knockBackCounter = 0;
                    knockBack = false;
                    speed = defaultSpeed;
    
                }
                else if (collisionOn == false) {
                    switch (this.knockBackDirection) {
                        case "up":
                            worldY -= speed;
                            break;
                        case "down":
                            worldY += speed;
                            break;
                        case "left":
                            worldX -= speed;
                            break;
                        case "right":
                            worldX += speed;
                            break;
                    }
                }
                knockBackCounter++;
                if(knockBackCounter == 10) {
                    knockBackCounter = 0;
                    knockBack = false;
                    speed = defaultSpeed;
                }
                else if (attacking == true) {
                    attacking();
                }
            }
            
            else {
                setAction();
                checkCollision();
            
                if (collisionOn == false) {
                    switch (direction) {
                        case "up":
                            worldY -= speed;
                            break;
                        case "down":
                            worldY += speed;
                            break;
                        case "left":
                            worldX -= speed;
                            break;
                        case "right":
                            worldX += speed;
                            break;
                        case "upleft":
                            worldX -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            worldY -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            break;
                        case "upright":
                            worldX += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            worldY -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            break;
                        case "downleft":
                            worldX -= (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            worldY += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            break;
                        case "downright":
                            worldX += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            worldY += (int)Math.round(Math.sqrt(speed/2)*(speed/2));
                            break;
                    }
                }
                //npc image changes every 12 frames
                spriteCounter++;
                if (spriteCounter >  12) {
                    if (spriteNum == 0) {
                        spriteNum = 1;
                    }
                    else if (spriteNum == 1) {
                        spriteNum = 0;
                    }
                    spriteCounter = 0;
            }
            }
            
    
            
            if(invincible == true){
                invincibleCounter++;
                if(invincibleCounter > 60){
                    invincible = false;
                    invincibleCounter = 0;
                    }
            }
            if(shotAvailableCounter == 0){
                shotAvailableCounter ++;
            }
            if(offBalance == true)  {
                offBalanceCounter++;
                if(offBalanceCounter > 60) {
                    offBalance = false;
                    offBalanceCounter = 0;
                }
            }
        }
        
    } 

    public String getOppDirection ( String direction) {
        String oppDirection = "";

        switch (direction) {
            case "up": oppDirection = "down"; break;
            case "down": oppDirection = "up"; break;
            case "left": oppDirection = "right"; break;
            case "right": oppDirection = "left"; break;
        }
        return oppDirection;

    }
    
    public void damagePlayer(int attack){
        if(gp.player.invincible == false){
            int damage = attack - gp.player.defense;
            String canGuard = getOppDirection(direction);
            if (gp.player.guarding == true && gp.player.direction.equals(canGuard)) {
                //Parry
                if(gp.player.guardCounter < 10) {
                    damage = 0;
                    knockBack(this, gp.player, knockBackPower);
                    offBalance = true;
                    spriteCounter =- 60;
                }
                //Normal guard
                damage /= 3;
            }
            else {                 
                if(damage < 1) { damage = 1;}
            }

            if (damage != 0) {
                gp.player.transparent = true;
                knockBack(gp.player, this, knockBackPower);
            }
            gp.player.life -= damage;
            gp.player.invincible = true;
        }
        
    }
 
    public boolean inCamera() {
        boolean inCamera = false;
        if( worldX + gp.tileSize*5 > gp.player.worldX - gp.player.screenX && 
        worldX - gp.tileSize < gp.player.worldX + gp.player.screenX && 
        worldY + gp.tileSize *5 > gp.player.worldY - gp.player.screenY && 
        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
            inCamera = true;
        }
        return inCamera;
    }
    
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        if(inCamera() == true) {
                
            int tempScreenX = getScreenX();
            int tempScreenY = getScreenY();
                    switch (direction) {
                        case "up":
                        if(attacking == false){
                            if (spriteNum == 0) {image = up0;} 
                            if (spriteNum == 1) {image = up1;}
                            if (spriteNum == 2) {image = up2;}
                            if (spriteNum == 3) {image = up3;}
                            if (spriteNum == 4) {image = up4;}
                            if (spriteNum == 5) {image = up5;}
                            if (spriteNum == 6) {image = up6;}
                            if (spriteNum == 7) {image = up7;}
                            if (spriteNum == 8) {image = up8;}
                            if (spriteNum == 9) {image = up9;}
                        }
                        if(attacking == true){
                            tempScreenY = getScreenY() - up1.getHeight(); 
                            if(spriteNum==1){image = upAttack1;}
                            if(spriteNum==2){image = upAttack2;}
                            if(spriteNum==3){image = upAttack3;}
                            if(spriteNum==4){image = upAttack4;}
                        }
                            break;
        
                        case "down":
                        if(attacking == false){
                            if (spriteNum == 0) {image = down0;}
                            if (spriteNum == 1) {image = down1;}
                            if (spriteNum == 2) {image = down2;}
                            if (spriteNum == 3) {image = down3;}
                            if (spriteNum == 4) {image = down4;}
                            if (spriteNum == 5) {image = down5;}
                            if (spriteNum == 6) {image = down6;}
                            if (spriteNum == 7) {image = down7;}
                            if (spriteNum == 8) {image = down8;}
                            if (spriteNum == 9) {image = down9;}
                        }
                        if(attacking == true){

                            if(spriteNum==1){image = downAttack1;}
                            if(spriteNum==2){image = downAttack2;}
                            if(spriteNum==3){image = downAttack3;}
                            if(spriteNum==4){image = downAttack4;}
                        }
                            break;
        
                        case "left":
                        if(attacking == false){
                            if (spriteNum == 0) {image = left0;}
                            if (spriteNum == 1) {image = left1;}
                            if (spriteNum == 2) {image = left2;}
                            if (spriteNum == 3) {image = left3;}
                            if (spriteNum == 4) {image = left4;}
                            if (spriteNum == 5) {image = left5;}
                            if (spriteNum == 6) {image = left6;}
                            if (spriteNum == 7) {image = left7;}
                            if (spriteNum == 8) {image = left8;}
                            if (spriteNum == 9) {image = left9;}
                        }
                        if(attacking == true){
                            tempScreenX = getScreenX() - left1.getWidth(); 
                            if(spriteNum==1){image = leftAttack1;}
                            if(spriteNum==2){image = leftAttack2;}
                            if(spriteNum==3){image = leftAttack3;}
                            if(spriteNum==4){image = leftAttack4;}
                        }
                            break;
        
                        case "right":
                        if(attacking == false){
                            if (spriteNum == 0) {image = right0;}
                            if (spriteNum == 1) {image = right1;}
                            if (spriteNum == 2) {image = right2;}
                            if (spriteNum == 3) {image = right3;}
                            if (spriteNum == 4) {image = right4;}
                            if (spriteNum == 5) {image = right5;}
                            if (spriteNum == 6) {image = right6;}
                            if (spriteNum == 7) {image = right7;}
                            if (spriteNum == 8) {image = right8;}
                            if (spriteNum == 9) {image = right9;}
                        }
                        if(attacking == true){
                            if(spriteNum==1){image = rightAttack1;}
                            if(spriteNum==2){image = rightAttack2;}
                            if(spriteNum==3){image = rightAttack3;}
                            if(spriteNum==4){image = rightAttack4;}
                        }
                            break;

                    }

    

                //get invincible for entities
                if(invincible == true){
                    hpBarOn = true;
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
                }
                if (die == true){
                    dieAnimation(g2);
                }
                
            g2.drawImage(image, tempScreenX, tempScreenY, null);

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
    
    public void dieAnimation(Graphics2D g2){
        dieCounter++;

        if(dieCounter <= 5){changeAlpha(g2,0f);}
        if(dieCounter>5&&dieCounter<=10) {changeAlpha(g2,1f);}
        if(dieCounter>10&&dieCounter<=15) {changeAlpha(g2,0f);}
        if(dieCounter>15&&dieCounter<=20) {changeAlpha(g2,1f);}
        if(dieCounter>20&&dieCounter<=25) {changeAlpha(g2,0f);}
        if(dieCounter>25&&dieCounter<=30) {changeAlpha(g2,1f);}
        if(dieCounter>30&&dieCounter<=35) {changeAlpha(g2,0f);}
        if(dieCounter>40){
            alive = false;
        }
    }
    
    public void changeAlpha(Graphics2D g2, float alphaValue) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
    };
    
    public void searchPath (int goalCol, int goalRow){
        int startCol = (worldX + solidArea.x)/gp.tileSize;
        int startRow = (worldY + solidArea.y)/gp.tileSize;

        gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);
        
        if (gp.pFinder.search() == true) {
            int nextX = (gp.pFinder.pathList.get(0).col * gp.tileSize); 
            int nextY = (gp.pFinder.pathList.get(0).row * gp.tileSize);

            int enLeftX = worldX + solidArea.x;
            int enRightX = worldX + solidArea.x + solidArea.width;
            int enTopY = worldY + solidArea.y;
            int enBottomY = worldY + solidArea.y + solidArea.height;
            
            if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "up";
            }
            else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "down";
            }
            else if (enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
                if (enLeftX > nextX) {
                    direction = "left";
                }
                if (enLeftX < nextX) {
                    direction = "right";
                }
            }

            else if (enTopY > nextY && enLeftX > nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn == true) {
                    direction = "left";
                }
            } 
            else if (enTopY > nextY && enLeftX < nextX) {
                direction = "up";
                checkCollision();
                if (collisionOn == true) {
                    direction = "right";
                }
            } 
            else if (enTopY < nextY && enLeftX > nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn == true) {
                    direction = "left";
                }
            }
            else if (enTopY < nextY && enLeftX < nextX) {
                direction = "down";
                checkCollision();
                if (collisionOn == true) {
                    direction = "right";
                }
            }

        //int nextCol = gp.pFinder.pathList.get(0).col;
        //int nextRow = gp.pFinder.pathList.get(0).row;
        //if (nextCol == goalCol && nextRow == goalRow) {
        //   onPath = false;
        //}
        }
    }
    
    public int getDetected(Entity user, Entity target[][], String targetName){

        int index = 9999;
        
        //Check the surrounding object
        int nextWorldX = user.getLeftX();
        int nextWorldY = user.getTopY();

        switch(user.direction) {
            case "up": nextWorldY = user.getTopY() - gp.player.speed; break;
            case "down": nextWorldY = user.getBottomY() + gp.player.speed; break;
            case "left": nextWorldX = user.getLeftX() - gp.player.speed; break;
            case "right": nextWorldX = user.getRightX() + gp.player.speed; break;
        }

        int col = nextWorldX/gp.tileSize;
        int row = nextWorldY/gp.tileSize;

        for(int i = 0; i< target[1].length; i++){
            if(target[gp.currentMap][i] != null) {
                if(target[gp.currentMap][i].getCol() == col && target[gp.currentMap][i].getRow() == row && target[gp.currentMap][i].name.equals(targetName)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    
    public BufferedImage setUp(String imagePath, int width, int height) {
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/"+imagePath+".png"));
            image = uTool.scaleImage(image, width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    } 
    
    public void checkStop ( Entity target, int distance, int rate) {
        if (getTileDistance(target) > distance) {
            int i = new Random().nextInt();
            if (i==0) {
                onPath = false;
            }
        }
    }
    
    public void checkChasing ( Entity target, int distance, int rate) {
        if (getTileDistance(target) < distance) {
            int i = new Random().nextInt();
            if (i==0) {
                onPath = true;
            }
        }
    }
    
    public void getRandomDirection(int interval) {
        actionLockCounter++;
            
            if(actionLockCounter  > interval){
                Random random = new Random();
                int i = random.nextInt(100)+1; //Random from 1 to 100

                if(i<=25){
                    direction = "up";
                }
                if(i>25 && i<= 50){
                    direction = "down";
                }
                if(i>50 && i<=75){
                    direction = "left";
                }
                if(i>75 && i<=100){
                    direction = "right";
                }

                actionLockCounter = 0;
            } 
    }

    public void knockBack (Entity target, Entity attacker, int knockBackPower) {
        this.attacker = attacker;
        target.knockBackDirection = attacker.direction;
        target.speed += knockBackPower;
        target.knockBack = true;
    }

    public void attacking () {
        spriteCounter++;

        if(spriteCounter <= motion1_duration){
            spriteNum = 1;
        }
        if(spriteCounter > motion1_duration && spriteCounter <= motion2_duration){
            spriteNum = 2;
        }
        if(spriteCounter > motion2_duration && spriteCounter <= motion3_duration){
            spriteNum = 3;
        }
        if(spriteCounter > motion3_duration && spriteCounter <= motion4_duration){
            spriteNum = 4;
      //save the current worldx, worldy, solid area
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //modify player's worldx,y for the attackarea
            switch(direction){
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;
            }
            //attack attack area (sword) becomes solid area
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            if(type == type_monster){
                if (gp.colDect.checkPlayer(this) == true){
                    damagePlayer(attack);
                }
            }
            else{ //Player
        //check monster collision with the updated worldX,Y and solidArea
        int monsterIndex = gp.colDect.checkEntity(this, gp.monster);
        gp.player.damageMonster (monsterIndex,this, attack, currentWeapon.knockBackPower);
    
        //after checking collision, restore the original data
        worldX = currentWorldX;
        worldY = currentWorldY;
        solidArea.width = solidAreaWidth;
        solidArea.height = solidAreaHeight;}
            }
           
            
          if(spriteCounter > motion4_duration){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
            
       
    }
    
    public void checkAttack(int rate, int straight, int horizontal) {
        boolean targetInRange = false;
        int xDis = getXDistance(gp.player);
        int yDis = getYDistance(gp.player);
    
        switch (direction) {
            case "up":
                if (gp.player.getCenterY() < getCenterY() && xDis < horizontal && yDis < straight) {
                    targetInRange = true;
                }
                break;
            case "down":
                if (gp.player.getCenterY() > getCenterY() && xDis < horizontal && yDis < straight) {
                    targetInRange = true;
                }
                break;
            case "left":
                if (gp.player.getCenterX() < getCenterX() && xDis < straight && yDis < horizontal) {
                    targetInRange = true;
                }
                break;
            case "right":
                if (gp.player.getCenterX() > getCenterX() && xDis < straight && yDis < horizontal) {
                    targetInRange = true;
                }
                break;
        }
    
        if (targetInRange == true) {
            //check attack
            int i = new Random().nextInt(rate);
            if (i == 0) {
                attacking = true;
                spriteNum = 1;
                spriteCounter = 0;
                shotAvailableCounter = 0;
            }
        }
    }
    
    
    public void chasePlayer (int interval) {
        actionLockCounter++;
        if(actionLockCounter > interval) {
            if(getXDistance(gp.player) > getYDistance(gp.player)) {
                if (gp.player.getCenterX() < getCenterX()) {
                    direction = "left";
                }
                else {
                    direction = "right";
                }
            }
            else if (getXDistance(gp.player) < getYDistance(gp.player)) {
                if(gp.player.getCenterY() < getCenterY()) {
                    direction = "up";
                }
                else {
                    direction = "down";
                }
            }
            actionLockCounter = 0;
        }
    }
}

