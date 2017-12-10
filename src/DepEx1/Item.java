// Ivana Lim Terminal 2
package DepEx1;

public class Item implements Interactive
{
	private String name;
	
	public Item(String name)
	{
		this.name = name;
	}
	
	public void triggerInteraction(Hero hero)
	{
		
	}
	
	public String getName()
	{
		return this.name;
	}
}
