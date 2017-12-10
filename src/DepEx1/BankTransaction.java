// Ivana Lim Terminal 2
package DepEx1;

public abstract class BankTransaction 
{
	protected BankAccount bankaccount;
	
	public BankTransaction(BankAccount acct)
	{
		bankaccount = acct;
	}
	
	public abstract void execute();
}
