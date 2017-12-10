import java.awt.event.*;
import javax.swing.*;
public class TimerListener implements ActionListener
{
	JPanel pnl;
	public TimerListener(JPanel r)
	{
		pnl = r;
	}
	public void actionPerformed(ActionEvent e)
	{
		pnl.repaint();
	}
}
