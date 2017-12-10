import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AnimationSample extends JPanel implements ActionListener
{
	int x,
		velX;
	public AnimationSample()
	{
		x = 0; 
		velX = 2;
		Timer tm = new Timer(8, this);	// GUI version of the sleep method
		tm.start();	// invokes action listener here
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.GRAY);
		g.fillOval(x, x, 50, 30);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (x < 0 || x > 450)
			velX = -velX;
		x = x + velX;
		repaint();
	}
	
	public static void main(String [] args)
	{
		AnimationSample appPnl = new AnimationSample();
		JFrame jf = new JFrame();
		jf.setTitle("Animation 101");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.add(appPnl);
		jf.setVisible(true);
	}
}
