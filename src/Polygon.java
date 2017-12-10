import java.util.*;

public class Polygon
{
	private ArrayList<PointXY> vertex;
	
	public Polygon ()
	{
		vertex = new ArrayList <PointXY> ();
	}
	
	public void addPoint (PointXY p)
	{
		vertex.add (p);
	}
	
	public PointXY getVertexAt (int index)
	{
		if (index >= 0 && index < vertex.size ())
			return vertex.get (index);
		return null;
	}
	
	public String toString ()
	{
		int j;
		String temp = "";
		
		for (j = 0; j < vertex.size (); j++)
		{
			if (j != 0)
				temp = temp + "\n";
			temp = temp + vertex.get (j).toString ();
		}
		
		return temp;
	}
}