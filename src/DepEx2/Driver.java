package DepEx2;


public class Driver {
	
	public static void main(String[] args) {
		String[] names = {"Kayle", "Yuta", "Nicole", "Ivana"};
		boolean[][] network = {{false, false, true, true},
							   {false, false, true, false},
							   {true, true, false, true},
							   {true, false, true, false}};
				
		SocialNetwork socialNetwork = new SocialNetwork(network, names);
		System.out.println(socialNetwork.areFriends("Kayle", "Nicole"));
		System.out.println(socialNetwork.areFriends("Yuta", "Ivana"));
		System.out.println(socialNetwork.getNumberOfFriends("Nicole"));
		System.out.println(socialNetwork.getNumberOfFriends("Yuta"));
		socialNetwork.displayAllMutualFriends("Kayle", "Yuta");
		socialNetwork.displayAllMutualFriends("Kayle", "Nicole");
		socialNetwork.displayAllMutualFriends("Ivana", "Nicole");
	}

}
