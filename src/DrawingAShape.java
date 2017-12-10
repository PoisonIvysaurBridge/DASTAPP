import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingAShape extends JPanel implements ActionListener
{
	int x,
		y,
		velX,
		velY;
	
	public DrawingAShape() 
	{
		x = 200; 
		y = 200;
		velX = 2;
		velY = 2;
		Timer tm = new Timer(8, this);	// GUI version of the sleep method
		tm.start();	// invokes action listener here
	}
	
	public void paintComponent(Graphics g)
	{
	//	super.paintComponent(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(x, y, 12, 12);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (x > 350)
		{
			velX = -velX;
			velY = -1;
		}
		if(x < 150)
		{
			velY = 2;
		}
		if(x < 150)
		{
			velY = 2;
		}
		x = x + velX;
		y = y + velY;
		repaint();
	}
	
	public static void main(String [] args)
	{
		DrawingAShape appPnl = new DrawingAShape();
		JFrame jf = new JFrame();
		jf.setTitle("drawing a shape");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.add(appPnl);
		jf.setVisible(true);
	}
}
