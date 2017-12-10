package myStack;
// Ivana Lim
//package world;

import java.awt.event.*;
import java.util.*;
import dastapp.labactivity.World;

public class MyWorld extends World //implements KeyListener
{
	private Stack positionsX;
	private Stack positionsY;
	private Stack coins;
	public MyWorld()
	{
		super(7,7);
		setHeroLocation(3, 3);
		
		setCoin(1, 1, true);
		setCoin(1, 5, true);
		setCoin(5, 1, true);
		setCoin(5, 5, true);
		positionsX = new Stack();
		positionsY = new Stack();
		coins = new Stack();
	}
	public static void main(String[] args)
	{
		MyWorld w = new MyWorld();
	}
	
	@Override
	public void spacePressed() 
	{
		if(!positionsX.isEmpty() && !positionsY.isEmpty() && !coins.isEmpty())
    	{
			if((boolean)coins.pop())
    			setCoin(getHeroLocationRow(), getHeroLocationColumn(), true);
			this.setHeroLocation((int)positionsY.pop(), (int)positionsX.pop());
    	}
	}
	@Override
	public void upArrowPressed()
	{
	//	System.out.println("up");
		
		if(this.getHeroLocationRow()-1 >= 0)
		{
			positionsX.push(this.getHeroLocationColumn());
			positionsY.push(this.getHeroLocationRow());
			setHeroLocation(this.getHeroLocationRow()-1, this.getHeroLocationColumn());
		}
			
		if(getCoin(getHeroLocationRow(), getHeroLocationColumn()))
		{
			coins.push(true);
			setCoin(getHeroLocationRow(), getHeroLocationColumn(), false);
		}
		else
			coins.push(false);
	}
	@Override
	public void downArrowPressed()
	{
		
		if(this.getHeroLocationRow()+1 < this.getRows())
		{
			positionsX.push(this.getHeroLocationColumn());
			positionsY.push(this.getHeroLocationRow());
			setHeroLocation(this.getHeroLocationRow()+1, this.getHeroLocationColumn());
		}
			
		if(getCoin(getHeroLocationRow(), getHeroLocationColumn()))
		{
			coins.push(true);
			setCoin(getHeroLocationRow(), getHeroLocationColumn(), false);
		}
		else
			coins.push(false);
	}
	@Override
	public void leftArrowPressed()
	{
		
		if(this.getHeroLocationColumn()-1 >= 0)
		{
			positionsX.push(this.getHeroLocationColumn());
			positionsY.push(this.getHeroLocationRow());
			setHeroLocation(this.getHeroLocationRow(), this.getHeroLocationColumn()-1);
		}
			
		if(getCoin(getHeroLocationRow(), getHeroLocationColumn()))
		{
			coins.push(true);
			setCoin(getHeroLocationRow(), getHeroLocationColumn(), false);
		}
		else
			coins.push(false);
	}
	@Override
	public void rightArrowPressed()
	{
		
		if(this.getHeroLocationColumn()+1 < this.getColumns())
		{	
			positionsX.push(this.getHeroLocationColumn());
			positionsY.push(this.getHeroLocationRow());
			setHeroLocation(this.getHeroLocationRow(), this.getHeroLocationColumn()+1);
		}
		if(getCoin(getHeroLocationRow(), getHeroLocationColumn()))
		{
			coins.push(true);
			setCoin(getHeroLocationRow(), getHeroLocationColumn(), false);
		}
		else
			coins.push(false);
	}
}

class Stack 
{
	private ArrayList list;
	
	public Stack()
	{
		list = new ArrayList<>();
	}
	
	public void push(Object E)
	{
		list.add(E);
	}
	
	public Object pop()
	{
		if (list.size()!=0)
			return list.remove(list.size()-1);
		else
			return null;
	}
	
	public Object peek()
	{
		if (list.size()!=0)
			return list.get(list.size()-1);
		else
			return null;
	}
	
	public boolean isEmpty()
	{
		return list.size() == 0;
	}
	
	public int size()
	{
		return list.size();
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("");
		for(int i = 0; i < list.size(); i++)
		{
			s.append(list.toString() + "\n");
		}
		return s.toString();
	}
}

