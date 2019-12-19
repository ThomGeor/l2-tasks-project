package network;

import exceptions.AlreadyInNetwork;
import exceptions.NotInNetwork;

public class Admin extends Member { 
	
    // Admin constructor
    public Admin(int wallet, String name, SocialClass socialClass) {
        super(wallet, name, socialClass);
    }

    /**
     * Creates his Network if he doesn't have one
     *
     * @see Network
     * @return Network
     *  */
    public Network createNetwork(String name) throws AlreadyInNetwork {
        if(this.network == null) {
            this.network = new Network(name, this);
        }else{
            throw new AlreadyInNetwork("Delete the Network first then recreate it", this, this.network);
        }
        return this.network;
    }

    /**
     * Create a Member and add it directly to the Admin's Network
     *
     * @return Member
     * */
    public Member createMember(int balance, String name, SocialClass socialClass) throws NotInNetwork {
        if(this.network != null){
    	    return this.network.createMember(wallet, name, socialClass);
        }else{
            throw new NotInNetwork("Create a Network with this Admin before creating Members", this);
        }
    }

    /**
     * Delete the Network, set Admin's Network to null and all Members' too
     * Empty the Set of Members
     *
     * @throws NotInNetwork
     * */
    public void deleteNetwork() throws NotInNetwork {
        if(this.network == null){
            throw new NotInNetwork("To delete a Network the Admin must be in one", this);
        }else{

        }
    }
}
