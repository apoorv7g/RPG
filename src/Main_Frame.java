import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;

public class Main_Frame 
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Main_Frame window = new Main_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Frame() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("");
		frame.getContentPane().setBackground(new Color(255, 0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
        int usableWidth = screenSize.width - screenInsets.left - screenInsets.right;
        int usableHeight = screenSize.height - screenInsets.top - screenInsets.bottom;
        frame.setBounds(0, 0, usableWidth, usableHeight);
        frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
        frame.setVisible(true);
         

	}

}
