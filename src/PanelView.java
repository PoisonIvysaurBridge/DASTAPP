import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class PanelView extends JPanel implements ActionListener
{
	Polygon p;
	int steps;
	private JTextField tf;
	Timer tm;
	private ArrayList<PointXY> vertex;
	
	int velX,
		velY,
		x ,
		y,
		a,
		b,
		c,
		i;
	
	public PanelView (Polygon p, int steps, JTextField tf)
	{
		this.p = p;
		this.steps = steps;
		this.tf = tf;
		tm = new Timer(400, this);
		vertex = new ArrayList <PointXY> ();
		tm.start();
		a = 1;
		b = 0;
		c = 1;
		i = 1;
	}
	
	public void addPoint (PointXY p)
	{
		vertex.add (p);
	}
	
	public void paint (Graphics g)
	{
	//	super.paint(g);
		while(p.getVertexAt(i) != null)
		{
			g.setColor(Color.BLUE);	
			g.drawLine(p.getVertexAt(i-1).getX(), p.getVertexAt(i-1).getY(), p.getVertexAt(i).getX(), p.getVertexAt(i).getY());
			i++;
		}
		if (a < steps * i && p.getVertexAt(b + 1)!= null)
		{
			g.setColor(Color.RED);
			velX = (p.getVertexAt(b+1).getX() - p.getVertexAt(b).getX()) / steps;
			velY = (p.getVertexAt(b+1).getY() - p.getVertexAt(b).getY()) / steps;
			if (a % steps != 1)
			{
				x += velX;
				y += velY;
				g.drawRect(x-4, y-4, 8, 8);
				
				if(a / c == steps)
				{
					b++;
					c++;
				}
			}
			else	// rects in  vertices
			{
				x = p.getVertexAt(b).getX();
				y = p.getVertexAt(b).getY();
				g.drawRect(x, y, 5, 5);
			}
			
			tf.setText(x + ", " + y);
			a++;
		}
	}
	
	public void actionPerformed (ActionEvent e)
	{
		repaint();
	}

}
