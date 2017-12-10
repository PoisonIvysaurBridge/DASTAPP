package Finals;
// Lim, Ivana #2
import java.util.ArrayList;

/**
 * Represents a bunker object.
 * @author Tiam-Lee
 *
 */
public class Bunker {
	
	private ArrayList <Bunker> connectedBunkers = new ArrayList<>();
	private boolean bomb;
	
	/**
	 * Instantiates a new bunker object. Initially, a bunker has no bomb in it.
	 */
	public Bunker() {
		bomb = false;
	}
	
	/**
	 * Makes a direct tunnel from this bunker to the given bunker, if it does not exist yet.
	 * @param b the bunker where the tunnel directly leads to 
	 */
	public void makeTunnel(Bunker b) {
		if (connectedBunkers.contains(b) == false) {
			connectedBunkers.add(b);
			b.makeTunnel(this);
		}
	}
	
	/**
	 * Gets the list of bunkers that are directly connected to this bunker by a tunnel.
	 * @return the list of bunkers that are directly connected to this bunker by a tunnel
	 */
	public ArrayList <Bunker> getConnectedBunkers() {
		return connectedBunkers;
	}
	
	/**
	 * Adds a bomb to this tunnel.
	 */
	public void addBomb() {
		bomb = true;
	}
	
	/**
	 * Checks whether this tunnel has a bomb or not.
	 * @return true, if the tunnel has a bomb or false otherwise
	 */
	public boolean hasBomb() {
		return bomb;
	}

}
