import javax.swing.*;
import java.awt.*;

public class Circle extends Shape
{
	@Override
	public void draw(int x, int y, int width, int height,Graphics g)
	{
		super.draw(100, 100, 50, 50, g);
		g.setColor(Color.RED);
		g.drawOval(x, y, width, height);
		g.drawString("I'm a Circle!", x, y);
	}
}
