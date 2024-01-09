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
import object.Key;
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
        getPlayerImage();
        getPlayerattackImgage();
        setItems();

    }

    public void setDefaultValue() {
        worldX = gp.tileSize * 14; //player's pos in world map
        worldY = gp.tileSize * 14;
        speed = 4;
        direction = "down";

        //Player status
        maxLife = 10;
        life = maxLife;
        strength = 1;   // more strength, more dmg
        dexterity = 1; //more dexterity, less dmg receive
        coin = 0;
        currentWeapon = new Sword(gp);
        attack = getAttack();
        defense = getDefense();
    }
    public void setDefaultPosition(){
        worldX = gp.tileSize * 14; 
        worldY = gp.tileSize * 14;
        direction = "down";
    }
    public void setDefaultLife(){
        life = maxLife;
        invincible = false;
    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(new Key(gp));
        inventory.add(new Key(gp));
    }
    public int getAttack(){
        attackArea=currentWeapon.attackArea;
        return attackvalue =  strength * currentWeapon.attackvalue;
    }
    public int getDefense(){
        return defensevalue = dexterity * currentWeapon.defensevalue;
    }
    
    public void getPlayerattackImgage(){
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
        //attack animation
        if (attacking == true){
            attacking();
        }else
        //System.out.println("Update method called");
            if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || (keyH.leftPressed && keyH.upPressed) == true || (keyH.rightPressed && keyH.upPressed) == true || (keyH.leftPressed && keyH.downPressed) == true || (keyH.rightPressed && keyH.downPressed == true|| keyH.attackPressed == true || keyH.interPressed == true)) {
            if (keyH.upPressed == true) {
                direction = "up";
                //System.out.println("Up pressed: " + playerX + ", " + playerY);
            }
            if (keyH.downPressed == true) {
                direction = "down";
                //System.out.println("Down pressed: " + playerX + ", " + playerY);

            }
            if (keyH.leftPressed == true) {
                direction = "left";
                //System.out.println("Left pressed: " + playerX + ", " + playerY);

            }
            if ( keyH.rightPressed == true) {
                direction = "right";
                //System.out.println("Right pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.upPressed && keyH.leftPressed) == true) {
                direction = "upleft";
                //System.out.println("Up left pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.upPressed && keyH.rightPressed) == true) {
                direction = "upright";
                //System.out.println("Up right pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.downPressed && keyH.leftPressed) == true) {
                direction = "downleft";
                //System.out.println("Down left pressed: " + playerX + ", " + playerY);
            }
            if ((keyH.downPressed && keyH.rightPressed) == true) {
                direction = "downright";
                //System.out.println("Down right pressed: " + playerX + ", " + playerY);
            }

            //Check tile collision
            collisionOn = false;
            gp.colDect.checkTile(this);

            //Check object collison
            // int objIndex = gp.colDect.checkObject(this, true);
            // pickUpObject(objIndex);

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
            
            if(keyH.attackPressed==true&&attackCanceled==false){
                attacking = true;
                spriteCounter=0;
            }
            attackCanceled =false;
            gp.KeyH.attackPressed = false;
             gp.KeyH.interPressed = false;

            //player image changes every 6 frames
            spriteCounter++;
            if (spriteCounter >  6) {
                if (spriteNum == 0) {
                    spriteNum =1;
                }
                else if (spriteNum == 1) {
                    spriteNum =2;
                }
                else if (spriteNum == 2) {
                    spriteNum =3;
                }
                else if (spriteNum == 3) {
                    spriteNum =4;
                }
                else if (spriteNum == 4) {
                    spriteNum =5;
                }
                else if (spriteNum == 5) {
                    spriteNum =6;
                }
                else if (spriteNum == 6) {
                    spriteNum =7;
                }
                else if (spriteNum == 7) {
                    spriteNum =0;
                }
                // else if (spriteNum == 8) {
                //     spriteNum =9;
                // }
                // else if (spriteNum == 9) {
                //     spriteNum =0;
                // }
                spriteCounter =0;
            }
        }
    //invincible time must outside of the key if statement
    if(invincible == true){
        invincibleCounter++;
        if(invincibleCounter > 60) {
            invincible = false;
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

    //attack animation
    public void attacking (){
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
            damageMonster ( monsterIndex);

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
            String objectName = gp.obj[i].name;
            switch(objectName){
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey>0){
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    else {
                        gp.ui.showMessage("You need a key to open!");
                    }
                    break;
                case "Boots":
                    gp.playSE(1);
                    speed += 2;
                    gp.obj[i] = null;
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(2);
                    break;
            }
        }
    }
    public void interactNPC(int i) {
        if (gp.KeyH.attackPressed==false && gp.KeyH.interPressed==true){
            if(i!=9999)
            {
                attackCanceled=true;
                gp.gameState = gp.dialogueState;
                gp.npc[gp.currentMap][i].speak();   
            }
            
        }else if(gp.KeyH.attackPressed==true && gp.KeyH.interPressed==false){attacking = true;}

    }
    public void encounterMonster(int i) {
        if (i!=9999){
            
            if(invincible == false){

                int damage = gp.monster[gp.currentMap][i].attack - defense;
                if(damage < 0){
                    damage = 0;
                }
                life -=damage;  
                invincible = true;              
            }

        }
    }

    public void damageMonster(int i){
            if(i != 9999){
            // System.out.println("Hit!");             //give damage to monster
            if(gp.monster[gp.currentMap][i].invincible == false){
                int damage = attack - gp.monster[gp.currentMap][i].defense;
                if(damage < 0){
                    
                    damage = 0;

                }
                gp.monster[gp.currentMap][i].life -= damage;
                gp.monster[gp.currentMap][i].invincible = true;
                gp.monster[gp.currentMap][i].damagereaction();

                if(gp.monster[gp.currentMap][i].life <=0){
                    gp.monster[gp.currentMap][i].die=true;             //kill monster
                }
            }
        } 
        // else System.out.println("Miss!");
    }
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white); // set color to use for drawing objects
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

       // if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || (keyH.leftPressed && keyH.upPressed) == true || (keyH.rightPressed && keyH.upPressed) == true || (keyH.leftPressed && keyH.downPressed) == true || (keyH.rightPressed && keyH.downPressed) == true ) {
           
            switch (direction) {
                case "up":
                if(attacking == false){
                    if (spriteNum == 0) {
                        image = up0;
                    }
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    if (spriteNum == 3) {
                        image = up3;
                    }
                    if (spriteNum == 4) {
                        image = up4;
                    }
                    if (spriteNum == 5) {
                        image = up5;
                    }
                    if (spriteNum == 6) {
                        image = up6;
                    }
                    if (spriteNum == 7) {
                        image = up7;
                    }
                    // if (spriteNum == 8) {
                    //     image = up8;
                    // }
                    // if (spriteNum == 9) {
                    //     image = up9;
                    // }
                }
            if(attacking == true){
                tempScreenY = screenY - gp.tileSize;    //fix up attack
                if(spriteNum==1){image = upAttack1;}
                if(spriteNum==2){image = upAttack2;}
                if(spriteNum==3){image = upAttack3;}
                if(spriteNum==4){image = upAttack4;}
            }
                    break;

                case "down":
            if(attacking == false){
                    if (spriteNum == 0) {
                        image = down0;
                    }
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = down3;
                    }
                    if (spriteNum == 4) {
                        image = down4;
                    }
                    if (spriteNum == 5) {
                        image = down5;
                    }
                    if (spriteNum == 6) {
                        image = down6;
                    }
                    if (spriteNum == 7) {
                        image = down7;
                    }
                    if (spriteNum == 8) {
                        image = down8;
                    }
                    if (spriteNum == 9) {
                        image = down9;
                    }
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
                    if (spriteNum == 0) {
                        image = left0;
                    }
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    if (spriteNum == 3) {
                        image = left3;
                    }
                    if (spriteNum == 4) {
                        image = left4;
                    }
                    if (spriteNum == 5) {
                        image = left5;
                    }
                    if (spriteNum == 6) {
                        image = left6;
                    }
                    if (spriteNum == 7) {
                        image = left7;
                    }
                    // if (spriteNum == 8) {
                    //     image = left8;
                    // }
                    // if (spriteNum == 9) {
                    //     image = left9;
                    // }
                }
            if(attacking == true){
                tempScreenX = screenX - gp.tileSize;    //fix left attack
                if(spriteNum==1){image = leftAttack1;}
                if(spriteNum==2){image = leftAttack2;}
                if(spriteNum==3){image = leftAttack3;}
                if(spriteNum==4){image = leftAttack4;}
            }
                    break;

                case "right":
            if(attacking == false){
                    if (spriteNum == 0) {
                        image = right0;
                    }
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    if (spriteNum == 3) {
                        image = right3;
                    }
                    if (spriteNum == 4) {
                        image = right4;
                    }
                    if (spriteNum == 5) {
                        image = right5;
                    }
                    if (spriteNum == 6) {
                        image = right6;
                    }
                    if (spriteNum == 7) {
                        image = right7;
                    }
                    // if (spriteNum == 8) {
                    //     image = right8;
                    // }
                    // if (spriteNum == 9) {
                    //     image = right9;
                    // }
                }
            if(attacking == true){
                if(spriteNum==1){image = rightAttack1;}
                if(spriteNum==2){image = rightAttack2;}
                if(spriteNum==3){image = rightAttack3;}
                if(spriteNum==4){image = rightAttack4;}
            }
                    break;

                case "upleft":
            if(attacking == false){
                if (spriteNum == 0) {
                    image = up0;
                }
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                if (spriteNum == 5) {
                    image = up5;
                }
                if (spriteNum == 6) {
                    image = up6;
                }
                if (spriteNum == 7) {
                    image = up7;
                }
                if (spriteNum == 8) {
                    image = up8;
                }
                if (spriteNum == 9) {
                    image = up9;
                }
            }
            if(attacking == true){
                tempScreenY = screenY - gp.tileSize;    //fix up attack
                if(spriteNum==1){image = upAttack1;}
                if(spriteNum==2){image = upAttack2;}
                if(spriteNum==3){image = upAttack3;}
                if(spriteNum==4){image = upAttack4;}
            }
                    break;

                case "upright":
            if(attacking == false){
                if (spriteNum == 0) {
                    image = up0;
                }
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                if (spriteNum == 5) {
                    image = up5;
                }
                if (spriteNum == 6) {
                    image = up6;
                }
                if (spriteNum == 7) {
                    image = up7;
                }
                // if (spriteNum == 8) {
                //     image = up8;
                // }
                // if (spriteNum == 9) {
                //     image = up9;
                // }
            }
            if(attacking == true){
                tempScreenY = screenY - gp.tileSize;    //fix up attack
                if(spriteNum==1){image = upAttack1;}
                if(spriteNum==2){image = upAttack2;}
                if(spriteNum==3){image = upAttack3;}
                if(spriteNum==4){image = upAttack4;}
            }
                    break;
                case "downleft":
                if(attacking == false){
                if (spriteNum == 0) {
                    image = down0;
                }
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                if (spriteNum == 5) {
                    image = down5;
                }
                if (spriteNum == 6) {
                    image = down6;
                }
                if (spriteNum == 7) {
                    image = down7;
                }
                // if (spriteNum == 8) {
                //     image = down8;
                // }
                // if (spriteNum == 9) {
                //     image = down9;
                // }
            }
            if(attacking == true){
                if(spriteNum==1){image = downAttack1;}
                if(spriteNum==2){image = downAttack2;}
                if(spriteNum==3){image = downAttack3;}
                if(spriteNum==4){image = downAttack4;}
            }
                    break;
                case "downright":
            if(attacking == false){

                if (spriteNum == 0) {
                    image = down0;
                }
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                if (spriteNum == 5) {
                    image = down5;
                }
                if (spriteNum == 6) {
                    image = down6;
                }
                if (spriteNum == 7) {
                    image = down7;
                }
                if (spriteNum == 8) {
                    image = down8;
                }
                if (spriteNum == 9) {
                    image = down9;
                }
            }
            if(attacking == true){
                if(spriteNum==1){image = downAttack1;}
                if(spriteNum==2){image = downAttack2;}
                if(spriteNum==3){image = downAttack3;}
                if(spriteNum==4){image = downAttack4;}
            }break;
        }
    // }
    //     else {
    //         // Character is idle
    //         switch (direction) {
    //             case "up":
    //                 image = idleUp;
    //                 break;
    //             case "down":
    //                 image = idleDown;
    //                 break;
    //             case "left":
    //                 image = idleLeft;
    //                 break;
    //             case "right":
    //                 image = idleRight;
    //                 break;
    //     }
    //     }
            if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, tempScreenX, tempScreenY, gp.tileSize, gp.tileSize, null);
        //reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // //DEBUG monster hit player
        // g2.setFont(new Font("Arial", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invincible:"+invincibleCounter,10,400);
    }
}
