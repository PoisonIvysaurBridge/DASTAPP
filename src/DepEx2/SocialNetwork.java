package DepEx2;

// Ivana Lim #2
import java.util.ArrayList;

public class SocialNetwork {

	private boolean[][] network;
	private String[] names;

	public SocialNetwork(boolean[][] network, String[] names) {
		this.network = network;
		this.names = names;
	}

	/* Returns true if name1 and name2 are friends and false otherwise */
	public boolean areFriends(String name1, String name2) {
		int row = 0;
		int col = 0;
		for (int i = 0; i < names.length; i++)
		{
			if (name1.equals(names[i]))
			{
				row = i;
			}
			if (name2.equals(names[i]))
			{
				col = i;
			}
		}
		return network[row][col];
	}

	/* Returns the number of friends of name1 in the social network */
	public int getNumberOfFriends(String name1) {
		int row = 0;
		for(int i = 0; i < names.length; i++)
		{
			if (name1.equals(names[i]))
			{
				row = i;
			}
		}
		int friends = 0;
		for (int j = 0; j < network[row].length; j++)
		{
			if (network[row][j])
			{
				friends++;
			}
		}
		return friends;
	}

	/* Displays all the mutual friends of name1 and name2, does not return anything */
	public void displayAllMutualFriends(String name1, String name2) {
		ArrayList<String> mutuals = new ArrayList<>();
		ArrayList<String> friends1 = new ArrayList<>();
		ArrayList<String> friends2 = new ArrayList<>();
		
		int row = 0;
		for(int i = 0; i < names.length; i++)	// get name1 from names
		{
			if (name1.equals(names[i]))
			{
				row = i;
			}
		}
		
		for (int j = 0; j < network[row].length; j++)	// get name1 friends
		{
			if (network[row][j])
			{
				friends1.add(names[j]);
			}
		}
		//####################### name 2
		row = 0;
		for(int i = 0; i < names.length; i++)	// get name2 from names
		{
			if (name2.equals(names[i]))
			{
				row = i;
			}
		}
		
		for (int j = 0; j < network[row].length; j++)	// get name2 friends
		{
			if (network[row][j])
			{
				friends2.add(names[j]);
			}
		}
		
		//############ mutual
		for(int i = 0; i < friends1.size(); i++)
		{
			for(int j = 0; j < friends2.size(); j++)
			{
				if (friends1.get(i).equals(friends2.get(j)))
				{
					mutuals.add(friends1.get(i));
				}
			}
		}
		for(int i = 0; i < mutuals.size(); i++)
		{
			System.out.println(mutuals.get(i));
		}
	}

}
