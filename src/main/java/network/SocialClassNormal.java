package network;

public class SocialClassNormal implements SocialClass {

	public String toString(){
		return "Normal";
	}
	
	// renvoie le prix sans modification pour la socialClasseNormale. 
	public int calc(int price) {
		return price;  
	}
}
