import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable
{
	final int originalTileSize=16;
	final int scale=3;
	final int tileSize = originalTileSize * scale;
	final int maxCol=16;
	final int maxRow=12;
	final int screenWidth=maxCol * tileSize;
	final int screenHeight=maxRow * tileSize;
	int FPS=60;
	KeyHandler keyH=new KeyHandler();
	Thread gameThread;
	int x=100;
	int y=100;
	int speed =4;
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	public void ThreadStart() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}

	@Override
	public void run()
	{
		double interval=1000000000/FPS;
		double nextDraw=System.nanoTime() +interval ;
		// TODO Auto-generated method stub
		while(gameThread != null ) 
		{
			update();
			repaint();
			
			try {
				
				double remain =nextDraw-System.nanoTime();
				remain=remain/1000000;
				
				if(remain < 0)
				{
					remain=0;
				}
				Thread.sleep((long) remain);
				nextDraw+=interval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void update() 
	{
		if(keyH.up==true) 
		{
			y-=speed;
		}
		else if(keyH.down==true) 
		{
			y+=speed;
		}
		else if(keyH.left==true) 
		{
			x-=speed;
		}
		else if(keyH.right==true) 
		{
			x+=speed;
		}
	}
	public void paintComponent(Graphics g) 
	{
		Toolkit.getDefaultToolkit().sync();
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setColor(Color.white);
		g2d.fillRect(x, y,tileSize, tileSize);
		g2d.dispose(); 
	}
	
	
	
	
}
