public class Lawyer extends Employee
{
	private double consulFee;
	private double hrsWorked;
	
	public Lawyer(double consulFee, double hrsWorked)
	{
	//	super();
		this.consulFee = consulFee;
		this.hrsWorked = hrsWorked;
	}
	@Override
	public double computeSal()
	{
		sal = consulFee * hrsWorked;
		return super.computeSal(); 
	}

}