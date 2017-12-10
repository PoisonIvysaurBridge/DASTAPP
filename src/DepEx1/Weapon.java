// Ivana Lim Terminal 2
package DepEx1;

public class Weapon extends Item //implements Interactive
{
	private int attack;
	
	public Weapon(String name, int attack)
	{
		super(name);
		this.attack = attack;
	}
	
	public void triggeredInteraction(Hero hero)
	{
		hero.equipWeapon(this);
	}
	
	public int getAttack()
	{
		return attack;
	}
}
