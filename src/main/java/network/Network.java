package network;
import exceptions.AlreadyInNetwork;
import exceptions.CantSetNetworkAdmin;

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
	 *
	 * @throws CantSetNetworkAdmin
	 * @throws AlreadyInNetwork
	 *  */
	public void addMember(Member member) throws AlreadyInNetwork, CantSetNetworkAdmin {
		if(member.getNetwork() == null && network.add(member)) {
			member.setNetwork(this);
		}else{
			throw new AlreadyInNetwork("Remove Member from his Network first", member, this);
		}
	}

	/**
	 * Create a Member directly in the Network
	 *
	 * @return Member
	 * */
	public Member createMember(int balance, String name, SocialClass socialClass)  {
		Member newMember = new Member(balance, name, socialClass);

		// Member is created here so can't be an Admin and can't already be in a Network
		// So we take car of errors here
		try {
			this.addMember(newMember);
		} catch (CantSetNetworkAdmin | AlreadyInNetwork cantSetNetworkAdmin) {
			cantSetNetworkAdmin.printStackTrace();
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
