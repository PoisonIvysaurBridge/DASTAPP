package InheritEx;

public class Driver 
{
	public static void main(String[] args)
	{
		Teller tPedro = new Teller("Pedro", "M421", 3);
		Teller tJuan = new Teller("Juan", "J409", 2);
		Teller tJuanita = new Teller("Juanita", "L442", 4);
		Teller tPedrita = new Teller("Pedrita", "PD112", 3);
		Teller tJojo = new Teller("Jojo", "PP492", 1);
		
		Manager mMarco = new Manager("Marco", "MC113", 5);
		mMarco.addEmployee(tPedro);
		mMarco.addEmployee(tPedrita);
		
		Manager mLola = new Manager("Lola", "LP322", 6);
		mLola.addEmployee(tJuan);
		mLola.addEmployee(tJuanita);
		mLola.addEmployee(tJojo);
		
		Company cBBO = new Company("BBO");
		cBBO.addEmployee(mMarco);
		cBBO.addEmployee(tPedro);
		cBBO.addEmployee(tPedrita);
		System.out.println("BBO Company\n----------------------------");
		System.out.println("All Employees:");
		cBBO.showAllEmployees();
		System.out.println("All Tellers:");
		cBBO.showAllTellers();
		System.out.println("All Managers:");
		cBBO.showAllManagers();
		
		Company cPPI = new Company("PPI");
		cPPI.addEmployee(mLola);
		cPPI.addEmployee(tJuan);
		cPPI.addEmployee(tJuanita);
		cPPI.addEmployee(tJojo);
		System.out.println("PPI Company\n----------------------------");
		System.out.println("All Employees:");
		cPPI.showAllEmployees();
		System.out.println("All Tellers:");
		cPPI.showAllTellers();
		System.out.println("All Managers:");
		cPPI.showAllManagers();
		
	}
}
