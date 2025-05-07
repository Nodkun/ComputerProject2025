package Src.Main;
import javax.swing.JPanel;

// Ensure the correct package path for the Player class
import Src.e_ntity.Player; // Update this path if the Player class is in a different package
import Src.tile.TileManager;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.security.Key;

public class Subpanel extends JPanel implements Runnable
{
    //Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; //3x scale

    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16; //16 columns
    public final int maxScreenRow = 12; //12 rows
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels


    //World Settings 
//r2d2 is cool 
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;


    int FPS = 60; //frames per second
    TileManager tileM = new TileManager(this);
    KeyboardMovements key = new KeyboardMovements(); //create an instance of the KeyboardMovements class
    public Player player = new Player(this, key); //create an instance of the Player class
    public Collision collisionChecker = new Collision(this);

    Thread gameThread;

    

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
    //sleep method (not in use, just for referance if need new loop)
    // public void run() {

    //     double drawInterval = 1000000000/FPS; //0.0166666666666667 seconds
    //     double nextDrawTime = System.nanoTime() + drawInterval; //next draw time

    //     
    //     while(gameThread != null)
    //     {
           
    //        update();

    //        repaint();

           
    //        try
    //        {
    //             double remainingTime = nextDrawTime - System.nanoTime(); //calculate the remaining time
    //             if(remainingTime < 0) //if the remaining time is less than 0
    //             {
    //                 remainingTime = 0; //set the remaining time to 0
    //             }
    //             Thread.sleep((long)remainingTime / 1000000); //sleep for the remaining time in milliseconds (innacurate)
    //             nextDrawTime += drawInterval; //set the next draw time to the current time + the draw interval
    //        } 
    //        catch(InterruptedException e)
    //        {
    //             e.printStackTrace(); //print the stack trace if there is an error
    //        }

    //     }
    // }

    public void run() 
    {
        double drawInterval = 1000000000/FPS; //draws the screen every 0.0166666666666667 seconds
        double delta = 0;
        long lastTime = System.nanoTime(); //get the current system time in nanoseconds (big number)
        long currentTime; //current time in nanoseconds 
        long timer = 0;
        long drawCount = 0; //number of frames drawn 

        while (gameThread!=null)
        {
            //Delta or accumulator method for drawing screen
            currentTime = System.nanoTime(); //get the current time in nanoseconds
            delta += (currentTime - lastTime) / drawInterval; //calculate the delta time - check how much time has passed 
            timer += (currentTime - lastTime); //calculate the timer - check how much time has past  
            lastTime = currentTime; //set the last time to the current time
            if(delta >= 1) //if the delta time is greater than or equal to 1
            {
                update(); //update the game
                repaint(); //repaint the screen
                delta--; //decrease the delta time by 1
                drawCount++; //increase the number of frames drawn by 1
            }
            if (timer >= 1000000000) //if the timer is greater than or equal to 1 second
            {
                System.out.println("FPS: " + drawCount); //print the number of frames drawn per second
                drawCount = 0; //reset the number of frames drawn to 0
                timer = 0; //reset the timer to 0
            }
        }
    }
    public void update()
    {
        player.update();
    } 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //for better performance

        tileM.draw(g2);

        player.draw(g2); //after tile so that it is on next layer

        g2.dispose(); //dispose of the graphics object to free up resources
    }
} 
