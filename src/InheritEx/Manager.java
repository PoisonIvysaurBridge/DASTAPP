package InheritEx;

import java.util.ArrayList;

public class Manager extends Employee
{
	private ArrayList<Employee> handledEmployees;
	
	public Manager(String name, String id, int years)
	{
		super (name, id, years);
		handledEmployees = new ArrayList<>();
	}
	
	public double getSalary()
	{
		return yearsWorked * 300 * handledEmployees.size();
	}
	
	public void addEmployee(Employee e)
	{
		handledEmployees.add(e);
	}
}
