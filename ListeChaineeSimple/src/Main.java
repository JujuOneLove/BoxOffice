
public class Main {

	public static void main(String[] args) {
		ListeChainee Lc = new ListeChainee();
		Lc.ajoutTete(3);
		Lc.ajoutTete(5);
		Lc.ajoutTete(9);
		Lc.ajoutTete(3);
		Lc.print();
		Lc.search(4);
		Lc.removeAll(3);
		Lc.ajoutTete(7);
		Lc.print();
		Lc.duplicateReverse();
		Lc.print();
		
	}

}
