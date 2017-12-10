import javax.swing.*;
import java.awt.*;

public class Rectangle extends Shape
{
	@Override
	public void draw(int x, int y, int width, int height, Graphics g)
	{
		super.draw(100, 100, 50, 50, g);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
		g.drawString("I'm a Rect!", x, y);
	}
}
