// Ivana Lim Terminal 2
package DepEx1;

public class Withdrawal extends BankTransaction 
{
	private double amount;
	
	public Withdrawal(BankAccount acct, double amt) 
	{
		super(acct);
		amount = amt;
	}
	
	@Override
	public void execute() 
	{
		boolean isDebited = bankaccount.debit(amount);
		if(!isDebited)
		{
			System.out.println("Not enough funds");
		}
	}

}
