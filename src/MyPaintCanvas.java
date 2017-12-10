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
		if(getColor(getCellRow(), getCellColumn()) == 0)
		{
			setRed(getCellRow(), getCellColumn());
		}
		Stack stack = new Stack();
		start = new Cell(getCellColumn(), getCellRow());
		start.setIsVisited(true);
		stack.push(start);
		
		while(!stack.isEmpty())// && !xPoints.isEmpty() && !yPoints.isEmpty())
		{
			Cell curCell = (Cell)stack.pop();
			ArrayList<Cell> neighbors = getNeighbors(curCell);
			for(Cell neigh : neighbors)
			{
				if(neigh != null && neigh.isVisited() == false && !isVisited(neigh.getY(), neigh.getX(), visited))
                {
					setRed(neigh.getY(), neigh.getX());
					neigh.setIsVisited(true);
                	stack.push(neigh);
                }
			}
		}
	}
	
	
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
        int originX = 0;
        int originY = 0;
        for(int i = 0; i < cells.length; i++)
        {
            for(int j = 0; j < cells[i].length; j++)
            {
                if(cells[i][j].getX() == c.getX() && cells[i][j].getY() == c.getY())
                {
                    originY= j;
                    originX = i;
                    break;
                }
            }
        }
        Cell up = null, down = null, left = null, right = null;
        if (originX -1 >= 0) up = cells[originX-1][originY];
        if (originX + 1 < cells.length) down = cells[originX+1][originY];
        if (originY -1 >= 0) left = cells[originX][originY-1];
        if (originY + 1 < cells[0].length) right = cells[originX][originY+1];
         
        if(originX > 0 && up != null && getColor(up.getY(), up.getX()) != 1 /*&& up.isVisited() == false*/) // UP
        {
        	neighbors.add(up);
        }
        if(originX < cells.length && down != null && getColor(down.getY(), down.getX()) != 1 /*&& up.isVisited() == false*/) // DOWN
        {
        	neighbors.add(down);
        }
        if(originY > 0 && left != null && getColor(left.getY(), left.getX()) != 1 /*&& up.isVisited() == false*/) // LEFT
        {
        	neighbors.add(left);
        }
        if(originY < cells[0].length && right != null && getColor(right.getY(), right.getX()) != 1 /*&& up.isVisited() == false*/) // RIGHT
        {
        	neighbors.add(right);
        }
         
        return neighbors;
        
        /*
         int 
         for(int j = 0; j< coordes.length; j++)
         {
         	nextX = X + coords[j][0];
         	nextY = Y + coords[j][0];
         } 
          */
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
