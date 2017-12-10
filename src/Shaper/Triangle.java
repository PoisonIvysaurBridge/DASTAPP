package Shaper;

public class Triangle extends Polygon
{
	/*private double s1,
				   s2,
				   s3,
				   height;
	*/
	public Triangle(double[] lengths/*, double heightPerpendicularS1*/)
	{
		super(lengths);
		//height = heightPerpendicularS1;
	}
	/*
	public Triangle(double s1, double s2, double s3, double heightPerpendicularS1)
	{
		
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.height = heightPerpendicularS1;
		
		if(s1 + s2 <= s3)
		{
			s1 = s2 = s3 = 0;
		}
	}
	
	@Override
	public double getPerimeter()
	{
		perimeter = s1 + s2 + s3;
		return super.perimeter;
	}
	
	@Override
	public double getArea()
	{
		area = (s1 * height) / 2;
		return super.area;
	}
	*/
	@Override
	public double getArea()	// Area	=	 √	 p	 (	p	−	a	) 	(	p	−	b	)	 (	p	−	c	)    
	{
		double p = getPerimeter()/2;
		area = Math.pow((p*(p - lengths[0])*(p - lengths[1])*(p - lengths[2])), 1/2);
		return super.area;
	}
}
