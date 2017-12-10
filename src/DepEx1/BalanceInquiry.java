// Ivana Lim Terminal 2
package DepEx1;

public class BalanceInquiry extends BankTransaction 
{

	public BalanceInquiry(BankAccount acct) 
	{
		super(acct);
	}
	
	@Override
	public void execute() 
	{
		System.out.println("Account balance: " + bankaccount.getBalance());
	}

}
