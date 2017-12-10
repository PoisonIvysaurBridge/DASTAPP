package DepEx2;

public class VBNDriver
{
	public static void main (String[] args)
	{
		VeryBigNumber op1;
		VeryBigNumber op2;
		
		VeryBigNumber result;
		
		int j, digits = 25;
		op1 = new VeryBigNumber ("123498723432");
		op2 = new VeryBigNumber ("9999999999999999");
		result = op1.add (op2);
		
		System.out.println ("Sample 1");
		op1.displayStack (digits);
		op2.displayStack (digits);
		for (j = 0; j < digits + 5; j++)
			System.out.print ("-");
		System.out.println ();
		result.displayStack (digits);

	
		digits = 50;
		op1 = new VeryBigNumber ("9876789876899238712938172312324234324");
		op2 = new VeryBigNumber ("21948127439284329583254032841203918243298432");
		result = op1.add (op2);

		System.out.println ("\nSample 2");
		op1.displayStack (digits);
		op2.displayStack (digits);
		for (j = 0; j < digits + 5; j++)
			System.out.print ("-");
		System.out.println ();
		result.displayStack (digits);
	/*	
		op1 = new VeryBigNumber("15");
		op2 = new VeryBigNumber("15");
		result = op1.add(op2);
		System.out.println("TEST 35 + 46 = 81");
	//	System.out.println(result);
		result.displayStack(2);*/
	}
}
