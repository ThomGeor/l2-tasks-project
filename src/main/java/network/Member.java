package network;

import exceptions.MissAmountException;

import java.util.ArrayList;

public class Member {
	// list of networks
    private int wallet;
    private String name;
    private SocialClass socialClass;
    private ArrayList<Service> services;
    private ArrayList<Network> network;
    
    
    
	public int getWallet() {
		return wallet;
	}

	public String getName() {
		return name;
	}

	public SocialClass getSocialClass() {
		return socialClass;
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	// With initial wallet amount
    public Member(int wallet, String name, SocialClass socialClass) {
        this.services = new ArrayList<Service>();
        this.wallet = wallet;
        this.name = name;
        this.socialClass = socialClass;
    }
	// Without initial wallet amount
    public Member(String name, SocialClass socialClass) {
		this.services = new ArrayList<Service>();
		this.wallet = 0;
		this.name = name;
		this.socialClass = socialClass;
	}

    // Add service
	// TODO
    public void addService(Service service) {
		if(!this.services.contains(service)){
			this.services.add(service);
		}
    }

	// Remove service
	// TODO
	public void removeService() {

	}

	// Add to Member's Wallet
	// Return IllegalArgumentException if mcoins < 0
    public void creditWallet(int mcoins) throws IllegalArgumentException {
		if(mcoins < 0) throw new IllegalArgumentException("ERR: mcoins must be >= 0");
    	this.wallet += mcoins;
    }

	// Remove from Member's Wallet
	// Return IllegalArgumentException if mcoins < 0
	// Return MissAmountException if mcoins > wallet
	public void debitWallet(int mcoins) throws IllegalArgumentException, MissAmountException {
		if(mcoins < 0) throw new IllegalArgumentException("ERR: mcoins must be >= 0");
		else if(mcoins > this.wallet) throw new MissAmountException("ERR: not enough coins", mcoins-this.wallet, this.wallet);
		this.wallet += mcoins;
	}
}
