package balls;
import dastapp.labactivity.*;

public class MyBallWindow extends BallWindow
{
	public MyBallWindow()
	{
		super(500, 300, "BALLS");
		show();
		BlueBall b = new BlueBall();
		addBall(b);
		addBall(new GreenBall(b));
		addBall(new RedBall());
	}
	
	public static void main(String[] args)
	{
		MyBallWindow app = new MyBallWindow();
	}
}
