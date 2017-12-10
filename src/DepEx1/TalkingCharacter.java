package DepEx1;

public class TalkingCharacter extends Character implements Interactive
{
	private String dialogue;
	
	public TalkingCharacter(String name, String dialogue)
	{
		super(name);
		this.dialogue = dialogue;
	}


	@Override
	public void triggerInteraction(Hero hero) 
	{
		System.out.println(dialogue);
	}
}
