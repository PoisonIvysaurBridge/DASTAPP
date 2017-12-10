// Ivana Lim Terminal 2
package DepEx1;

public class Food extends Item //implements Interactive
{
	private int nutrition;
	
	public Food(String name, int nutrition)
	{
		super(name);
		this.nutrition = nutrition;
	}
	
	public void triggerInteraction(Hero hero)
	{
		hero.setHealth(hero.getHealth()+nutrition);
	}
	
	public int getAttack()
	{
		return nutrition;
	}
}
