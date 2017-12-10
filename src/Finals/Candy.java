package Finals;
// Lim, Ivana #2
public abstract class Candy 
{
	protected String name;
	protected double sugarLvl;
	
	public Candy(String name, double sugarLvl)
	{
		this.name = name;
		this.sugarLvl = sugarLvl;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getSugarLvl()
	{
		return this.sugarLvl;
	}
	
	public abstract double getPrice();

}
