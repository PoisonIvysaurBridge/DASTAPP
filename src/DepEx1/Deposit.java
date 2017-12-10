// Ivana Lim Terminal 2
package DepEx1;

public class Deposit extends BankTransaction 
{
	private double amount;
	
	public Deposit(BankAccount acct, double amt) 
	{
		super(acct);
		amount = amt;
	}
	
	@Override
	public void execute() 
	{
		bankaccount.credit(amount);
	}

}
