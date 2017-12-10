import java.util.ArrayList;

public class ValueMeal 
{
	private String name;
	private ArrayList<FoodItem> foodItems;
	
	public ValueMeal(String name, ArrayList<FoodItem> foods)
	{
		this.name = name;
		this.foodItems = foods;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<FoodItem> getFoodItems()
	{
		return foodItems;
	}
	
	public double getPrice()
	{
		double total = 0;
		for(FoodItem i : foodItems)
		{
			total += i.getPrice();
		}
		total = total*0.95*100;
		return (int)total /100;
	}
	@Override
	public String toString()
	{
		return name;
	}
}
