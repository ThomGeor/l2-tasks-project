package network;

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

    /* Creates his Network if he doesn't have one
    * */
    public void createNetwork(String name) {
        if(this.network == null) {
            this.network = new Network(name);
        }
    }

    // 2 methods : with or without wallet amount
    public void createMember(String name, SocialClass socialClass, int wallet) {
    	Member member = new Member(wallet, name, socialClass); 
        networkList.add(networkList.size(), member);
    }
}
