package reseauEchange;

import java.util.ArrayList; 

public class Admin extends Member{
	private ArrayList<Member> network;
	private String nameOfNetwork; 
	
	public Admin(int wallet, String name, SocialClass socialClass){
		super(wallet, name, socialClass);
		this.network = new ArrayList<Member>(); 
	}
	
	public void createNetwork(String name) {
		this.nameOfNetwork = name; 
	}
	
	public void createMember(String name, SocialClass socialClass, double wallet) {
		network.add(network.size(), new Member(wallet, name, socialClass)); 
	}
	
	
}
