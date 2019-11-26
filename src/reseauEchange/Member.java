package reseauEchange;

import java.util.ArrayList;

public class Member {
  // list of networks
	private double wallet;  
	private String name; 
	private SocialClass socialClass; 
	private ArrayList<Service> services; 
  
  // 2 constructers : 1 with amount init wallet, 1 default 0
	public Member(double wallet, String name, SocialClass socialClass) {
		this.services = new ArrayList<Service>(); 
		this.wallet = wallet; 
		this.name = name; 
		this.socialClass = socialClass; 
	}
  
  // Add service
	public void newService() {
		
  }
  
  // Take care of amount <0 -> can't create task ??
	public void increaseWallet() {
		wallet += services.get().
	}
	
	public void decreaseWallet() {
		
	}
}
