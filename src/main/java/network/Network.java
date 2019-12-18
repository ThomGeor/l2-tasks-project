package network;
import java.util.ArrayList;

public class Network {
	private ArrayList<Member> network;
	private String name; 
	
	public Network(String name) {
		this.network = new ArrayList<Member>();
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	/* Add a Member without Network to this one
	* Call Member.setNetwork
	* */
	/*public void addMember(Member member) {
		if(member.getNetwork()) {
			network.add(member);
			member.inNetwork(); 
		}
	}*/

	public ArrayList<Member> getNetworkList(){ return this.network; }
	
	public void removeMember(Member member) {
		int indice = 0; 
		
		while(!(member.getName().equals(member.getName()))){
			indice ++; 
		}
		
		network.remove(indice); 
//		member.inNetwork();
	}
}
