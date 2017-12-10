import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener
{
	Timer tm;
	int x,
		y,
		velX,
		velY;
	
	public SnakeGame()
	{
		x = 200;
		y = 200;
		velX = 2;
		velY = 2;
		tm = new Timer(5, this);
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.green);
		g.fillOval(x, y, 50, 30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (x < -50)
		{
			x = 500;
		}
		
		if (x > 500)
		{
			x = 0;
		}
		
		if (y < -30)
		{
			y = 500;
		}
		
		if (y > 500)
		{
			y = 0;
		}
		
		x += velX;
		y += velY;
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		int c = e.getKeyCode();
		
		if (c == KeyEvent.VK_LEFT)
		{
			velX = -1;
			velY = 0;
		}
		
		if (c == KeyEvent.VK_RIGHT)
		{
			velX = 1;
			velY = 0;
		}
		
		if (c == KeyEvent.VK_UP)
		{
			velX = 0;
			velY = -1;
		}
		
		if (c == KeyEvent.VK_DOWN)
		{
			velX = 0;
			velY = 1;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		SnakeGame app = new SnakeGame();
		JFrame jf = new JFrame("Snake Game");
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.add(app);
		jf.setVisible(true);
		
	}

}
