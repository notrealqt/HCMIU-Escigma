package entity;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandle;
import main.UtilityTool;
import object.Fire_Sword;
import object.Key;
import object.Shield;
import object.Sword;

public class Player extends Entity {

    KeyHandle keyH;
    public final int screenX;
    public final int screenY; //where player on the screen
    public int hasKey = 0;
    int standCounter = 0;
    public boolean attackCanceled = false;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
    public boolean lightUpdated = false;
    public Object currentLight;


    public Player(GamePanel gp, KeyHandle keyH) {

        super(gp);
        type = 0;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2); //player's pos at center

        solidArea = new Rectangle(); //setting the solid area of character based on 16x3 pixels
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        // attackArea.width=36;
        // attackArea.height=36;

        setDefaultValue();

    }

    public void setDefaultValue() {
        worldX = gp.tileSize * 14; //player's pos in world map
        worldY = gp.tileSize * 14;
        defaultSpeed = 4;
        speed = 10;
        direction = "down";

        //Player status
        maxLife = 10;
        life = maxLife;
        strength = 1;   // more strength, more dmg
        dexterity = 1; //more dexterity, less dmg receive
        coin = 0;
        maxMana = 4;
        mana = maxMana;
        currentWeapon = new Sword(gp);
        currentShield = new Shield(gp);
        projectile = new Fire_Sword(gp);
        attack = getAttack();
        defense = getDefense();
        currentLight = null;
        getPlayerImage();
        getPlayerattackImgage();
        //getGuardImage();
        setItems();
    }
    
    public void setDefaultPosition(){
        worldX = gp.tileSize * 14; 
        worldY = gp.tileSize * 14;
        direction = "down";
    }
    
    public void setDefaultLife(){
        life = maxLife;
        mana = maxMana;
        invincible = false;
        transparent = false;
        attacking = false;
        guarding = false;
        knockBack = false;
        lightUpdated = false;
    }
    
    public int getCurrentWeap () {
        int currentWeaponSlot = 0;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) == currentWeapon) {
                currentWeaponSlot = i;
            }
        }
        return currentWeaponSlot;
    }
    
    public void setItems(){
        inventory.add(currentWeapon);
    }
    
    public int getAttack(){
        attackArea=currentWeapon.attackArea;
        motion1_duration = currentWeapon.motion1_duration;
        motion2_duration = currentWeapon.motion2_duration;
        return attackvalue =  strength * currentWeapon.attackvalue;
    }
    
    public int getDefense(){
        return defensevalue = dexterity * currentWeapon.defensevalue;
    }
    
    public void getPlayerattackImgage(){
        if(currentWeapon.type == type_sword){
        upAttack1 = setUp("player/attack/1_player_attack_back_0",gp.tileSize, gp.tileSize*2);
        upAttack2 = setUp("player/attack/1_player_attack_back_1",gp.tileSize, gp.tileSize*2);
        upAttack3 = setUp("player/attack/1_player_attack_back_2",gp.tileSize, gp.tileSize*2);
        upAttack4 = setUp("player/attack/1_player_attack_back_3",gp.tileSize, gp.tileSize*2);

        downAttack1 = setUp("player/attack/1_player_attack_font_0",gp.tileSize, gp.tileSize*2);
        downAttack2 = setUp("player/attack/1_player_attack_font_1",gp.tileSize, gp.tileSize*2);
        downAttack3 = setUp("player/attack/1_player_attack_font_2",gp.tileSize, gp.tileSize*2);
        downAttack4 = setUp("player/attack/1_player_attack_font_3",gp.tileSize, gp.tileSize*2);

        leftAttack1 = setUp("player/attack/1_player_attack_left_0",gp.tileSize*2, gp.tileSize);
        leftAttack2 = setUp("player/attack/1_player_attack_left_1",gp.tileSize*2, gp.tileSize);
        leftAttack3 = setUp("player/attack/1_player_attack_left_2",gp.tileSize*2, gp.tileSize);
        leftAttack4 = setUp("player/attack/1_player_attack_left_3",gp.tileSize*2, gp.tileSize);

        rightAttack1 = setUp("player/attack/1_player_attack_right_0",gp.tileSize*2, gp.tileSize);
        rightAttack2 = setUp("player/attack/1_player_attack_right_1",gp.tileSize*2, gp.tileSize);
        rightAttack3 = setUp("player/attack/1_player_attack_right_2",gp.tileSize*2, gp.tileSize);
        rightAttack4 = setUp("player/attack/1_player_attack_right_3",gp.tileSize*2, gp.tileSize);
        }
    }

    /*
    public void getGuardImage() {
        guardUp = setUp("player/attack/1_player_attack_back_0", gp.tileSize, gp.tileSize);
        guardDown = setUp("player/attack/1_player_attack_back_0", gp.tileSize, gp.tileSize);
        guardLeft = setUp("player/attack/1_player_attack_back_0", gp.tileSize, gp.tileSize);
        guardRight = setUp("player/attack/1_player_attack_back_0", gp.tileSize, gp.tileSize);

    }
    */

    public void getPlayerImage() {

        idleUp = setUp("/player/move/1_player_idle_back_0",gp.tileSize, gp.tileSize);
        idleDown = setUp("/player/move/1_player_idle_font_0",gp.tileSize, gp.tileSize);
        idleRight = setUp("/player/move/1_player_idle_right_0",gp.tileSize, gp.tileSize);
        idleLeft = setUp("/player/move/1_player_idle_left_0",gp.tileSize, gp.tileSize);

        up0 = setUp("/player/move/1_player_move_back_0",gp.tileSize, gp.tileSize);
        up1 = setUp("/player/move/1_player_move_back_1",gp.tileSize, gp.tileSize);
        up2 = setUp("/player/move/1_player_move_back_2",gp.tileSize, gp.tileSize);
        up3 = setUp("/player/move/1_player_move_back_3",gp.tileSize, gp.tileSize);
        up4 = setUp("/player/move/1_player_move_back_4",gp.tileSize, gp.tileSize);
        up5 = setUp("/player/move/1_player_move_back_5",gp.tileSize, gp.tileSize);
        up6 = setUp("/player/move/1_player_move_back_6",gp.tileSize, gp.tileSize);
        up7 = setUp("/player/move/1_player_move_back_7",gp.tileSize, gp.tileSize);

        down0 = setUp("/player/move/1_player_move_font_0",gp.tileSize, gp.tileSize);
        down1 = setUp("/player/move/1_player_move_font_1",gp.tileSize, gp.tileSize);
        down2 = setUp("/player/move/1_player_move_font_2",gp.tileSize, gp.tileSize);
        down3 = setUp("/player/move/1_player_move_font_3",gp.tileSize, gp.tileSize);
        down4 = setUp("/player/move/1_player_move_font_4",gp.tileSize, gp.tileSize);
        down5 = setUp("/player/move/1_player_move_font_5",gp.tileSize, gp.tileSize);
        down6 = setUp("/player/move/1_player_move_font_6",gp.tileSize, gp.tileSize);
        down7 = setUp("/player/move/1_player_move_font_7",gp.tileSize, gp.tileSize);

        
        left0 = setUp("/player/move/1_player_move_left_0",gp.tileSize, gp.tileSize);
        left1 = setUp("/player/move/1_player_move_left_1",gp.tileSize, gp.tileSize);
        left2 = setUp("/player/move/1_player_move_left_2",gp.tileSize, gp.tileSize);
        left3 = setUp("/player/move/1_player_move_left_3",gp.tileSize, gp.tileSize);
        left4 = setUp("/player/move/1_player_move_left_4",gp.tileSize, gp.tileSize);
        left5 = setUp("/player/move/1_player_move_left_5",gp.tileSize, gp.tileSize);
        left6 = setUp("/player/move/1_player_move_left_6",gp.tileSize, gp.tileSize);
        left7 = setUp("/player/move/1_player_move_left_7",gp.tileSize, gp.tileSize);;


        right0 = setUp("/player/move/1_player_move_right_0",gp.tileSize, gp.tileSize);
        right1 = setUp("/player/move/1_player_move_right_1",gp.tileSize, gp.tileSize);
        right2 = setUp("/player/move/1_player_move_right_2",gp.tileSize, gp.tileSize);
        right3 = setUp("/player/move/1_player_move_right_3",gp.tileSize, gp.tileSize);
        right4 = setUp("/player/move/1_player_move_right_4",gp.tileSize, gp.tileSize);
        right5 = setUp("/player/move/1_player_move_right_5",gp.tileSize, gp.tileSize);
        right6 = setUp("/player/move/1_player_move_right_6",gp.tileSize, gp.tileSize);
        right7 = setUp("/player/move/1_player_move_right_7",gp.tileSize, gp.tileSize);
        
    }

    public void update() {

        if (knockBack == true) {
            
            collisionOn = false;
            gp.colDect.checkTile(this);
            gp.colDect.checkObject(this, true);
            gp.colDect.checkEntity(this, gp.npc);
            gp.colDect.checkEntity(this, gp.monster);


            if(collisionOn == true) {
                knockBackCounter = 0;
                knockBack = false;
                speed = defaultSpeed;

            }
            else if (collisionOn == false) {
                switch (gp.player.direction) {
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
        }    
        //attack animation
        else if (attacking == true){
            attacking();
        }
        else if (keyH.guardPressed == true) {
            guarding = true;
            guardCounter++;
        }
        else {
            
            if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || (keyH.leftPressed && keyH.upPressed) == true || (keyH.rightPressed && keyH.upPressed) == true || (keyH.leftPressed && keyH.downPressed) == true || (keyH.rightPressed && keyH.downPressed == true|| keyH.attackPressed == true || keyH.interPressed == true)) {
                if (keyH.upPressed == true) { direction = "up"; } 
                if (keyH.downPressed == true) { direction = "down"; }
                if (keyH.leftPressed == true) { direction = "left"; }
                if ( keyH.rightPressed == true) { direction = "right"; }
                if ((keyH.upPressed && keyH.leftPressed) == true) { direction = "upleft"; }
                if ((keyH.upPressed && keyH.rightPressed) == true) { direction = "upright"; }
                if ((keyH.downPressed && keyH.leftPressed) == true) { direction = "downleft"; }
                if ((keyH.downPressed && keyH.rightPressed) == true) { direction = "downright"; }
                //Check tile collision
                collisionOn = false;
                gp.colDect.checkTile(this);

                //Check item collision
                int itemIndex = gp.colDect.checkObject(this, true);
                pickUpItem(itemIndex);

                //Check NPC collision
                int npcIndex = gp.colDect.checkEntity(this, gp.npc);
                interactNPC(npcIndex);
                //Check event
                gp.eHandler .checkEvent();
            
                //Check monster collision
                int monsterIndex = gp.colDect.checkEntity(this, gp.monster);
                encounterMonster(monsterIndex);
                
                //if collision is false, player can move 
                if (collisionOn == false && keyH.interPressed==false && keyH.attackPressed == false) {     //interact without moving
                    switch (direction) {
                        case "up": worldY -= speed;
                            break;
                        case "down": worldY += speed;
                            break;
                        case "left": worldX -= speed;
                            break;
                        case "right": worldX += speed;
                            break;
                        case "upleft": worldX -= (int)Math.round(2*Math.sqrt(speed)); 
                                    worldY -= (int)Math.round(2*Math.sqrt(speed));
                            break;
                        case "upright": worldX += (int)Math.round(2*Math.sqrt(speed));
                                        worldY -= (int)Math.round(2*Math.sqrt(speed));
                            break;
                        case "downleft": worldX -= (int)Math.round(2*Math.sqrt(speed));
                                        worldY += (int)Math.round(2*Math.sqrt(speed));
                            break;
                        case "downright": worldX += (int)Math.round(2*Math.sqrt(speed));
                                        worldY += (int)Math.round(2*Math.sqrt(speed));
                            break;
                    }
                }
                
                if(keyH.attackPressed==true&&attackCanceled==false){
                    attacking = true;
                    spriteCounter=0;
                }
                attackCanceled =false;
                gp.KeyH.attackPressed = false;
                gp.KeyH.interPressed = false;
                guarding = false;
                guardCounter = 0;
                //player image changes every 6 frames
                spriteCounter++;
                if (spriteCounter > 7) {
                    if (spriteNum == 0) { spriteNum = 1; }
                    else if (spriteNum == 1) { spriteNum = 2; }
                    else if (spriteNum == 2) { spriteNum = 3; }
                    else if (spriteNum == 3) { spriteNum = 4; }
                    else if (spriteNum == 4) { spriteNum = 5; }
                    else if (spriteNum == 5) { spriteNum = 6; }
                    else if (spriteNum == 6) { spriteNum = 7; }
                    else if (spriteNum == 7) { spriteNum = 0; }
                    spriteCounter = 0;
                }

                if(gp.KeyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30 && projectile.haveResource(this) == true) {

                    //Set default coordinates, direction and user
                    projectile.set(worldX, worldY, direction, true,this);

                    //use the mana
                    projectile.subtractResource(this);

                    //add projectile to the list
                    gp.projectileList.add(projectile);

                    shotAvailableCounter = 0 ;
                }       
                if(shotAvailableCounter<30){ shotAvailableCounter++; }            
            }

        }
        //invincible time must outside of the key if statement
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60) {
                invincible = false;
                transparent = false;
                invincibleCounter = 0;
            }
            if (life <= 0) {
                gp.playSE(4);
                gp.gameState= gp.youLostState;
                gp.ui.commandNum = -1;
                //death music
                //gp.playMusic(index);
            }
        }
    }
       
    public void attacking () {
        spriteCounter++;

        if(spriteCounter <= 5){
            spriteNum = 1;
        }
        if(spriteCounter >5 && spriteCounter <= 10){
            spriteNum = 2;
        }
        if(spriteCounter > 10 && spriteCounter <= 15){
            spriteNum = 3;
        }
        if(spriteCounter > 15 && spriteCounter <= 25){
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

            //check monster collision with the updated worldX,Y and solidArea
            int monsterIndex = gp.colDect.checkEntity(this, gp.monster);
            damageMonster (monsterIndex,this, attack, currentWeapon.knockBackPower);
        
            //after checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;}
            
          if(spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
            
       
    }
    
    public void pickUpItem(int i){
        if(i!=9999){
            //Obstacle
            if(gp.obj[gp.currentMap][i].type == type_obstacle) {
                if(keyH.enterPressed == true) {
                    attackCanceled = true;
                    System.out.println("Pressed door");
                    gp.obj[gp.currentMap][i].interact();
                }
            }
            else {
                String objectName = gp.obj[gp.currentMap][i].name;
                switch(objectName){
                    case "Key":
                        gp.playSE(1);
                        hasKey++;
                        gp.obj[gp.currentMap][i] = null;
                        gp.ui.showMessage("You got a key!");
                        break;
                    case "Door":
                        if(hasKey>0){
                            gp.obj[gp.currentMap][i] = null;
                            hasKey--;
                        }
                        else {
                            gp.ui.showMessage("You need a key to open!");
                        }
                        break;
                    case "Boots":
                        gp.playSE(1);
                        speed += 2;
                        gp.obj[gp.currentMap][i] = null;
                        break;
                    case "Chest":
                        gp.ui.gameFinished = true;
                        gp.stopMusic();
                        gp.playSE(2);
                        break;
                }
            }
            
        }
    }
    
    public void interactNPC(int i) {
        if (gp.KeyH.attackPressed==false && gp.KeyH.interPressed==true){
            if(i!=9999)
            {
                attackCanceled=true;
                gp.npc[gp.currentMap][i].speak();   
            }
            
        }else if(gp.KeyH.attackPressed==true && gp.KeyH.interPressed==false){attacking = true;}

    }
    
    public void encounterMonster(int i) {
        if (i!=9999){
            if(invincible == false && gp.monster[gp.currentMap][i].die==false){
                int damage = gp.monster[gp.currentMap][i].attack - defense;
                if(damage < 1){
                    damage = 1;
                }
                life -=damage;  
                invincible = true;
                transparent = true;              
            }

        }
    }

    public void damageMonster(int index, Entity attacker, int attack, int knockBackPower) {
        if (index >= 0 && index < gp.monster[gp.currentMap].length) {
            
            if (index != 9999) {
                // System.out.println("Hit!"); // give damage to monster
                if (!gp.monster[gp.currentMap][index].invincible) {
                    
                    if(knockBackPower > 0) {
                        knockBack(gp.monster[gp.currentMap][index], attacker, knockBackPower);

                    }
    
                    int damage = attack - gp.monster[gp.currentMap][index].defense;
                    if (damage < 0) {
                        damage = 0;
                    }
                    gp.monster[gp.currentMap][index].life -= damage;
                    gp.monster[gp.currentMap][index].invincible = true;
                    gp.monster[gp.currentMap][index].damagereaction();
    
                    if (gp.monster[gp.currentMap][index].life <= 0) {
                        gp.monster[gp.currentMap][index].die = true; // kill monster
                    }

                    if(gp.monster[gp.currentMap][index].offBalance == true) {
                        attack *= 3;
                    } 
                }
            }
        } else {
           // System.out.println("Invalid index: " + index); // Print a message for debugging
        }
    }
    
    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexOnSlot();

        if(itemIndex < inventory.size()){
            Entity selectedItem = inventory.get(itemIndex);

            if(selectedItem.type == type_sword||selectedItem.type == type_axe){
                currentWeapon = (Sword) selectedItem;
                attack = getAttack();
            }
            if(selectedItem.type == type_consumable){
                if(selectedItem.use(this) == true) {
                    inventory.remove(itemIndex);
                }

            }
        }
    }
    
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white); // set color to use for drawing objects
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
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
                    tempScreenY = screenY - gp.tileSize; 
                    if(spriteNum==1){image = upAttack1;}
                    if(spriteNum==2){image = upAttack2;}
                    if(spriteNum==3){image = upAttack3;}
                    if(spriteNum==4){image = upAttack4;}
                }
                if(guarding == true) {
                    image = guardUp;
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
                if(guarding == true) {
                    image = guardDown;
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
                    tempScreenX = screenX - gp.tileSize; 
                    if(spriteNum==1){image = leftAttack1;}
                    if(spriteNum==2){image = leftAttack2;}
                    if(spriteNum==3){image = leftAttack3;}
                    if(spriteNum==4){image = leftAttack4;}
                }
                if(guarding == true) {
                    image = guardLeft;
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
                if(guarding == true) {
                    image = guardRight;
                }
                    break;

                case "upleft":
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
                    tempScreenY = screenY - gp.tileSize;  
                    if(spriteNum==1){image = upAttack1;}
                    if(spriteNum==2){image = upAttack2;}
                    if(spriteNum==3){image = upAttack3;}
                    if(spriteNum==4){image = upAttack4;}
                }
                if(guarding == true) {
                    image = guardUp;
                }
                    break;

                case "upright":
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
                    tempScreenY = screenY - gp.tileSize; 
                    if(spriteNum==1){image = upAttack1;}
                    if(spriteNum==2){image = upAttack2;}
                    if(spriteNum==3){image = upAttack3;}
                    if(spriteNum==4){image = upAttack4;}
                }
                if(guarding == true) {
                    image = guardUp;
                }
                    break;
                case "downleft":
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
                if(guarding == true) {
                    image = guardDown;
                }
                    break;
                case "downright":
                if(attacking == false) {
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
                if(guarding == true) {
                    image = guardDown;
                }
                    break;
            }
        if(transparent == true) {g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));}
        g2.drawImage(image, tempScreenX, tempScreenY,null);
        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        // //DEBUG monster hit player
        // g2.setFont(new Font("Arial", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invincible:"+invincibleCounter,10,400);
    }

    public void knockBack (Entity entity) {
        if(entity == gp.player) {
            entity.direction = getOppDirection(direction); 
        }
        else {
            entity.direction = direction;
        }
        

        entity.speed += 10;
        entity.knockBack = true;
    }

}
