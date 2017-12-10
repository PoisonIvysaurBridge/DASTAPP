
public class Janitor extends Employee
{
	private double hrlyRate;
	private double hrsWorked;
	
	public Janitor(double hrlyRate, double hrsWorked)
	{
	//	super();
		this.hrlyRate = hrlyRate;
		this.hrsWorked = hrsWorked;
	}
	@Override
	public double computeSal()
	{
		sal = hrlyRate * hrsWorked;
		return super.computeSal();
	}
}
