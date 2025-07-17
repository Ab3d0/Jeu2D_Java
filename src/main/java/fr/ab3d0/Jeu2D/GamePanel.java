package fr.ab3d0.Jeu2D;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; /* ça fait 760 pixels */
    final int screenHeight = tileSize * maxScreenRow; /* ça fait 576 pixels */

    Thread gameThread;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
