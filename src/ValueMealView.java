import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ValueMealView extends JFrame implements ActionListener, ListSelectionListener, ItemListener
{
	private ArrayList<FoodItem> foodItems;
	private ArrayList<ValueMeal> valMeals;	
	
	private JPanel mainPnl;
	private JTextField FItfName,
					   FItfPrice,
					   tfValMeal;
	private JTextArea foodDetails,
					  mealDetails;
	//private JButton btnMeal;
	private JList foodList;
	private JComboBox cbValMeals;
	private boolean isCreateFud;
	
	public ValueMealView()
	{
		super("Food Menu Settings");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 450);
		setLocationRelativeTo(null);
		foodItems = new ArrayList<>();
		valMeals = new ArrayList<>();
		isCreateFud = true;
		initView();
		setVisible(true);
	}
	
	public void initView()
	{
		JPanel OptionsPnl = new JPanel();
		add(OptionsPnl, BorderLayout.WEST);
		
		JPanel pnl = new JPanel(new GridLayout(3,1,5,5));
		
		JLabel lbl = new JLabel("Menu");
		lbl.setFont(new Font("GoudyStout", NORMAL, 20));
		lbl.setHorizontalAlignment(JLabel.CENTER);
		pnl.add(lbl);
		
		JButton btn = new JButton("Create Food Item");
		btn.addActionListener(this);
		pnl.add(btn);
		
		btn = new JButton("Create Value Meal");
		//btn.setEnabled(false);
		btn.addActionListener(this);
		pnl.add(btn);
		
		OptionsPnl.add(pnl);
		
		mainPnl = new JPanel();
		pnl = new JPanel(new BorderLayout());
		lbl = new JLabel("     ");
		lbl.setFont(new Font("Jokerman", NORMAL, 48));
		pnl.add(lbl,BorderLayout.NORTH);
		
		lbl = new JLabel("WELCOME");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("Jokerman", NORMAL, 48));
		pnl.add(lbl, BorderLayout.CENTER);
		mainPnl.add(pnl);
		add(mainPnl, BorderLayout.CENTER);
		
		//createFood();
	}
	
	public void createFood()
	{
		JLabel lbl = new JLabel("Add Food Item");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(new Font("Arial", NORMAL, 36));
		mainPnl.add(lbl);
		
		JPanel pnl = new JPanel(new GridLayout(5,2,5,5));
		lbl = new JLabel("Enter name: ");
		pnl.add(lbl);
		
		FItfName = new JTextField(20);
		pnl.add(FItfName);
		
		lbl = new JLabel("Enter price: ");
		pnl.add(lbl);
		
		FItfPrice = new JTextField(20);
		pnl.add(FItfPrice);
		
		lbl = new JLabel("   	");pnl.add(lbl);
		
		JButton btn = new JButton("Create Food!");
		btn.addActionListener(this);
		pnl.add(btn);
		
		lbl = new JLabel("Food Items:");
		pnl.add(lbl);
		
		lbl = new JLabel("Food Details:");
		pnl.add(lbl);
		
		JPanel pnl2 = new JPanel();
		pnl2.setLayout(new GridLayout(1,2,5,5));
		
		foodList = new JList(foodItems.toArray());
		foodList.addListSelectionListener(this);
		JScrollPane sp = new JScrollPane(foodList);
		pnl2.add(sp);
		
		foodDetails = new JTextArea(10,15);
		foodDetails.setEditable(false);
		sp = new JScrollPane(foodDetails);
		pnl2.add(sp);
		
		mainPnl.add(pnl);
		mainPnl.add(pnl2);
	}
	
	public void createMeal()
	{
		JLabel lbl = new JLabel("Value Meal Selection");
		lbl.setFont(new Font("Goudystout", NORMAL, 36));
		lbl.setHorizontalAlignment(JLabel.CENTER);
		mainPnl.add(lbl, BorderLayout.NORTH);
		
		JPanel pnl0 = new JPanel(new GridLayout(1,2,5,5));
		
		JPanel pnlLeft = new JPanel(new BorderLayout());
		lbl = new JLabel("Food Items:");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		pnlLeft.add(lbl,BorderLayout.NORTH);
		
		JScrollPane sp = new JScrollPane(foodList);
		pnlLeft.add(sp);
		
		JPanel pnlBtn = new JPanel(new BorderLayout());
		lbl = new JLabel("New Value Meal Name: ");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		pnlBtn.add(lbl,BorderLayout.NORTH);
		tfValMeal = new JTextField(20);
		pnlBtn.add(tfValMeal,BorderLayout.CENTER);
		JButton btn = new JButton("Create Meal!");
		btn.addActionListener(this);
		pnlBtn.add(btn,BorderLayout.SOUTH);
		
		pnlLeft.add(pnlBtn, BorderLayout.SOUTH);
		
		JPanel pnlRyt = new JPanel(new BorderLayout());
		lbl = new JLabel("Value Meals:");
		pnlRyt.add(lbl,BorderLayout.NORTH);
		
		cbValMeals = new JComboBox(valMeals.toArray());
		cbValMeals.addItemListener(this);
		pnlRyt.add(cbValMeals,BorderLayout.CENTER);
		
		mealDetails = new JTextArea(15,15);
		mealDetails.setEditable(false);
		sp = new JScrollPane(mealDetails);
		pnlRyt.add(sp,BorderLayout.SOUTH);
		
		pnl0.add(pnlLeft);
		pnl0.add(pnlRyt);
		mainPnl.add(pnl0);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Create Food Item"))
		{
			isCreateFud = true;
			mainPnl.removeAll();
			createFood();
			mainPnl.updateUI();
		}
		
		else if (e.getActionCommand().equals("Create Food!"))
		{
			if (FItfName.getText().equals("") || FItfPrice.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Incomplete inputs.");
			}
			else
			{
				FoodItem food = new FoodItem(FItfName.getText(), Integer.parseInt(FItfPrice.getText()));
				foodItems.add(food);
				foodList.setListData (foodItems.toArray ());
				FItfName.setText("");
				FItfPrice.setText("");
				//btnMeal.setEnabled(true);
			}
		}
		
		else if (e.getActionCommand().equals("Create Value Meal"))
		{
			isCreateFud = false;
			mainPnl.removeAll();
			createMeal();
			mainPnl.updateUI();
		}
		else if(e.getActionCommand().equals("Create Meal!"))
		{
			if(tfValMeal.getText().equals("") || foodList.getSelectedIndex() == -1)
			{
				JOptionPane.showMessageDialog(null, "Incomplete inputs.");
			}
			else
			{
				int[] foodListIndices = foodList.getSelectedIndices();
				ArrayList<FoodItem> f = new ArrayList<>();
				for(int i = 0;  i < foodListIndices.length; i++)
				{
					f.add(foodItems.get(foodListIndices[i]));
				}
				ValueMeal meal = new ValueMeal(tfValMeal.getText(), f);
				valMeals.add(meal);
				cbValMeals.addItem(meal);	// JComboBox counterpart of setListData in JList
			//	mainPnl.updateUI();
				//cbValMeals.setSelectedIndex(0);;
			}
		}
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if(isCreateFud) 
		{
			int i = foodList.getSelectedIndex();
			if (i != -1)
			{
				foodDetails.setText("Food Item Name: "+foodItems.get(i).getName() + "\nPrice: "+foodItems.get(i).getPrice() );
			}
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		int vm = cbValMeals.getSelectedIndex();
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < valMeals.get(vm).getFoodItems().size(); i++)
		{
			s.append(valMeals.get(vm).getFoodItems().get(i).getName()+"\t"+"Price: "+valMeals.get(vm).getFoodItems().get(i).getPrice()+"\n");
		}
		mealDetails.setText("Value Meal Name: "+valMeals.get(vm).getName()+"\n"+s+"TOTAL PRICE (less 5% dicount): "+valMeals.get(vm).getPrice());
		
	}
	
	public static void main(String [] args)
	{
		ValueMealView app = new ValueMealView();
	}
}
