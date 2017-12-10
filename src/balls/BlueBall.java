package balls;
import java.awt.Color;

import dastapp.labactivity.*;
public class BlueBall extends Ball implements LeftClickableBall, RightClickableBall
{
	public BlueBall()
	{
		super(50,50,3);
	}

	@Override
	public void leftClicked() 
	{
		this.setX(this.getX()+10);
	}

	@Override
	public void rightClicked() 
	{
		this.setX(this.getX()-10);
	}
}
