package Finals;
// Lim, Ivana #2
public class BubbleGum extends Candy
{
	private double price;
	
	public BubbleGum(String name, double sugarLvl) 
	{
		super(name, sugarLvl);
		price = getPrice();
	}
	@Override
	public double getPrice() 
	{
		double price = sugarLvl * 2.5;
		return price;
	}

}
