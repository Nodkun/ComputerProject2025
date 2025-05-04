package Src.e_ntity;

import java.awt.image.BufferedImage;

public class Entity //entity super class
{
    public int worldx,worldy ;
    public int speed; //speed of the entity

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2; //for player sprite images & animation

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}