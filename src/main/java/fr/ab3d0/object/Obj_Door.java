package fr.ab3d0.object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Door extends SuperObject{

    public Obj_Door(){
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
