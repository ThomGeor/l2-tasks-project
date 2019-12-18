package network;

import exceptions.AlreadyInNetwork;

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

    // 2 methods : with or without wallet amount
    /*public void createMember(String name, SocialClass socialClass, int wallet) {
    	Member member = new Member(wallet, name, socialClass); 
        networkList.add(networkList.size(), member);
    }*/
}
