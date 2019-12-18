package exe;

import exceptions.AlreadyInNetwork;
import network.Admin;
import network.Member;
import network.SocialClassHalf;
import network.SocialClassNormal;

public class Main {

	public static void main(String[] args) {
		TestNetwork();
	}

	/*
	 * Try to create a Member
	 * Check what the network value when no Network
	 * */
	public static void TestMember(){
		// Try to create a Member
		Member member1 = new Member(0, "Thomas", new SocialClassHalf());

		// Add in and remove from the wallet
		member1.creditWallet(1000);
		System.out.println(member1.getWallet());
		member1.creditWallet(1000);
		System.out.println(member1.getWallet());

		// What is the Network when unset ? null
		System.out.println(member1.getNetwork());
	}

	/*
	 * Try to create a Network from an Admin
	 * Add Members, create them
	 * */
	public static void TestNetwork(){
		Admin admin = new Admin(1000, "admin", new SocialClassNormal());

		//	Create a Network
		try {
			admin.createNetwork("First Network");
		} catch (AlreadyInNetwork alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}

		// Test if already in Network
		/*try {
			admin.createNetwork("First Network");
		} catch (AlreadyInNetwork alreadyInNetwork) {
			System.err.println(alreadyInNetwork.getNetwork().getName());
			System.err.println(alreadyInNetwork.getMessage());
		}
		try {
			admin.setNetwork(admin.getNetwork());
		} catch (AlreadyInNetwork alreadyInNetwork) {
			System.err.println(alreadyInNetwork.getNetwork().getName());
			System.err.println(alreadyInNetwork.getMessage());
		}*/

		//	Create a Member directly in Network
		admin.getNetwork();

		//	Add a Member by Network
		//	Create a Member by Admin
		//	Add a Member by Admin
	}

	/*
	* Try to create a Task and execute it to check the balances
	* */
	public static void TestTask(){

	}
}
