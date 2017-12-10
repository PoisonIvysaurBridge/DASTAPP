import java.util.ArrayList;

public class Queue 
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
