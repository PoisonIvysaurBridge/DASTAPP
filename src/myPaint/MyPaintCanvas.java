package myPaint;
import java.awt.Color;
import java.util.ArrayList;

import dastapp.labactivity.PaintCanvas;
public class MyPaintCanvas extends PaintCanvas
{
	private Stack stack;
	private ArrayList<Cell> visited;
	private Cell[][] cells;
	private Cell start;
	
	public MyPaintCanvas()
	{
		stack = new Stack();
		visited = new ArrayList<>();
		start = new Cell(getCellColumn(), getCellColumn());
		cells = new Cell[90][119];
		for(int i = 0; i < 90; i++)
		{
			for(int j = 0; j <= 118; j++)
			{
				cells[i][j] = new Cell(j, i);
			}
		}
	}
	
	public static void main(String[] args)
	{
		MyPaintCanvas app = new MyPaintCanvas();
	}

	@Override
	public void  leftMousePressed()
	{
		setBlack(getCellRow(), getCellColumn());
	}
	
	@Override
	public void rightMouseClicked()
	{

	//	Stack stack = new Stack();
		Queue stack = new Queue();
		start = new Cell(getCellColumn(), getCellRow());
		start.setIsVisited(true);
	//	stack.push(start);
		stack.enqueue(start);
		
		while(!stack.isEmpty())// && !xPoints.isEmpty() && !yPoints.isEmpty())
		{
		//	Cell curCell = (Cell)stack.pop();
			Cell curCell = (Cell)stack.dequeque();
			ArrayList<Cell> neighbors = getNeighbors(curCell);
			for(Cell neigh : neighbors)
			{
				if(/*neigh != null &&*/ neigh.isVisited() == false)// && !isVisited(neigh.getY(), neigh.getX(), visited))
                {
					setRed(neigh.getY(), neigh.getX());
					neigh.setIsVisited(true);
                	stack.enqueue(neigh);
                }
			}
		}
	}
	
	// not used
	public boolean isVisited(int y, int x, ArrayList<Cell> visited)
	{
		for(Cell c : visited)
		{
			if (c.getY() == y && c.getX() == x)
				return true;
		}
		return false;
	}
	
	public ArrayList<Cell> getNeighbors(Cell c)
    {
        ArrayList<Cell> neighbors = new ArrayList<>();
        int x = 0;
        int y = 0;
        for(int i = 0; i < cells.length; i++)
        {
            for(int j = 0; j < cells[i].length; j++)
            {
                if(cells[i][j].getX() == c.getX() && cells[i][j].getY() == c.getY())
                {
                    y= j;
                    x = i;
                    break;
                }
            }
        }
        Cell up = null, down = null, left = null, right = null;
        if (x -1 >= 0) 					up = cells[x-1][y];
        if (x + 1 < cells.length) 		down = cells[x+1][y];
        if (y -1 >= 0) 					left = cells[x][y-1];
        if (y + 1 < cells[0].length) 	right = cells[x][y+1];
         
        if(up != null && getColor(up.getY(), up.getX()) != 1 /*&& up.isVisited() == false*/) // UP
        {
        	neighbors.add(up);
        }
        if(down != null && getColor(down.getY(), down.getX()) != 1 /*&& up.isVisited() == false*/) // DOWN
        {
        	neighbors.add(down);
        }
        if(left != null && getColor(left.getY(), left.getX()) != 1 /*&& up.isVisited() == false*/) // LEFT
        {
        	neighbors.add(left);
        }
        if(right != null && getColor(right.getY(), right.getX()) != 1 /*&& up.isVisited() == false*/) // RIGHT
        {
        	neighbors.add(right);
        }
         
        return neighbors;
    }
}

class Cell 
{
	private int x;
	private int y;
	private boolean isVisited;
	
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		isVisited = false;
	}
	
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public boolean isVisited()
	{
		return isVisited;
	}
	public void setIsVisited(boolean b)
	{
		isVisited = b;
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

class Queue 
{
	private ArrayList list;
	
	public Queue()
	{
		list = new ArrayList<>();
	}
	
	public void enqueue(Object E)
	{
		list.add(E);
	}
	
	public Object dequeque()
	{
		if (list.size()!=0)
			return list.remove(0);
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

