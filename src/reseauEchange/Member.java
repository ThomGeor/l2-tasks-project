package reseauEchange;

import java.util.ArrayList;

public class Member {
	private double wallet;  
	private String name; 
	private SocialClass socialClass; 
	private ArrayList<Service> services; 
	
	public Member(double wallet, String name, SocialClass socialClass) {
		this.services = new ArrayList<Service>(); 
		this.wallet = wallet; 
		this.name = name; 
		this.socialClass = socialClass; 
	}
	
	public void newService() {
		
	}
	public void increaseWallet() {
		wallet += services.get().
	}
	
	public void decreaseWallet() {
		
	}
}
