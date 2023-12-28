package main;

import entity.Entity;

public class CollisionDetector {

    GamePanel gp;

    public CollisionDetector(GamePanel gp) {
        this.gp = gp;

    }

    public void checkTile(Entity entity) {
        //Creating a box of collision on the character
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2,tileNum3,tileNum4;
        switch (entity.direction) {
            //prediction the coordinates of player as it moves
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":

                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "upleft":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;  
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;  
                tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true || gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }

                break;
            case "upright":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;  
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;  
                tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true || gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }
            break;
            case "downleft":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;  
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "downright":

                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize; 
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }
                break;              
        }
    }
    public int checkObject(Entity entity, boolean player){
        
        int index = 9999;
        for(int i = 0; i<gp.obj.length; i++){
            if(gp.obj[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                    case "upright":
                        entity.solidArea.x += entity.speed;
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "downright":
                        entity.solidArea.x += entity.speed;
                        entity.solidArea.y += entity.speed;
                        break;
                    case "upleft":
                        entity.solidArea.x -= entity.speed;
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "downleft":
                        entity.solidArea.x -= entity.speed;
                        entity.solidArea.y += entity.speed;
                        break;
                        
                }
                if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                    if(gp.obj[i].collision == true){
                        entity.collisionOn = true;
                    }
                    if(player == true){
                        index = i;
                    }
                }                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }
    //NPC or Monster collisioin
    public int checkEntity(Entity entity, Entity[] target) {
        int index = 9999;
        for(int i = 0; i<target.length; i++){
            if(target[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch(entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed; break;
                    case "down":
                        entity.solidArea.y += entity.speed; break;
                    case "left":
                        entity.solidArea.x -= entity.speed; break;
                    case "right":
                        entity.solidArea.x += entity.speed; break;
                    case "upright":
                        entity.solidArea.x += entity.speed;
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "downright":
                        entity.solidArea.x += entity.speed;
                        entity.solidArea.y += entity.speed;
                        break;
                    case "upleft":
                        entity.solidArea.x -= entity.speed;
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "downleft":
                        entity.solidArea.x -= entity.speed;
                        entity.solidArea.y += entity.speed;
                        break;                        
                    }
                    if(entity.solidArea.intersects(target[i].solidArea)){
                        if(target[i]!=entity){
                        entity.collisionOn = true;
                        index = i; 
                        }                      
                }      
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;       
            }                            
        }
        return index;
    }
    public boolean checkPlayer(Entity entity) {

        boolean hitplayer = false;

        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        switch(entity.direction){
            case "up":
                entity.solidArea.y -= entity.speed;
                break;
            case "down":
               entity.solidArea.y += entity.speed;
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                break;
            case "upright":
                entity.solidArea.x += entity.speed;
                entity.solidArea.y -= entity.speed;
                break;
            case "downright":
                entity.solidArea.x += entity.speed;
                entity.solidArea.y += entity.speed;
                break;
            case "upleft":
                entity.solidArea.x -= entity.speed;
                entity.solidArea.y -= entity.speed;
                break;
            case "downleft":
                entity.solidArea.x -= entity.speed;
                entity.solidArea.y += entity.speed;
                break;        
        }
                if(entity.solidArea.intersects(gp.player.solidArea)){
                entity.collisionOn = true;
                }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

        return hitplayer;
    }
}
