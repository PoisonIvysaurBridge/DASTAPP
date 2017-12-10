import javax.swing.*;
import java.awt.*;

public class Shape 
{
	protected int x,
				  y,
				  width,
				  height;
	protected Color color;
	
	public void draw(int x, int y, int width, int height, Graphics g)
	{
		if (color!=null)
			g.setColor(color);
	}
}
