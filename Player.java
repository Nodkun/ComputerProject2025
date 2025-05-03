
import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity
{
    Subpanel gp;
    KeyboardMovements key; //create an instance of the KeyboardMovements class
    public Player(Subpanel gp, KeyboardMovements key)
    {
        this.gp = gp; //set the subpanel
        this.key = key; //set the keyboard movements

        setDefaultValues();
    }
    public void setDefaultValues(){  //default values for player
          x = 100;
          y=100;
          speed = 4; 

    }
    public void update(){
         if(key.upPressed == true) //if the up key is pressed
        {
            y -= speed; //move the player up
        }
        else if(key.downPressed == true) //if the down key is pressed
        {
            y  += speed; //move the player down
        }
        else if (key.leftPressed == true) //if the left key is pressed
        {
            x -= speed; //move the player left
        }
        else if(key.rightPressed == true) //if the right key is pressed
        {
            x += speed; //move the player right
        }

    }
     public void draw(Graphics2D g2){
        g2.setColor(Color.white); 
        g2.fillRect(x, y, gp.tileSize, gp.tileSize); 

     }
}