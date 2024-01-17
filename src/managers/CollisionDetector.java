package managers;

import entities.Entity;
import main.GamePanel;

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
        //temp
        String direction = entity.direction;

        if (entity.knockBack == true) {
            direction = entity.knockBackDirection;
        }
        switch (direction) {
            
            //prediction the coordinates of player as it moves
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "down":

                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "upleft":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;  
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];

                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;  
                tileNum3 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum4 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true || gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }

                break;
            case "upright":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;  
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];

                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;  
                tileNum3 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum4 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true || gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }
            break;
            case "downleft":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;  
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];

                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum3 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum4 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
                
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }
                break;
            case "downright":

                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize; 
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;  
                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];

                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum3 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
                tileNum4 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision ==true) {
                    entity.collisionOn = true;
                }
                break;              
        }
    }
    
    public int checkObject(Entity entity, boolean player){
        int index = 9999;
        for(int i = 0; i<gp.obj[1].length; i++){

            if(gp.obj[gp.currentMap][i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].worldX + gp.obj[gp.currentMap][i].solidArea.x;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].worldY + gp.obj[gp.currentMap][i].solidArea.y;

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
                    if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)){
                    if(gp.obj[gp.currentMap][i].collision == true){
                        entity.collisionOn = true;
                    }
                    if(player == true){
                        index = i;
                    }
                }    
                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
            }
        }
        return index;
    }
    
    public int checkEntity(Entity entity, Entity[][] target) {
        int index = 9999;
        for(int i = 0; i < target[1].length; i++){
            if(target[gp.currentMap][i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].worldX + target[gp.currentMap][i].solidArea.x;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].worldY + target[gp.currentMap][i].solidArea.y;
                //temp
                String direction = entity.direction;

                if (entity.knockBack == true) {
                    direction = entity.knockBackDirection;
}
                switch(direction){
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
                if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea)){
                    if(target[gp.currentMap][i]!=entity){
                        entity.collisionOn = true;
                        index = i; 
                        }                      
                }                          
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
                target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;       
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
                hitplayer = true;
                }                
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

        return hitplayer;
    }
}
