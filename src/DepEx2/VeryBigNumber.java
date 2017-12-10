package DepEx2;

// Ivana Lim #2
import java.util.*;

public class VeryBigNumber
{
	
	private Stack<Integer> number;		// each element is a digit of the number; topmost is the ones digit
	
	/* stores the numeric string to a stack, topmost is the ones digit */
	public VeryBigNumber (String val)
	{
		toStack (val);
	}
	
	/* assumes that the topmost is also the ones digit */
	public VeryBigNumber (Stack<Integer> val)
	{
		this.number = val;
	}
	
	/* converts the numeric string to stack, topmost is the ones digit */
	public void toStack (String val)
	{
		number = new Stack<> ();
		int j;
		
		for (j = 0; j < val.length (); j++)
		{
			number.push (Integer.parseInt (val.charAt (j) + ""));
		}
	}
	
	/* returns a copy of the stack */
	public Stack<Integer> getVeryBigNumber ()
	{
		return (Stack<Integer>) number.clone ();
	}
	
	/* returns the reverse of the stack */
	public Stack<Integer> reverseStack ()
	{
		Stack<Integer> temp = new Stack<> ();
		Stack<Integer> clone = (Stack<Integer>) number.clone ();
		
		while (!clone.empty ())
			temp.push (clone.pop ());
		
		return temp;
	}
	
	/* returns the reverse of the stack */
	public Stack<Integer> reverseStack (Stack<Integer> num)
	{
		Stack<Integer> temp = new Stack<> ();
		Stack<Integer> clone = (Stack<Integer>) num.clone ();
		
		while (!clone.empty ())
			temp.push (clone.pop ());
		
		return temp;
	}
	
	/* displays the contents of the stack, right aligned (based on the number of digits) */
	public void displayStack (int digits)
	{
		Stack<Integer> temp = reverseStack (getVeryBigNumber ());
		int j;
		
		int tempsize = temp.size ();
		
		for (j = 0; j < digits + 5 - tempsize; j++)
			System.out.print (" ");
			
		
		while (!temp.empty ())
			System.out.print (temp.pop ());
		System.out.println ();
	}
	
	/* TO DO:  COMPLETE THE CODE
	   This method adds this VeryBigNumber with the VeryBigNumber provided */
	public VeryBigNumber add (VeryBigNumber another)
	{
		Stack sum = new Stack<>();
		int carry = 0;
		Integer digit = 0;
		Stack<Integer> one = getVeryBigNumber();// one = this.number
		Stack<Integer> two = another.getVeryBigNumber();	// two = another.number
		while (!one.isEmpty() || !two.isEmpty())
		{
			digit += carry;
			if (!one.isEmpty())
				digit += one.pop();
			if (!two.isEmpty())
				digit += two.pop();
			
			carry = digit / 10;
			digit = digit % 10;
			sum.push(digit);
			digit = 0;
		}
		// reverse the sum stack
		if (carry > 0)
			sum.push(carry);
		sum = reverseStack(sum);
		
		VeryBigNumber result = new VeryBigNumber(sum);
		return result;
	}
}
