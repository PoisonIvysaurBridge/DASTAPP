package Vehicle;

public class Bus extends Vehicle implements Public
{
	public Bus()
	{
		super(30);
	}

	@Override
	public double computeFair(int distance) 
	{
		return 30;
	}
}
