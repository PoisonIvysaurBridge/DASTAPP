package Finals;
// Lim, Ivana #2
import java.util.ArrayList;

public class WarDriver {
	
	public static void main(String[] args) {
		WarAdvisor warAdvisor = new WarAdvisor();
		
		Bunker a = new Bunker();
		Bunker b = new Bunker();
		Bunker c = new Bunker();
		Bunker d = new Bunker();
		Bunker e = new Bunker();
		
		a.makeTunnel(b);
		a.makeTunnel(c);
		b.makeTunnel(d);
		d.makeTunnel(c);
		d.makeTunnel(e);
		
		b.addBomb();
		
		ArrayList <Bunker> bunkerList = new ArrayList <Bunker> ();
		bunkerList.add(a);
		bunkerList.add(b);
		bunkerList.add(c);
		bunkerList.add(d);
		bunkerList.add(e);
		
		// should display true, in this example
		// make sure it also displays the correct answer in other examples
		System.out.println(warAdvisor.isSafe(bunkerList));

		//example 2
		a = new Bunker();
		 b = new Bunker();
		 c = new Bunker();
		 d = new Bunker();
		 e = new Bunker();
		 Bunker f = new Bunker();
		 Bunker g = new Bunker();
		 
		 d.makeTunnel(b);
		 d.makeTunnel(c);
		 d.makeTunnel(e);
		 d.makeTunnel(f);
		 a.makeTunnel(f);
		 a.makeTunnel(e);
		 a.makeTunnel(g);
		 
		 d.addBomb();
		 a.addBomb();
		 
		 bunkerList = new ArrayList <Bunker> ();
		 bunkerList.add(a);
		bunkerList.add(b);
		bunkerList.add(c);
		bunkerList.add(d);
		bunkerList.add(e);
		bunkerList.add(f);
		bunkerList.add(g);
		System.out.println(warAdvisor.isSafe(bunkerList));
		
		// example 3
		a = new Bunker();
		 b = new Bunker();
		 c = new Bunker();
		 d = new Bunker();
		 
		 a.makeTunnel(b);
		 b.makeTunnel(c);
		 c.makeTunnel(d);
		 
		 a.addBomb();
		 b.addBomb();
		 
		 bunkerList = new ArrayList <Bunker> ();
		 bunkerList.add(a);
		bunkerList.add(b);
		bunkerList.add(c);
		bunkerList.add(d);
		System.out.println(warAdvisor.isSafe(bunkerList));
			
	}

}
