public class PointXY
{
	private int x;
	private int y;
	
	public PointXY (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX ()
	{
		return x;
	}
	
	public int getY ()
	{
		return y;
	}
	
	public PointXY getPoint ()
	{
		return this;
	}
	
	public String toString ()
	{
		return "(" + x + ", " + y + ")";
	}
}