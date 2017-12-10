package Finals;
// Lim, Ivana #2
import java.util.ArrayList;

public class MyStack {
	
	protected ArrayList <Integer> stack;
	
	public MyStack() {
		stack = new ArrayList <Integer> ();
	}
	
	/**
	 * Pushes an integer into the stack.
	 * @param n the integer to be pushed
	 */
	public void push(int n) {
		stack.add(n);
	}
	
	/**
	 * Pops an integer from the stack.
	 * @return the integer popped from the stack
	 * @throws ArrayIndexOutOfBoundsException if the stack is empty
	 */
	public int pop() {
		return stack.remove(stack.size()-1);	// if -1 (empty) will throw ArrayIndexOutOfBoundsException
	}
	
	/**
	 * Gets the size of the stack.
	 * @return the number of elements in the stack
	 */
	public int size() {
		return stack.size();
	}
	
	/**
	 * Gets the value from the stack that will be popped, but does
	 * not actually pop it.
	 * @return the value to be popped, if pop() was called
	 * @throws ArrayIndexOutOfBoundsException if the stack if empty
	 */
	public int peek() {
		
		return stack.get(stack.size()-1); // if -1 (empty) will throw ArrayIndexOutOfBoundsException
	}

}
