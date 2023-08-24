package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class tileManager 
{
	GamePanel gp ;
	Tile []tile;
	public tileManager(GamePanel gp) 
	{
		this.gp=gp;
		tile=new Tile[10];
		getTileImage();
		
	}
	public void getTileImage() 
	{
		
		try 
		{
			tile[0]=new Tile();
			tile[0].image=ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));
			tile[1]=new Tile();
			tile[1].image=ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
			tile[2]=new Tile();
			tile[2].image=ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g) 
	{
		// outer box
		g.drawImage(tile[2].image,0,0,gp.tileSize,gp.tileSize,null);//first wall
		
		//first side
		g.drawImage(tile[2].image,48,0,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,96,0,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,144,0,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,192,0,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,240,0,gp.tileSize,gp.tileSize,null);
		//second side
		g.drawImage(tile[2].image,0,48,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,0,96,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,0,144,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,0,192,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,0,240,gp.tileSize,gp.tileSize,null);
		//third side 
		g.drawImage(tile[1].image,48,240,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[1].image,96,240,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[1].image,144,240,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[1].image,192,240,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,240,240,gp.tileSize,gp.tileSize,null);
		//fourth side
		g.drawImage(tile[2].image,240,48,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,240,96,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,240,144,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[2].image,240,192,gp.tileSize,gp.tileSize,null);
		
		// inner box
		g.drawImage(tile[0].image,48,48,gp.tileSize,gp.tileSize,null);//first grass
		//first side 
		g.drawImage(tile[0].image,96,48,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,144,48,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,192,48,gp.tileSize,gp.tileSize,null);
		//second side
		g.drawImage(tile[0].image,48,96,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,48,144,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,48,192,gp.tileSize,gp.tileSize,null);
		//third side
		g.drawImage(tile[0].image,96,192,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,144,192,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,192,192,gp.tileSize,gp.tileSize,null);
		//fourth side 
		g.drawImage(tile[0].image,192,96,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,192,144,gp.tileSize,gp.tileSize,null);
		//inner box2
		g.drawImage(tile[0].image,96,96,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,144,96,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,96,144,gp.tileSize,gp.tileSize,null);
		g.drawImage(tile[0].image,144,144,gp.tileSize,gp.tileSize,null);
		//note efficient way of doing this so we'll redo it
		
		
	}
}
