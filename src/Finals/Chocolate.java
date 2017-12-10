package Finals;
// Lim, Ivana #2
public class Chocolate extends Candy
{
	private double price;
	
	public Chocolate(String name, double sugarLvl) 
	{
		super(name, sugarLvl);
		price = getPrice();
	}
	
	@Override
	public double getPrice() 
	{
		double price = sugarLvl * 2;
		return price;
	}

}
