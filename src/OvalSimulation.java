import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;

public class OvalSimulation extends JPanel implements ActionListener, KeyListener
{
	Timer tm = new Timer(5, this);	// GUI version of the sleep method
	int x = 0, velX = 0;
	int y = 0, velY = 0;
	BufferedImage img;
	
	public OvalSimulation()
	{
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);	// wont use shift and tab keys so false 
		try
		{
			img = ImageIO.read(new File("res/Images/Zoro right.png"));
		} 
		catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Image loading error");
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.GREEN);
	//	g.fillOval(x, y, 50, 30);
		g.drawImage(img, x, y, 50, 50, null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(x < 0)
		{
			velX = 0;
			x = 0;
		//	x = 500;
		}
		
		if(x > 450)
		{
			velX = 0;
			x = 450;
		//	x = 0;
		}
		
		if(y < 0)
		{
			velY = 0;
			y = 0;
		}
		
		if(y > 450)
		{
			velY = 0;
			y = 450;
		}
		
		x += velX;
		y += velY;
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("u pressed a key");
		int c = e.getKeyCode(); //gets the code of the key pressed
		
		if(c == KeyEvent.VK_LEFT)
		{
			velX = -1;
			velY = 0;
			try{
				img = ImageIO.read(new File("res/Images/Zoro left.png"));
			} 
			catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Image loading error");
			}
		}
		
		if(c == KeyEvent.VK_UP)
		{
			velX = 0;
			velY = -1;
			try{
				img = ImageIO.read(new File("res/Images/Zoro left.png"));
			} 
			catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Image loading error");
			}
		}
		
		if(c == KeyEvent.VK_RIGHT)
		{
			velX = 1;
			velY = 0;
			try{
				img = ImageIO.read(new File("res/Images/Zoro right.png"));
			} 
			catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Image loading error");
			}
		}
		
		if(c == KeyEvent.VK_DOWN)
		{
			velX = 0;
			velY = 1;
			try{
				img = ImageIO.read(new File("res/Images/Zoro right.png"));
			} 
			catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, "Image loading error");
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		velX = 0;
		velY = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	public static void main(String [] args)
	{
		OvalSimulation appPnl = new OvalSimulation();
		JFrame jf = new JFrame();
		jf.setTitle("Animation 101");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.add(appPnl);
		jf.setVisible(true);
	}

	
}
