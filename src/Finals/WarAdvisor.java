package Finals;
// Lim, Ivana #2
import java.util.ArrayList;

public class WarAdvisor {
	
	public boolean isSafe(ArrayList <Bunker> bunkers) {
		boolean isSafe = false;
		for(Bunker bunker : bunkers)
		{
			if(bunker.hasBomb()==false)
			{
				for(Bunker connectedBunk: bunker.getConnectedBunkers())
				{
					if (connectedBunk.hasBomb()==false)
					{
						return true;
					}
				}
			}
		}
		
		return isSafe;
	}

}
