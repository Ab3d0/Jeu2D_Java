package fr.ab3d0.Jeu2D;

import fr.ab3d0.object.Obj_Chest;
import fr.ab3d0.object.Obj_Door;
import fr.ab3d0.object.Obj_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }
    public void setObject(){
        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 37 * gp.tileSize;
        gp.obj[0].worldY = 27 * gp.tileSize;

        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 6 * gp.tileSize;
        gp.obj[1].worldY = 5 * gp.tileSize;

        gp.obj[2] = new Obj_Door();
        gp.obj[2].worldX = 31 * gp.tileSize;
        gp.obj[2].worldY = 2 * gp.tileSize;

        gp.obj[3] = new Obj_Chest();
        gp.obj[3].worldX = 9 * gp.tileSize;
        gp.obj[3].worldY = 25 * gp.tileSize;


    }



}
