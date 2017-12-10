import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class PnlView extends JPanel implements ActionListener
{
	Polygon p;
	int steps;
	private JTextField tf;
	Timer tm;
	int nLines,
		nRects,
		pts;
	
	public PnlView (Polygon p, int steps, JTextField tf)
	{
		this.p = p;
		this.steps = steps;
		this.tf = tf;
		nLines = 0;
		nRects = 0;
		pts = 0;
		while(p.getVertexAt(pts) != null)
		{
			pts++;
		}
		tm = new Timer(400, this);
		tm.start();
	}
	
	public void paint (Graphics g)
	{
		super.paint(g);
		System.out.println("in paint method");
	// ######################################## POLYGON #######################################################	
		g.setColor(Color.BLUE);	
		int i = 0;
		while(p.getVertexAt(i+1) != null)
		{
			g.drawLine(p.getVertexAt(i).getX(), p.getVertexAt(i).getY(), p.getVertexAt(i+1).getX(), p.getVertexAt(i+1).getY());
			i++;
		}
	// ########################################## RECTS ########################################################	
		g.setColor(Color.gray);
		for(i = 0; i < nRects; i++)
		{
			int x0 = p.getVertexAt(nLines).getX();
			int y0 = p.getVertexAt(nLines).getY();
			int x1 = p.getVertexAt(nLines+1).getX();
			int y1 = p.getVertexAt(nLines+1).getY();
			int dx = (x0 - x1) / steps * i;
			int dy = (y0 - y1) / steps * i;
			int newX = x0 - dx;
			int newY = y0 - dy;
			tf.setText("(" + newX + "," + newY + ")");
			
			g.drawRect(newX-4, newY-4, 8, 8);
		}
		
		g.setColor(Color.red);
		for(i = 0; i < nLines; i++)
		{
			for(int j= 0; j < steps; j++)
			{
				int x0 = p.getVertexAt(i).getX();
				int y0 = p.getVertexAt(i).getY();
				int x1 = p.getVertexAt(i+1).getX();
				int y1 = p.getVertexAt(i+1).getY();
				int dx = (x0 - x1) / steps * j;
				int dy = (y0 - y1) / steps * j;
				int newX = x0 - dx;
				int newY = y0 - dy;
				
				g.drawRect(newX-4, newY-4, 8, 8);
			}
		}
	}
	
	public void actionPerformed (ActionEvent e)
	{
		if(nLines + 1 < pts)
		{
			if (nRects < steps)
			{
				nRects++;
			}
			else
			{
				nRects = 0;
				nLines++;
			}
		}
		
		repaint();
	}

}
