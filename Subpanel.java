import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

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
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    } 
}
