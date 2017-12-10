package Shaper;

import java.util.ArrayList;

public abstract class Polygon extends Shape
{
	protected ArrayList<Double> lengths;
	
	public Polygon(ArrayList<Double> lengths)
	{
		this.lengths = lengths;
	}
	
	@Override
	public double getPerimeter()
	{
		for(int i = 0; i < lengths.size(); i++)
		{
			perimeter += lengths.get(i);
		}
		
		return super.perimeter;
	} 
	
}
