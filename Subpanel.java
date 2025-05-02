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

    Thread gameThread;
    public Subpanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); //background color
        this.setDoubleBuffered(true); //for better performance
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
    } 
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; //for better performance
        g2.setColor(Color.white); //set color to white
        g2.fillRect(100, 100, tileSize, tileSize); //draw a rectangle at (0,0) with width and height of tileSize
        g2.dispose(); //dispose of the graphics object to free up resources
    }
}
