package Src.e_ntity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;

import Src.Main.KeyboardMovements;
import Src.Main.Subpanel;

public class Player extends Entity
{
    Subpanel gp;
    KeyboardMovements key; //create an instance of the KeyboardMovements class
    public Player(Subpanel gp, KeyboardMovements key)
    {
        this.gp = gp; //set the subpanel
        this.key = key; //set the keyboard movements

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){  //default values for player
          x = 100;
          y=100;
          speed = 3; 
          direction = "down";

    }
    
    
    public void getPlayerImage()
    {
        //Load basic player movement animations in try and catch
        try
        {
            

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));

            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));
            
        }
        catch(IOException e)
        {
                e.printStackTrace();
        }
    }
    
    public void update(){ //this is called 60 times per second

        if(key.upPressed == true || key.downPressed == true || key.leftPressed == true ||key.rightPressed == true)
        {
        
         if(key.upPressed == true) //if the up key is pressed
        {
            direction = "up";
            y -= speed; //move the player up
        }
        else if(key.downPressed == true) //if the down key is pressed
        {
            direction = "down";
            y  += speed; //move the player down
        }
        else if (key.leftPressed == true) //if the left key is pressed
        {
            direction = "left";
            x -= speed; //move the player left
        }
        else if(key.rightPressed == true) //if the right key is pressed
        {
            direction = "right";
            x += speed; //move the player right
        }
        
//technical changing of sprite in movement animation
        spriteCounter++;
        if (spriteCounter >12){  //player movement is then 10 fps
            if (spriteNum==1){
                spriteNum=2;
            }
        else if (spriteNum == 2){
            spriteNum=1;
        }
        spriteCounter=0;
        }
    }

    else if (key.dancePressed ==true)
        {
            spriteCounter++;
        if (spriteCounter >12){  //player movement is then 10 fps
            if (spriteNum==1){
                spriteNum=2;
            }
        else if (spriteNum == 2){
            spriteNum=1;
        }
        spriteCounter=0;
        }
        else{}
    }

    }
     public void draw(Graphics2D g2)
     
     {
        BufferedImage image = null;
 //display sprite movements
        switch(direction){
            case "up":
            if(spriteNum==1){
                image=up1;
            }
            if(spriteNum ==2) { 
                image=up2; 
            }
            break;
            
            case "down":
            if(spriteNum==1){
                image=down1;
            }
            if(spriteNum ==2) { 
                image=down2; 
            }
            break;

            case "left":
            if(spriteNum==1){
                image=left1;
            }
            if(spriteNum ==2) { 
                image=left2; 
            }
            break;

            case "right":
            if(spriteNum==1){
                image=right1;
            }
            if(spriteNum ==2) { 
                image=right2; 
            }
            break;

        }//set player sprite value based on direction
        
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);//Draw image of player sprite

     }
}
