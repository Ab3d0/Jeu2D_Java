package fr.ab3d0.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Chest  extends SuperObject {

    public Obj_Chest(){
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}






