package myWorld;
// Ivana Lim
import dastapp.labactivity.*;
public class MyWorld extends World 
{
	private Queue positionsX;
	private Queue positionsY;
	boolean start = false;
	
	public static void main(String[] args)
	{
		MyWorld app = new MyWorld();
	}
	
	public MyWorld()
	{
		positionsX = new Queue();
		positionsY = new Queue();
		start = true;
	}
	@Override
	public void rightClicked()
	{
			positionsX.enqueue(getMouseX());
			positionsY.enqueue(getMouseY());
			System.out.println("still walking");
			System.out.println("posi x size: "+ positionsX.size());
			System.out.println("posi y size: "+ positionsY.size());
		//	tick();
	}
	
@Override
	public void tick()
	{
		if(start && !isMoving() &&!positionsX.isEmpty() &&  !positionsY.isEmpty())
		{
			makeHeroWalkToLocation((int)positionsX.dequeque(), (int)positionsY.dequeque());
		//	System.out.println("posi x size: "+ positionsX.size());
		//	System.out.println("posi y size: "+ positionsY.size());
		}
		
	}
}
