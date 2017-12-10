package Shaper;

import java.util.ArrayList;

public class Rectangle extends Polygon
{
	private double length;
	private double width;
	
	public Rectangle(ArrayList<Double> lengths)
	{
		super(lengths);
	}
	/*
	public Rectangle(double l, double w)
	{
		length = l;
		width = w;
	}
	/*
	@Override
	public double getPerimeter()
	{
		perimeter = 2 * length + 2 * width;
		return super.perimeter;
	}
	@Override
	public double getArea()
	{
		area = length * width;
		return super.area;
	}
	*/
	@Override
	public double getArea()	// works for squares & rectangles
	{
		for(int i = 0; i < lengths.size()-1; i++)
		{
			for(int j = 0; j < lengths.size()-1; j++)
			{
				if(lengths.get(j) > lengths.get(j+1))
				{
					double tmp = lengths.get(j);
					lengths.set(j, lengths.get(j+1));
					
					//lengths[j] = lengths[j+1];
				//	lengths[j+1] = tmp;
				}
			}
		}
		area = lengths.get(0) * lengths.get(2);
		//	area = lengths[0] * lengths[2];	
		return super.area;
	}
}
