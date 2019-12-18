package network;
import exceptions.AlreadyInNetwork;

import java.util.HashSet;
import java.util.Set;

public class Network {
	private Set<Member> network;
	private String name; 
	
	public Network(String name) {
		this.network = new HashSet<Member>();
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	public Set<Member> getNetworkList(){ return this.network; }

	/**
	 *  Add a Member without Network to this one
	 *  Set Member.network to this Network
	 *  */
	public void addMember(Member member) throws AlreadyInNetwork {
		if(member.getNetwork() == null) {
			network.add(member);
			member.setNetwork(this);
		}else{
			throw new AlreadyInNetwork("", member, this);
		}
	}

	/**
	 * Create a Member directly in the Network
	 *
	 * @return Member
	 * */
	public Member createMember(int balance, String name, SocialClass socialClass){
		Member newMember = new Member(balance, name, socialClass);

		try {
			this.addMember(newMember);
		} catch (AlreadyInNetwork alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}
		
		return newMember;
	}

	// TODO
	/*public void removeMember(Member member) {
		int indice = 0;

		while(!(member.getName().equals(member.getName()))){
			indice ++;
		}

		network.remove(indice);
//		member.inNetwork();
	}*/
}
