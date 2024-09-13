package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import entity.Player;
import tile.tileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable
{
	final int originalTileSize=16;
	final int scale=3;
	public final int tileSize = originalTileSize * scale;
	public final int maxCol=16;
	public final int maxRow=12;
	public final int screenWidth=maxCol * tileSize;
	public final int screenHeight=maxRow * tileSize;
	
	public final int WorldmaxCol=50;
	public final int WorldmaxRow=50;
	public final int worldWidth=WorldmaxCol * tileSize;
	public final int worldHeight=WorldmaxRow * tileSize;
	
	int FPS=60;
	tileManager tileManager=new tileManager(this);
	KeyHandler keyH=new KeyHandler();
	Thread gameThread;
	 public CollisionChecker collisionChecker = new CollisionChecker(this);
			
	public Player player=new Player(this, keyH);
	
	
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
		while(gameThread != null  ) 
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
		player.update();
	}
	public void paintComponent(Graphics g) 
	{
		Toolkit.getDefaultToolkit().sync();
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		tileManager.draw(g2d);
		player.draw(g2d);
		g2d.dispose(); 
	}
	
	
	
	
}
