import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.security.Key;

public class Subpanel extends JPanel implements Runnable
{
    //Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; //3x scale

    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16; //16 columns
    final int maxScreenRow = 12; //12 rows
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    int FPS = 60; //frames per second
    
    KeyboardMovements key = new KeyboardMovements(); //create an instance of the KeyboardMovements class

    Thread gameThread;

    //Set player's default position
    int playerX = 100; //x position of the player
    int playerY = 100; //y position of the player
    int playerSpeed = 4; //speed of the player

    public Subpanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); //background color
        this.setDoubleBuffered(true); //for better performance
        this.addKeyListener(key); //add the key listener to the panel
        this.setFocusable(true);
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    //threads edited
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(gameThread != null)
        {
           long currentTime = System.nanoTime(); //get the current time in nanoseconds
            // System.out.println("The game loop is running");
           // 1 UPDATE: update information such as character postions
           update();
           // 2 DRAW: draw the screen with the updated information
           repaint();

        }
    }
    public void update()
    {
        //update the game
        if(key.upPressed == true) //if the up key is pressed
        {
            playerY -= playerSpeed; //move the player up
        }
        else if(key.downPressed == true) //if the down key is pressed
        {
            playerY += playerSpeed; //move the player down
        }
        else if (key.leftPressed == true) //if the left key is pressed
        {
            playerX -= playerSpeed; //move the player left
        }
        else if(key.rightPressed == true) //if the right key is pressed
        {
            playerX += playerSpeed; //move the player right
        }
    } 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //for better performance
        g2.setColor(Color.white); 
        g2.fillRect(playerX, playerY, tileSize, tileSize); //draw a rectangle at (0,0) with width and height of tileSize
        g2.dispose(); //dispose of the graphics object to free up resources
    }
} 
