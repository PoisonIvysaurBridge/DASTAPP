package Vehicle;

public class Jeepney extends Vehicle implements Public
{
	public Jeepney()
	{
		super(20);
	}

	@Override
	public double computeFair(int d) 
	{
		double fare = 0;
		if(d <= 4)
		{
			fare = 7;
		}
		else if(d > 4)
		{
			fare = 7 + (d - 7) * 1;
		}
		return fare;
	}
}
