package Src.tile;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Src.Main.Subpanel;
//import Src.tile.tile;

public class TileManager {

    Subpanel gp;
    tile[] tile;


    public TileManager(Subpanel gp) {
        this.gp=gp;

        tile=new tile[10];//ten tiles for now

        getTileImage();
    }

    public void getTileImage(){
       try {

      tile[0]= new tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass.png"));

      tile[1]= new tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall.png"));

      tile[2]= new tile();
      tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));

       }
       catch(IOException e){
        e.printStackTrace();
       }
    }

    public void draw(Graphics2D g2){

      g2.drawImage(tile[0].image, 0, 0, gp.tileSize,gp.tileSize, null );

    }
}
