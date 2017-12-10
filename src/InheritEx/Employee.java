package InheritEx;

public abstract class Employee 
{
	protected String name;
	protected String id;
	protected int yearsWorked;
	
	public Employee(String name, String id, int years)
	{
		this.name = name;
		this.id = id;
		this.yearsWorked = years;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public int getYrsWorked()
	{
		return yearsWorked;
	}
	
	public abstract double getSalary();
	
}
