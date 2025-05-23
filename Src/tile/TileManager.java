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
    public tile[] tile;

    public int mapTileNum[][];

    public TileManager(Subpanel gp) {
        this.gp=gp;

        tile=new tile[20];//ten tiles for now

        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/Maps/WorldGen3.txt");
    }

    public void getTileImage(){
       try {

      tile[0]= new tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Grass.png"));

      tile[1]= new tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Wall.png"));
      tile[1].collision = true;

      tile[2]= new tile();
      tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
      tile[2].collision = true;

      tile[3]= new tile();
      tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/earth.png"));

      tile[4]= new tile();
      tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
      tile[4].collision = true;

      tile[5]= new tile();
      tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sand.png"));

      tile[6]= new tile();
      tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/pathway.png"));

      tile[7]= new tile();
      tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Tree2.png"));
      tile[7].collision = true;

      tile[8]= new tile();
      tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/FloorTile.png"));

      tile[9]= new tile();
      tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bridgedown.png"));

      //tile[10]= new tile();
      //tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/bridgeside.png"));
      //not using till code is updated to follow spaces n stuff


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

        while (col<gp.maxWorldCol && row < gp.maxWorldRow)
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

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldx + gp.player.screenX;
            int screenY = worldY - gp.player.worldy + gp.player.screenY;


            
        if (worldX > gp.player.worldx - gp.player.screenX && worldX< gp.player.worldx + gp.player.screenX &&
         worldY > gp.player.worldy - gp.player.screenY && worldY< gp.player.worldy + gp.player.screenY )//only render the world arounf the player
         {
        g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize,gp.tileSize, null );
        
         }
         worldCol++;

        if (worldCol == gp.maxWorldCol){

          worldCol=0;
         
          worldRow++;
         
        }
      }
      



    }
}
