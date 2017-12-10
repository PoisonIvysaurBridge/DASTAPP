package Shaper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class ShapeGUI extends JFrame implements ActionListener
{
	private JButton button;
	private JTextField[] tfLengths;
	private JTextField[] tfResults;
	private JComboBox cmbShapes;
	private String[] shapes = {"Circle", "Triangle", "Rectangle"};
	private String[][] inputlabels = {	{"Radius: "},
										{"Side 1: ", "Side 2: ", "Side 3: "},
										{"Length: ", "Width: "}};
	private String[] results = {"Perimeter:  ", "Area:  "};
	private JPanel midPanel;
	private JPanel inputPanel;
	private int index;
	private Shape objShape;
	
	public ShapeGUI ()
	{
		super ("Shape - Abstract Class Activity");
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setLayout (new BorderLayout ());
		
		init ();
		setSize (600, 170);
		setResizable (false);
		setVisible (true);
	}
	
	public void init ()
	{
		JPanel panel = new JPanel ();
		panel.setLayout (new FlowLayout ());
		panel.add (new JLabel ("Select:  "));
		
		cmbShapes = new JComboBox (shapes);
		cmbShapes.addActionListener (this);
		panel.add (cmbShapes);
		add (panel, BorderLayout.NORTH);
		
		
		panel = new JPanel ();
		panel.setLayout (new GridLayout (0, 2));
		
		JPanel temp;
		tfResults = new JTextField[2];
		int j;
		for (j = 0; j < 2; j++)
		{
			temp = new JPanel ();
			temp.setLayout (new FlowLayout ());
			temp.add (new JLabel (results[j]));

			tfResults[j] = new JTextField (10);
			tfResults[j].setHorizontalAlignment (JTextField.RIGHT);
			tfResults[j].setEditable (false);
			temp.add (tfResults[j]);
			panel.add (temp);
		}
		
		add (panel, BorderLayout.SOUTH);
		
		
		midPanel = new JPanel ();
		midPanel.setLayout (new BorderLayout ());
		
		button = new JButton ("Create");
		button.addActionListener (this);
		midPanel.add (button, BorderLayout.SOUTH);
		
		add (midPanel, BorderLayout.CENTER);
		
		cmbShapes.setSelectedIndex (0);
		
	}
	
	
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource () == cmbShapes)
		{
			
			if (inputPanel != null)
				midPanel.remove (inputPanel);
			inputPanel = new JPanel ();
			inputPanel.setLayout (new GridLayout (0, 1));
			JPanel temp;
			index = cmbShapes.getSelectedIndex ();
			int j;
			
			
			if (shapes[index].equalsIgnoreCase ("Rectangle"))
			{
				setSize (600, 200);
			}
			else if (shapes[index].equalsIgnoreCase ("Circle"))
			{
				setSize (600, 170);
			}
			else if (shapes[index].equalsIgnoreCase ("Triangle"))
			{
				setSize (600, 230);
			}

			
			tfLengths = new JTextField[inputlabels[index].length];
			for (j = 0; j < inputlabels[index].length; j++)
			{
				temp = new JPanel ();
				tfLengths[j] = new JTextField (8);
				tfLengths[j].setHorizontalAlignment (JTextField.RIGHT);
				temp.add (new JLabel (inputlabels[index][j]));
				temp.add (tfLengths[j]);
				inputPanel.add (temp);
			}
			
			midPanel.add (inputPanel, BorderLayout.CENTER);
			inputPanel.updateUI ();

			
		}
		else if (e.getActionCommand ().equals ("Create"))
		{
			int j;
			boolean bFilled = true;
			ArrayList<Double> lengths = new ArrayList<> ();
			for (j = 0; j < tfLengths.length; j++)
				if (tfLengths[j].getText ().trim ().equals (""))
					bFilled = false;
				else
				{
					lengths.add (Double.parseDouble (tfLengths[j].getText ()));
					if (shapes[index].equalsIgnoreCase ("Rectangle"))
						lengths.add (Double.parseDouble (tfLengths[j].getText ()));
				}
			if (bFilled)
			{
				for (j = 0; j < tfLengths.length; j++)
					tfLengths[j].setEditable (false);
				if (shapes[index].equalsIgnoreCase ("Rectangle"))
				{
					objShape = new Rectangle (lengths);
				}
				else if (shapes[index].equalsIgnoreCase ("Circle"))
				{
					objShape = new Circle (lengths.get(0).doubleValue ());
				}
				else if (shapes[index].equalsIgnoreCase ("Triangle"))
				{
					objShape = new Rectangle (lengths);
				}
				System.out.println (lengths);
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(4);
				nf.setMinimumFractionDigits(4);
				tfResults[0].setText ((new Double (nf.format(objShape.getPerimeter ()))).toString ());
				tfResults[1].setText ((new Double (nf.format(objShape.getArea ()))).toString ());
				
				button.setText ("Reset");
				cmbShapes.setEnabled (false);
			}
		}
		else if (e.getActionCommand ().equals ("Reset"))
		{
			button.setText ("Create");
			cmbShapes.setEnabled (true);
			int j;
			for (j = 0; j < tfResults.length; j++)
				tfResults[j].setText ("");
			for (j = 0; j < tfLengths.length; j++)
			{
				tfLengths[j].setEditable (true);
				tfLengths[j].setText ("");
			}
			
			midPanel.remove (inputPanel);
			midPanel.updateUI ();
		}
	}
	
	public static void main (String[] args)
	{
		ShapeGUI app = new ShapeGUI ();
	}
}