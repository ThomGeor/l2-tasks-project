package network;

import java.util.ArrayList;

/**
 * TODO
 * Separate network and admin
 */
public class Admin extends Member {
    private ArrayList<Member> networkList;
    private ArrayList<Task> taskList; 
    private String nameOfNetwork;
    private Network network;

    public Admin(int wallet, String name, SocialClass socialClass) {
        super(wallet, name, socialClass);
        this.networkList = new ArrayList<Member>();
        this.taskList    = new ArrayList<Task>();
    }

    // Create class network
    public void createNetwork(String name) {
        this.network = new Network(name); 
    }

    // 2 methods : with or without wallet amount
    public void createMember(String name, SocialClass socialClass, int wallet) {
    	Member member = new Member(wallet, name, socialClass); 
        networkList.add(networkList.size(), member);
    }
}
