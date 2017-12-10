import javax.swing.*;
import java.awt.*;

public class ShapeDriver extends JPanel
{
	private Shape[] shapes;
	private int count;
	
	public ShapeDriver()
	{
		shapes = new Shape[5];
		count = 0;
	}
	
	public void paint(Graphics g)
	{
		Shape s = new Shape();
	//	s.setColor(Color.DARK_GRAY);
	//	((Circle) s).draw(50, 50, 50, 50, g);
		Circle c = new Circle();
	//	c.setColor(Color.CYAN);
		c.draw(100, 200, 50, 50, g);
		Rectangle r = new Rectangle();
		r.draw(200, 200, 100, 100, g);
		
		int j;
		for(j = 0; j < shapes.length; j++)
		{
			if (shapes[j]!= null)
			{
				shapes[j].draw(20,20,20,20,g);
			}
		}
	}
	
	public void addShape (Shape s)
	{
		if (count < shapes.length)
		{
			shapes[count] = s;
			count++;
			repaint();
		}
	}
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		ShapeDriver app = new ShapeDriver();
		f.add(app);
		f.setVisible(true);
	}
}
