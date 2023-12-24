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
}
