
public class Pile {
	
	private int [] pile;
	private int taille;
	
	public Pile(int n){
		taille = 0;
		pile = new int[n];
	}
	
	public boolean push(int i){
		System.out.println("Ajout en tete de : "+i);
		if(taille == pile.length){
			return false;
		}
		else{
			pile[taille] = i;
			taille++;
			return true;
		}
	}
	
	public int pop(){
		System.out.println("suppression en fin : ");
		if(!empty()){
			taille--;
			return pile[taille];
		}
		return -1;
	}
	
	public void affiche(){
		for (int i = 0; i<taille;i++)
			System.out.println("Pile: "+pile[i]);
	}
	
	public boolean empty(){
		return (taille == 0);
	}
	
	public int size(){
		System.out.println("Taille : "+taille);
		return taille;
	}
	
	
	public static void main(String[] args){
		Pile p = new Pile(5);
		p.push(2);
		p.push(4);
		p.push(17);
		p.affiche();
		p.pop();
		p.affiche();
		p.size();
	}
}
