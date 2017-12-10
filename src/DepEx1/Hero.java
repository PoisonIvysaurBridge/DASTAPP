// Ivana Lim Terminal 2
package DepEx1;

public class Hero {
	private String name;
	private Weapon weapon;
	private int health;
	private int baseAttack;
	
	public Hero(String name, int health, int baseAttack) {
		this.name = name;
		this.health = health;
		this.baseAttack = baseAttack;
	}
	
	public void interact(Interactive obj) {
		obj.triggerInteraction(this);
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getBaseAttack() {
		return baseAttack;
	}
	
	public int getTotalAttack() {
		if (weapon == null) {
			return baseAttack;
		}
		else {
			return baseAttack + weapon.getAttack();
		}
	}
	
	public void equipWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}