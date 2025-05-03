package Src.Main;
import javax.swing.JFrame;
public class Project
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("CapyCrew");

        Subpanel gamePanel = new Subpanel();
        window.add(gamePanel);

        window.pack(); //sets the size of the window to fit the preferred size of the panel

        window.setLocationRelativeTo(null);
        window.setVisible(true); 

        gamePanel.startGameThread();
        
    }
}
