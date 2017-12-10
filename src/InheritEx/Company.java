package InheritEx;

import java.util.ArrayList;

public class Company 
{
	protected String name;
	protected ArrayList<Employee> employees;
	
	public Company(String name)
	{
		this.name = name;
		employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee e)
	{
		employees.add(e);
	}
	
	public void showAllEmployees()
	{
		for(int i = 0; i < employees.size(); i++)
		{
			System.out.println("Name: "+employees.get(i).getName());
			System.out.println("ID: "+employees.get(i).getId());
			System.out.println("Years Worked: "+employees.get(i).getYrsWorked());
			System.out.println("Salary: "+employees.get(i).getSalary()+"\n");
		}
	}
	
	public void showAllTellers()
	{
		for(int i = 0; i < employees.size(); i++)
		{
			if(employees.get(i) instanceof Teller)
			{
				System.out.println("Name: "+employees.get(i).getName());
				System.out.println("ID: "+employees.get(i).getId());
				System.out.println("Years Worked: "+employees.get(i).getYrsWorked());
				System.out.println("Salary: "+employees.get(i).getSalary()+"\n");
			}
		}
	}
	
	public void showAllManagers()
	{
		for(int i = 0; i < employees.size(); i++)
		{
			if(employees.get(i) instanceof Manager)
			{
				System.out.println("Name: "+employees.get(i).getName());
				System.out.println("ID: "+employees.get(i).getId());
				System.out.println("Years Worked: "+employees.get(i).getYrsWorked());
				System.out.println("Salary: "+employees.get(i).getSalary()+"\n");
			}
			
		}
	}
}
