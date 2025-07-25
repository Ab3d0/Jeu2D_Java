package fr.ab3d0.entity;

import fr.ab3d0.Jeu2D.GamePanel;
import fr.ab3d0.Jeu2D.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel gp, KeyHandler keyH ){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth /2 - (gp.tileSize/2);
        screenY = gp.screenHeight /2 - (gp.tileSize /2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction= "down";
    }

    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/player_img/derriere-debout.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player_img/derriere-marche.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player_img/marche-devant-droit.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player_img/marche-devant-gauche.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player_img/coté-gauche-debout.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player_img/coté-gauche-marche.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player_img/coté-droit-debout.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player_img/coté-droit-marche.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction = "up";
            }else if(keyH.downPressed == true){
                direction = "down";
            }
            else if(keyH.leftPressed == true){
                direction = "left";
            }
            else if (keyH.rightPressed == true){
                direction = "right";
            }

            collisionOn = false;
            gp.cg.checkTile(this);

            if(collisionOn == false){
                switch (direction){
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
                }
            }

            spriteCounter++;
            if(spriteCounter > 13){
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
