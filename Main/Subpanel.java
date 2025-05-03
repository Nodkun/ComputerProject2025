package Main;
import javax.swing.JPanel;

import e_ntity.Player;

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

    public final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16; //16 columns
    final int maxScreenRow = 12; //12 rows
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    int FPS = 60; //frames per second
    
    KeyboardMovements key = new KeyboardMovements(); //create an instance of the KeyboardMovements class
    Player player = new Player(this, key); //create an instance of the Player class

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
    // public void run() {

    //     double drawInterval = 1000000000/FPS; //0.0166666666666667 seconds
    //     double nextDrawTime = System.nanoTime() + drawInterval; //next draw time

    //     // TODO Auto-generated method stub
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
    //             Thread.sleep((long)remainingTime / 1000000); //sleep for the remaining time in milliseconds
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
        double drawInterval = 1000000000/FPS; //0.0166666666666667 seconds
        double delta = 0;
        long lastTime = System.nanoTime(); //get the current time in nanoseconds
        long currentTime; //current time in nanoseconds 
        long timer = 0;
        long drawCount = 0; //number of frames drawn 

        while (gameThread!=null)
        {
            currentTime = System.nanoTime(); //get the current time in nanoseconds
            delta += (currentTime - lastTime) / drawInterval; //calculate the delta time 
            timer += (currentTime - lastTime); //calculate the timer   
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

        player.draw(g2); 

        g2.dispose(); //dispose of the graphics object to free up resources
    }
} 
