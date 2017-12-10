import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RandomColorPanel extends JPanel implements MouseListener
{
	public RandomColorPanel()
	{
		setBackground(randomColor());
		addMouseListener(this);
	}
	
	public Color randomColor()
	{
		int red = (int) (Math.random()*256);
		int blue = (int) (Math.random()*256);
		int green = (int) (Math.random()*256);
		return new Color(red, blue, green);
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		setBackground(randomColor());
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String [] args)
	{
		int x = 18;
		JFrame jf = new JFrame();
		jf.setTitle("Random Color Panels");
		 jf.setSize(300,300);
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setLocationRelativeTo(null);
		 jf.setLayout(new GridLayout(x,x));
		 for (int i = 0; i < x*x; i++)
		 {
			 RandomColorPanel panel = new RandomColorPanel();
			 jf.add(panel);
		 }
		 
		 jf.setVisible(true);
	}
}
