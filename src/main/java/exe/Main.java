package exe;

import network.Member;
import network.SocialClassHalf;

public class Main {

	public static void main(String[] args) {
		TestMember();
	}

	/*
	 * Try to create a Member
	 * Check what the network value when no Network
	 * */
	public static void TestMember(){
		Member member1 = new Member(0, "Thomas", new SocialClassHalf());
		member1.creditWallet(1000);
		System.out.println(member1.getWallet());
		// What is the Network when unset ?
		System.out.println(member1.getNetwork());
	}

	/*
	 * Try to create a Network from an Admin
	 * Add Members, create them
	 * */
	public static void TestNetwork(){

	}

	/*
	* Try to create a Task and execute it to check the balances
	* */
	public static void TestTask(){

	}
}
