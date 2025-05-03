package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardMovements implements KeyListener
{
    public boolean upPressed , downPressed , leftPressed , rightPressed; //boolean variables to check if the keys are pressed
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    public void keyPressed(KeyEvent e){
        //TODO Auto-generated method stub
        int key = e.getKeyCode(); //get the key that was pressed
        if (key == KeyEvent.VK_W) { 
            upPressed = true; //set the upPressed variable to true if the W key is pressed
        }
        if (key == KeyEvent.VK_S) { 
            downPressed = true; //set the downPressed variable to true if the S key is pressed
        }
        if (key == KeyEvent.VK_A) { 
            leftPressed = true; //set the leftPressed variable to true if the A key is pressed
        }
        if (key == KeyEvent.VK_D) { 
            rightPressed = true; //set the rightPressed variable to true if the D key is pressed    
        }
    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
        int code = e.getKeyCode(); //get the key that was released

        if (code == KeyEvent.VK_W) { 
            upPressed = false; //set the upPressed variable to true if the W key is pressed
        }
        if (code == KeyEvent.VK_S) { 
            downPressed = false; //set the downPressed variable to true if the S key is pressed
        }
        if (code == KeyEvent.VK_A) { 
            leftPressed = false; //set the leftPressed variable to true if the A key is pressed
        }
        if (code == KeyEvent.VK_D) { 
            rightPressed = false; //set the rightPressed variable to true if the D key is pressed    
        }
    }
}