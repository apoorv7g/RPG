package main;
import javax.swing.JFrame;

public class Main_Frame 
{
	public static void main(String args[]) 
	{
		 JFrame mainFrame = new JFrame();
		 mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 mainFrame.setResizable(false);
		 mainFrame.setTitle("Blue man");
		 GamePanel mainPanel = new GamePanel();
		 mainFrame.add(mainPanel);
		 mainFrame.pack();
		 mainFrame.setLocationRelativeTo(null);
		 mainFrame.setVisible(true);
		 mainPanel.ThreadStart();
	}
	
}
