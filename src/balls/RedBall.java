package balls;
import dastapp.labactivity.*;
public class RedBall extends Ball implements LeftClickableBall
{
	public RedBall()
	{
		super (50,200,1);
	}

	@Override
	public void leftClicked() 
	{
		if(this.getColor() == 1)
		{
			this.setColor(2);
		}
		else
		{
			this.setColor(1);
		}
	}
}
