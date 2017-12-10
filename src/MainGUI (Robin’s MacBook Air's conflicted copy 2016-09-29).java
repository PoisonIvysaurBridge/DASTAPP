import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame implements ActionListener
{
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfSteps;
	private JTextArea taPoints;
	private JTextField tfStatus;
	
	private Polygon poly;
	
	public MainGUI ()
	{
		poly = new Polygon ();
		
		setLayout (new BorderLayout ());
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setSize (700, 750);
		initSettingsPanel ();
		setVisible (true);
	}
	
	public void initSettingsPanel ()
	{
		JPanel northPanel = new JPanel ();
		northPanel.setLayout (new BorderLayout ());

		JPanel one = new JPanel ();
		
		one.setLayout (new BorderLayout ());
		one.add (new JLabel ("Vertices"), BorderLayout.NORTH);
		
		JButton btn = new JButton ("Add");
		one.add (btn, BorderLayout.SOUTH);
		btn.addActionListener (this);
		
		
		JPanel panel = new JPanel ();
		JPanel cPanel = new JPanel ();
		cPanel.setLayout (new GridLayout (0, 1));
		panel.add (new JLabel ("X:  "));
		tfX = new JTextField (5);
		tfX.setHorizontalAlignment (JTextField.RIGHT);
		panel.add (tfX);
		cPanel.add (panel);
		panel = new JPanel ();
		panel.add (new JLabel ("Y:  "));
		tfY = new JTextField (5);
		tfY.setHorizontalAlignment (JTextField.RIGHT);
		panel.add (tfY);
		cPanel.add (panel);
		one.add (cPanel, BorderLayout.CENTER);
		
		taPoints = new JTextArea ();
		taPoints.setEditable (false);
		JScrollPane scroll = new JScrollPane (taPoints);
		northPanel.add (scroll, BorderLayout.CENTER);
		
		northPanel.add (one, BorderLayout.WEST);
		
		JPanel ePanel = new JPanel ();
		ePanel.setLayout (new BorderLayout ());
		one = new JPanel ();
		one.add (new JLabel ("Steps:  "));
		tfSteps = new JTextField (5);
		tfSteps.setHorizontalAlignment (JTextField.RIGHT);
		tfSteps.setText ("10");
		one.add (tfSteps);
		ePanel.add (one, BorderLayout.NORTH);
		
		btn = new JButton ("Draw");
		btn.addActionListener (this);
		ePanel.add (btn, BorderLayout.CENTER);
		northPanel.add (ePanel, BorderLayout.EAST);

		add (northPanel, BorderLayout.NORTH);
		
		tfStatus = new JTextField (20);
		tfStatus.setEditable (false);
		add (tfStatus, BorderLayout.SOUTH);
	}
	
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getActionCommand ().equals ("Add"))
		{
			if (!tfX.getText ().equals ("") && !tfY.getText ().equals (""))
			{
				int x = Integer.parseInt (tfX.getText ().trim ());
				int y = Integer.parseInt (tfY.getText ().trim ());
				poly.addPoint (new PointXY (x, y));
			
				tfX.setText ("");
				tfY.setText ("");
				taPoints.setText (poly.toString ());
			}
		}
		else if (e.getActionCommand ().equals ("Draw" ))
		{
			if (tfSteps.getText ().equals (""))
				tfSteps.setText ("10");
			int steps = Integer.parseInt (tfSteps.getText ().trim ());
		//	PanelViewIco pv = new PanelViewIco (poly, steps, tfStatus);
			PanelView pv = new PanelView (poly, steps, tfStatus);
		//	PnlView pv = new PnlView(poly, steps, tfStatus);
			add (pv, BorderLayout.CENTER);
			pv.updateUI();
		}
	}
	
	public static void main (String[] args)
	{
		MainGUI app = new MainGUI ();
	}
}