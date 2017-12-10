public class Employee 
{
	protected double sal;
	
	public Employee()
	{
		
	}
	public Employee(double sal)
	{
		this.sal = sal;
	}
	
	public double computeSal()	// serves as a getter
	{
		sal -= computeTax();
		return sal;
	}
	public void setSal(double sal)
	{
		this.sal = sal;
	}
	public double computeTax()
	{
		double tax = 0;
		if (sal > 3200)
		{
			tax = 3200 * 0.05 + (sal - 3200) * 0.1;
		}
		else
		{
			return sal * 0.05;
		}
		return tax;
	}
}
