package network;

import exceptions.*;

import java.util.HashSet;
import java.util.Set;

public class Member {
    protected int wallet;
	protected String name;
	protected SocialClass socialClass;
	protected Set<Service> services;
	protected Network network; // Get the Network of which he's member

	// Member constructor With initial Network
    public Member(int wallet, String name, SocialClass socialClass, Network network) {
        this.services = new HashSet<Service>();
        this.wallet = wallet;
        this.name = name;
        this.socialClass = socialClass;
        this.network = network;
    }

    /** Member constructor without initial Network
    * Have to affect to one after
    * */
	public Member(int wallet, String name, SocialClass socialClass) {
		this.services = new HashSet<Service>();
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

	public Set<Service> getServices() {
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
		// Remove Member's Network
		else if (network == null) this.network = null;
		else if(this.network == null) this.network = network;
		else throw new AlreadyInNetwork("First remove the Member from the Network first, or if Admin, delete it",this, this.network);
		return network;
	}

    /**
	 * Add a Service that this Member can do
	 *
	 * @throws AlreadyHasService
	 * */
    public void addService(Service service) throws AlreadyHasService {
		if(!this.services.add(service)){
			throw new AlreadyHasService("", this, service);
		}
    }

	/**
	 * Remove a Service that the Member can do
	 *
	 * @throws DontHaveService
	 * */
	public void removeService(Service service) throws DontHaveService {
		if(!this.services.remove(service)){
			throw new DontHaveService("", this, service);
		}
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

	public String toString(){
    	return this.name + "(" + this.wallet + ", "
				+ this.socialClass + ", "
				+ ((this.network != null) ? (this.network.getName()) : "null") + ", "
				+ this.services
		+ ")";
	}
}
