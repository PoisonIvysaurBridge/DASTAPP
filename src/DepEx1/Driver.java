// Ivana Lim Terminal 2
package DepEx1;

import java.util.ArrayList;

public class Driver 
{
	public static void main(String[] args)
	{
		BankAccount one = new BankAccount(1234, 5000);
		BankAccount two = new BankAccount(2468, 10000);
		BankAccount three = new BankAccount(3579, 8000);
		
		ArrayList<BankAccount> bankAccts = new ArrayList<>();
		bankAccts.add(one);
		bankAccts.add(two);
		bankAccts.add(three);
		
		ArrayList<BankTransaction> bankTrans = new ArrayList<>();
		bankTrans.add(new Deposit(one, 5000));
		bankTrans.add(new Deposit(three, 888));
		
		bankTrans.add(new Withdrawal(two, 2000));
		bankTrans.add(new BalanceInquiry(three));
		
		bankTrans.add(new Withdrawal(one, 5550));
		bankTrans.add(new BalanceInquiry(one));
		
		bankTrans.add(new Withdrawal(one, 5555));
		bankTrans.add(new BalanceInquiry(one));
		
		bankTrans.add(new BalanceInquiry(two));
		bankTrans.add(new BalanceInquiry(three));
		
		for(int i = 0; i < bankTrans.size(); i++)
		{
			bankTrans.get(i).execute();
		}
	}
}
