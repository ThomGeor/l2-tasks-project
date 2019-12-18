package exe;

import exceptions.*;
import network.*;

public class Main {

	public static void main(String[] args) {
		// TestMember();
		// TestNetwork();
		// TestServices();
		TestTask();
	}

	/*
	 * Create Member
	 * Credit and Debit wallet
	 * Debit more than the balance
	 * */
	public static void TestMember(){
		// Try to create a Member
		Member member1 = new Member(0, "Thomas", new SocialClassHalf());

		// Add in and remove from the wallet
		member1.creditWallet(1000);
		System.out.println(member1.getWallet());
		try {
			member1.debitWallet(1000);
		} catch (MissAmountException e) {
			e.printStackTrace();
		}
		System.out.println(member1.getWallet());


		// Member.toString()
		System.out.println(member1);


		// Debit more than what he has
		/*try {
			member1.debitWallet(1000);
		} catch (MissAmountException e) {
			e.printStackTrace();
		}
		System.out.println(member1.getWallet());*/

		// What is the Network when unset ? null
		// System.out.println(member1.getNetwork());
	}

	/* All tests around Network and Admin linked with Network
	 *
	 * Create Network
	 * Member already in Networks
	 * Add Admin to Network
	 * Create Member from Admin and Network
	 * Add and Remove Member from Network
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


	//	Try to add an Admin to a Network
		/*try {
			admin.setNetwork(admin.getNetwork());
		} catch (AlreadyInNetwork | CantSetNetworkAdmin alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}*/
		/*try {
			admin.getNetwork().addMember(admin);
		} catch (AlreadyInNetwork | CantSetNetworkAdmin alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}*/


	//	Create a Member directly in Network
		/*System.out.println(
				admin.getNetwork()
						.createMember(100, "Member", new SocialClassZero()).getNetwork().getName()
		); // Check the name of the created Member's Network*/


	//	Add a Member by Network
		/*Member member1 = new Member(0, "Thomas", new SocialClassHalf());
		try {
			admin.getNetwork().addMember(member1);
		} catch (AlreadyInNetwork | CantSetNetworkAdmin alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}
		System.out.println(member1.getNetwork().getName());

	//	Remove from Network
		try {
			admin.getNetwork().removeMember(member1);
		} catch (NotInNetwork notInNetwork) {
			notInNetwork.printStackTrace();
		}
		System.out.println(member1.getNetwork());
		System.out.println(admin.getNetwork()); // Test Network.toString()*/


		//	Create a Member by Admin
		/*try {
			System.out.println(admin.createMember(100, "Member", new SocialClassZero()).getNetwork().getName());
		} catch (NotInNetwork alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}*/

	//	Destruct a Network
	}

	/* Tests around Services and Member
	* Add and Remove a Service to a Member
	* Check if 2 Services are same
	* */
	public static void TestServices(){
	//	2 Services are equal
		/*Service serv1 = new Service("Cooking", 10);
		Service serv2 = new Service("Cooking", 10);
		Service serv3 = new Service("Cooking", 5);
		System.out.println(serv1.equals(serv2)); // true
		System.out.println(serv1.equals(serv3)); // true*/


	//	Add and Remove Services of Member
		Service cooking = new Service("Cooking", 10);
		Service washing = new Service("Washing Clothes", 15);
		Service mowing = new Service("Mowing the Lawn", 5);
		Admin admin = new Admin(100, "Thomas", new SocialClassHalf());
		try {
			admin.createNetwork("THE");
		} catch (AlreadyInNetwork alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}
		try {
			Member member = admin.createMember(100, "Thomas", new SocialClassHalf());
			member.addService(cooking);
			member.addService(washing);
			System.out.println(member);
			member.removeService(washing);
			System.out.println(member);
			member.removeService(mowing);
		} catch (NotInNetwork | AlreadyHasService | DontHaveService notInNetwork) {
			notInNetwork.printStackTrace();
		}
	}

	/*
	* Try to create a Task and execute it to check the balances
	* */
	public static void TestTask(){
	//	Create the Admin, the Network and create some Members with the Service and not
		Admin admin = new Admin(1000, "admin", new SocialClassNormal());
		Network network = null;
		try {
			network = admin.createNetwork("The Network");
		} catch (AlreadyInNetwork alreadyInNetwork) {
			alreadyInNetwork.printStackTrace();
		}
		Member member1 = network.createMember(100, "Malo", new SocialClassZero());
		Member member2 = network.createMember(0, "Thomas", new SocialClassHalf());
		Member member3 = network.createMember(1000, "Paul", new SocialClassNormal());

		Service cooking = new Service("Cooking", 10);
		Service washing = new Service("Washing Clothes", 15);
		Service mowing = new Service("Mowing the Lawn", 5);

		try {
			member2.addService(cooking);
			member2.addService(washing);
			member2.addService(mowing);

			member3.addService(washing);
		} catch (AlreadyHasService alreadyHasService) {
			alreadyHasService.printStackTrace();
		}

		System.out.println(network);

	}
}
