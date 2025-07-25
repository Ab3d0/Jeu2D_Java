package fr.ab3d0.Jeu2D;


import fr.ab3d0.entity.Entity;

public class CollisionGestion {

    GamePanel gp;
    public CollisionGestion(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){
       int entityLeftWorldX = entity.worldX + entity.solidArea.x;
       int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
       int entityTopWorldY = entity.worldY + entity.solidArea.y;
       int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

       int entityLeftCol = entityLeftWorldX/gp.tileSize;
       int entityRightCol = entityRightWorldX/gp.tileSize;
       int entityTopRow = entityTopWorldY/gp.tileSize;
       int entityBottomRow = entityBottomWorldY/gp.tileSize;

       int tileNum1, tileNum2;

       switch(entity.direction){
           case "up":
               entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
               tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
               tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
               if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true){
                   entity.collisionOn = true;
               }
               break;
           case "down":
               entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
               tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
               tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
               if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true){
                   entity.collisionOn = true;
               }

               break;

           case "left":
               entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
               tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
               tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
               if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true){
                   entity.collisionOn = true;
               }
               break;
           case "right":
               entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
               tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
               tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
               if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true){
                   entity.collisionOn = true;
               }
               break;
       }


    }
}
