// Ivana Lim
import java.util.*;

public class Postfix 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("enter op: ");
		String op = sc.nextLine();
		String postfix = "";
		Stack stack = new Stack();
		Stack stack2 = new Stack();
		double operand = 0;
		//Queue calcu = new Queue();
		Stack stack3 = new Stack();
		Stack reversed = new Stack();
		for(int i = 0; i < op.length(); i++)
		{
			char c = op.charAt(i);
			if(c == '*' || c == '/' || c == '+' || c == '-')
			{
				//calcu.enqueue(operand);
				stack3.push(operand);
				operand = 0;
				String s = "" + c;
				switch(s)
				{
					case "*": 
					case "/": s = "1"; break;
					case "+": 
					case "-": s = "0"; break;
				}
				
				while(!stack.isEmpty() && Integer.parseInt(s) <= Integer.parseInt((String)stack.peek()))
				{
					postfix += stack2.peek();
					stack3.push(""+stack2.pop());
				//	calcu.enqueue(stack2.pop());
					stack.pop();
				}
				stack.push(s);	//1
				stack2.push(c);	//*
			}
			else
			{
				postfix += c;
				operand = operand * 10 + Integer.parseInt(""+c);
			}
		}
		//calcu.enqueue(operand);
		stack3.push(operand);
		while(stack2.isEmpty() == false)
		{
			postfix += stack2.peek();
			stack3.push(""+stack2.pop());
		//	calcu.enqueue(stack2.pop());
		}
		System.out.println(postfix);
	
		while(!stack3.isEmpty())
			reversed.push(stack3.pop());
	//	while(!reversed.isEmpty())	// check
	//		System.out.print(reversed.pop());
			
		// EVALUATION
	//12/4/15+2-4/53*5+3
	// 124/15/2+453/5*-3+	
		stack = new Stack();
		stack2 = new Stack();
		while(!reversed.isEmpty())
		{
			System.out.println("top of reversed stack: "+reversed.peek());
			if((reversed.peek()).equals("*") || (reversed.peek()).equals("/") || (reversed.peek()).equals("+") || (reversed.peek()).equals("-"))
			{
			//	System.out.println("right: "+stack.peek());
				double right = (double)stack.pop();
			//	System.out.println("left: "+stack.peek());
				double left = (double)stack.pop();
				switch((String)reversed.peek())
				{
					case "/": System.out.println(left+""+reversed.pop()+right+" = "+(left*1.0/right));stack.push(left*1.0/right); break;
					case "*": System.out.println(left+""+reversed.pop()+right+" = "+(left*1.0*right));stack.push(left*1.0*right); break;
					case "+": System.out.println(left+""+reversed.pop()+right+" = "+(left*1.0+right));stack.push(left*1.0+right); break;
					case "-": System.out.println(left+""+reversed.pop()+right+" = "+(left*1.0-right));stack.push(left*1.0-right); break;
				}
			}
			else
			{
			//	System.out.println("stack gets: "+reversed.peek());
				stack.push(reversed.pop());
			}
		}
		System.out.println("= "+stack.peek());
	}
}