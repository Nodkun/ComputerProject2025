package Src.tile;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Src.Main.Subpanel;
//import Src.tile.tile;

public class TileManager {

    Subpanel gp;
    tile[] tile;

    int mapTileNum[][];

    public TileManager(Subpanel gp) {
        this.gp=gp;

        tile=new tile[10];//ten tiles for now

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/Maps/WorldGen2.txt");
    }

    public void getTileImage(){
       try {

      tile[0]= new tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass.png"));

      tile[1]= new tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall.png"));

      tile[2]= new tile();
      tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));

      tile[3]= new tile();
      tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/earth.png"));

      tile[4]= new tile();
      tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));

      tile[5]= new tile();
      tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));

      tile[6]= new tile();
      tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/pathway.png"));

       }
       catch(IOException e){
        e.printStackTrace();
       }
    }


    public void loadMap(String filePath)
    {
       try {
        InputStream is = getClass().getResourceAsStream(filePath);
        

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col =0;
        int row = 0;

        while (col<gp.maxWorldCol && row < gp.maxSWorldRow)
        {
          String line = br.readLine();//read single line and print

          while (col<gp.maxWorldCol)
          {
            String numbers[] = line.split("");//splits the string

            int num = Integer.parseInt(numbers [col]);//changes it from string to int 

            mapTileNum[col][row]=num;

            col++;
          }
          if (col==gp.maxWorldCol)
          {
            col = 0;
            row++;
          }
        }
        br.close();


       }
       catch(Exception e)
       {

       }


    }
    

    public void draw(Graphics2D g2){

      int worldCol = 0;
      int worldRow =0;
      

      //g2.drawImage(tile[0].image, 0, 0, gp.tileSize,gp.tileSize, null );

      //g2.drawImage(tile[1].image, 48, 0, gp.tileSize,gp.tileSize, null );

      //g2.drawImage(tile[2].image, 96, 0, gp.tileSize,gp.tileSize, null );

      while(worldCol<gp.maxWorldCol && worldRow< gp.maxWorldRow)
      {
            int tileNum = mapTileNum[worldCol][worldRow];

        g2.drawImage(tile[tileNum].image, x, y, gp.tileSize,gp.tileSize, null );
        worldCol++;
        

        if (worldCol == gp.maxWorldCol){

          worldCol=0;
         
          worldRow++;
         
        }
      }
      



    }
}
