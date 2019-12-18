package network;

public class SocialClassHalf implements SocialClass{

	public String toString(){
		return "Half";
	}
	
	// renvoie le prix diviser par deux pour la socialClasseHalf.
	public int calc(int price) {
		return price / 2;  
	}
	
}
