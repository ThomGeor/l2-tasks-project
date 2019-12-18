package network;

import exceptions.AlreadyInNetwork;
import exceptions.CantSetNetworkAdmin;
import exceptions.MissAmountException;

import java.util.ArrayList;

public class Member {
    protected int wallet;
	protected String name;
	protected SocialClass socialClass;
	protected ArrayList<Service> services;
	protected Network network; // Get the Network of which he's member

	// Member constructor With initial Network
    public Member(int wallet, String name, SocialClass socialClass, Network network) {
        this.services = new ArrayList<Service>();
        this.wallet = wallet;
        this.name = name;
        this.socialClass = socialClass;
        this.network = network;
    }

    /* Member constructor without initial Network
    * Has to affect to one
    * */
	public Member(int wallet, String name, SocialClass socialClass) {
		this.services = new ArrayList<Service>();
		this.wallet = wallet;
		this.name = name;
		this.socialClass = socialClass;
	}

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
	
	public Network getNetwork() {
		return this.network;
	}

	/**
	 *  Allows to:
	* - affect a Member to a Network if not in one
	* - change the Member's
	* Must be called by a Network (addMember)
	* TODO Must remove Member from Network if not null
	*  TODO Careful for Admin
	 *
	 * @return Network
	* */
	public Network setNetwork(Network network) throws AlreadyInNetwork, CantSetNetworkAdmin {
		if (this instanceof Admin) throw new CantSetNetworkAdmin("Cannot set a Network to an Admin, can only createNetwork", (Admin) this);
		else if(this.network == null) this.network = network;
		else throw new AlreadyInNetwork("First remove the Member from the Network first, or if Admin, delete it",this, this.network);
		return network;
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
	public void removeService(Service service) {
		int i = 0; 
		
		while(services.get(i) != service) {
			i++; 
		}
		
		services.remove(i); 
	}

//	TODO
	/*public createTasks(Service service, int time) {
		//Service service, Member beneficiary, ArrayList<Member> participants, double duration, boolean volunteer
		return new Task
	}*/

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
		this.wallet -= mcoins;
	}
}
