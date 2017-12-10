package Finals;
// Lim, Ivana #2
import java.util.LinkedList;
import java.util.Queue;

public class CandyFactory 
{
	private Queue<Candy> candies = new LinkedList<>();
	
	public void produceChocolate(String name, double sugarLvl)
	{
		Chocolate choco = new Chocolate(name, sugarLvl);
		candies.offer(choco);
	}
	
	public void produceBubbleGum(String name, double sugarLvl)
	{
		BubbleGum bg = new BubbleGum(name, sugarLvl);
		candies.offer(bg);
	}
	
	public Candy getCandy()
	{
		if(candies.size() > 0)
		{
			return candies.poll();
		}
		return null;
	}
}
