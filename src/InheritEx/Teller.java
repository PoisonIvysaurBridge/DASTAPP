package InheritEx;

public class Teller extends Employee
{
	public Teller(String name, String id, int years)
	{
		super (name, id, years);
	}
	
	public double getSalary()
	{
		return yearsWorked * 500;
	}
}
