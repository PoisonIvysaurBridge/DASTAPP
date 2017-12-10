import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Animation extends JPanel implements ActionListener
{
	private int x;
	private int y;
	private int mult;
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	
	public Animation()
	{
		x = 0;
		y = 0;
		mult = 1;
		Timer t = new Timer(50, this);
		t.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g); // repaints everything, should always be the first statement
		x += mult*10;
		y += mult*10;
		if(x < 0 || x > 430)
			mult *= -1;
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 50, 50);
	}
	
	public static void main(String [] args)
	{
		JFrame f = new JFrame("Animation");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		Animation app = new Animation();
		f.add(app);
		f.setVisible(true);
	}
}
