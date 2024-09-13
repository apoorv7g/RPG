package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity
{
	GamePanel gp;
	KeyHandler keyH;
	public final int ScreenX;
	public final int ScreenY;	
	public Player(GamePanel gp,KeyHandler keyH) 
	{
		this.gp=gp;
		this.keyH=keyH;		
		ScreenX=gp.screenWidth/2-(gp.tileSize/2);
		ScreenY=gp.screenHeight/2-(gp.tileSize/2);	
		solidArea=new Rectangle();
		solidArea.x=15;
		solidArea.y=18;
		solidArea.width=16;
		solidArea.height=24;
		defaultValue();
		getImage();
	}
	public void defaultValue() 
	
	{
		worldx=gp.tileSize*24		;
		worldy=gp.tileSize*24	;
		speed=4;
		direction="down";
	}
	public void getImage() 
	{
		try {
			down=ImageIO.read(getClass().getResourceAsStream("/player/player1-front.png"));
			up=ImageIO.read(getClass().getResourceAsStream("/player/player1-back.png"));
			left=ImageIO.read(getClass().getResourceAsStream("/player/player1-left.png"));
			right=ImageIO.read(getClass().getResourceAsStream("/player/player1-right.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void update() 
	{
		if(keyH.up==true) 
		{
			direction="up";
			
		}
		else if(keyH.down==true) 
		{
			direction="down";
			
		}
		else if(keyH.left==true) 
		{
			direction="left";
			
		}
		else if(keyH.right==true) 
		{
			direction="right";
			
		}
		collisionOn=false;
		gp.collisionChecker.checkTile(this);
		if(collisionOn==false &&keyH.keyP==true) {
			switch(direction) {
			case "up":worldy-=speed;
				break;
			case "down":worldy+=speed;
				break;
			case "left":worldx-=speed;
				break;
			case "right":worldx+=speed;
				break;
				
			}
		}
	}
	public void draw(Graphics2D g2d) {
		BufferedImage image=null;
		switch (direction) 
		{
		case "up": 
		{
			
			image=up;
		}
		break;
		case "down": 
		{
			
			image=down;
		}
		break;
		case "left": 
		{
			
			image=left;
		}
		break;
		case "right": 
		{
			
			image=right;
		}
		break;
		
		}
		g2d.drawImage(image, ScreenX, ScreenY, gp.tileSize,gp.tileSize,	null );
	}
	
		
	

}
