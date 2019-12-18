package network;

public class SocialClassZero implements SocialClass {

	public String toString(){
		return "Zero";
	}
	
	// renvoie pour la socialClasseZero le prix à 0 car pour cette classe c'est gratuit. 
	public int calc(int price) {
		return 0;
	}
}
