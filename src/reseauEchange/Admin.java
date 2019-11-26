package reseauEchange;

import java.util.ArrayList; 

/** TODO
 * Separate network and admin
 */
public class Admin extends Member{
	private ArrayList<Member> network;
  private String nameOfNetwork; 
  private Network network;
	
	public Admin(int wallet, String name, SocialClass socialClass){
		super(wallet, name, socialClass);
		this.network = new ArrayList<Member>(); 
	}
  
  // Create calss network
	public void createNetwork(String name) {
		this.network = new Network()
	}
  
  // 2 methods : with or without wallet amount
	public void createMember(String name, SocialClass socialClass, double wallet) {
		network.add(network.size(), new Member(wallet, name, socialClass)); 
	}
	
	
}
