package network;

import exceptions.AlreadyInNetwork;
import exceptions.NotInNetwork;

import java.util.ArrayList;

/**
 * TODO
 * Can create Network
 * deleteNetwork() --> remove all Members
 * addMember
 */
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
            this.network = new Network(name);
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
}
