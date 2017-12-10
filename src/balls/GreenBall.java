package balls;
import dastapp.labactivity.*;
public class GreenBall extends Ball implements LeftClickableBall
{
	private BlueBall ball;
	public GreenBall(BlueBall b)
	{
		super(50,125, 2);
		ball = b;
	}

	@Override
	public void leftClicked() 
	{
		this.setX(ball.getX());
	}
}
