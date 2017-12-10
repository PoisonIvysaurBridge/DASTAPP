package Shaper;

public class Circle extends Shape
{
	public double radius;
	
	public Circle(double r)
	{
		radius = r;
	}
	
	@Override
	public double getPerimeter() // gets circumference
	{
		perimeter = 2 * Math.PI * radius;	// perimeter here is the circumference
		return super.perimeter;
	}
	
	@Override
	public double getArea()
	{
		area = Math.PI * radius * radius;
		return super.area;
	}
}
