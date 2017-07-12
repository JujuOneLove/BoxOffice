
public class File {
	private int [] file;
	private int debut, fin, nbElement;
	
	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public File(int n){
		file = new int[n];
		this.debut = 0;
		this.fin = 0;
		this.nbElement = 0;
	}
	
	public boolean empty(){
		return nbElement == 0 ;
	}
	
	public int size(){
		System.out.println("Taille : "+nbElement);
		return nbElement;
	}
	
	public void affiche(){
		for(int elt : file){
			System.out.println("Element: "+elt);
		}
	}
	
	public boolean enQueue(int i){
		System.out.println("Ajout en fin : " +i);
		if(nbElement < file.length){
			file[fin]=i;
			nbElement++;
			fin = (fin+1)%file.length;
		}
		return false;
	}
	
	public int deQueue(){
		System.out.print("Suppression de la tete : ");
		if(!empty()){
			nbElement--;
			int val = file[debut];
			debut++;
			if(debut >= file.length)
				debut = 0;
			System.out.println(val);
			System.out.println(debut);
			return val;
		}
		return -1;
	}
	
	public static void main(String[] args){
		File f = new File(5);
		System.out.println("nb : "+f.nbElement);
		f.enQueue(3);
		f.enQueue(4);
		f.enQueue(5);
		f.affiche();
		f.deQueue();
		f.affiche();
		f.size();

	}
}
