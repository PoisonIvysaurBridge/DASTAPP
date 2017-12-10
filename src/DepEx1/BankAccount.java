// Ivana Lim Terminal 2
package DepEx1;

public class BankAccount
{
	private int accountNo;
	private double balance;

	public BankAccount (int acctno, double amt)
	{
		accountNo = acctno;
		balance = amt;
	}

	public int getAccoutNumber ()
	{
		return accountNo;
	}

	public double getBalance ()
	{
		return balance;
	}

	public void credit (double amt)
	{
		balance += amt;	
	}

	public boolean debit (double amt)
	{
		if (amt > balance)
			return false;

		balance -= amt;	
		return true;
	}	
}