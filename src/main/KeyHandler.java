package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.plaf.TextUI;

public class KeyHandler implements KeyListener 
{
	 public boolean up,down,left,right,keyP;

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		int code =e.getKeyCode();
		if(code == KeyEvent.VK_W) 
		{
			up=true;
			keyP=true;
		}
		if(code == KeyEvent.VK_A) 
		{
			left=true;
			keyP=true;
		}
		if(code == KeyEvent.VK_S) 
		{
			down=true;
			keyP=true;
		}
		if(code == KeyEvent.VK_D) 
		{
			right=true;
			keyP=true;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		int code =e.getKeyCode();
		if(code == KeyEvent.VK_W) 
		{
			up=true;
			keyP=true;
		}
		if(code == KeyEvent.VK_A) 
		{
			left=true;
			keyP=true;
		}
		if(code == KeyEvent.VK_S) 
		{
			down=true;
			keyP=true;
		}
		if(code == KeyEvent.VK_D) 
		{
			right=true;
			keyP=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		int code =e.getKeyCode();
		if(code == KeyEvent.VK_W) 
		{
			up=false;
			keyP=false;
		}
		if(code == KeyEvent.VK_A) 
		{
			left=false;
			keyP=false;
		}
		if(code == KeyEvent.VK_S) 
		{
			down=false;
			keyP=false;
		}
		if(code == KeyEvent.VK_D) 
		{
			right=false;
			keyP=false;
		}
		
		
	}

}
