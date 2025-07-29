package fr.ab3d0.object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Obj_Key extends SuperObject{

    public Obj_Key(){
        name = "Key";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch (IOException e){
            e.printStackTrace();;
        }


    }
}
