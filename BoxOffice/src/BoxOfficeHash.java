import java.util.Random;

public class BoxOfficeHash extends BoxOffice {
	
	public final int TAILLE_INITIALE = 100000; //100 000
	private FilmHash[] elements;
	private int nbF;
	
	public BoxOfficeHash (String listing){
		super(listing);
	}
	
	//http://imss-www.upmf-grenoble.fr/prevert/Prog/Java/Conteneurs/TableDeHachage.html
	public void addFilm(Film f){ //Ajout d'un film
		int index = 0;
		if(elements==null){
			nbF = 0;
			this.elements = new FilmHash[this.TAILLE_INITIALE];
		}
		FilmHash nouveau = new FilmHash(f,null);
		
		index = nouveau.cle() % elements.length;
		
		for(FilmHash fh = elements[index]; fh!=null;fh=fh.getSuivant()){ // si le film existe déja, tester dans les listes chainees a faire
			if(fh != nouveau && fh.getTitre().equals(nouveau.getTitre())){
				fh.setNbEntrees(fh.getNbEntrees()+nouveau.getNbEntrees());
				return;
			} 
			else if(fh != nouveau && !fh.getTitre().equals(nouveau.getTitre())
					&& fh.getSuivant()==null){
				fh.setSuivant(nouveau);
				nbF++;
				return;
			}
		}	
		
		elements[index] = nouveau; // ajout du film
		nbF++;
		//System.out.println(this.FacteurCharge());
		if(this.FacteurCharge()>=0.7){
			this.doublageTab();
		}
	}

	
	public FilmHash meilleur1(){
		
		Film f = new Film("","",0,0);
		FilmHash e = new FilmHash(f,null);
		
		for(int i=0; i<elements.length; i++){
			FilmHash first = elements[i];
			while(first!=null){
				if(first.getNbEntrees()>e.getNbEntrees() ){
					e.setTitre(first.getTitre());
					e.setRealisateur(first.getRealisateur());
					e.setAnnee(first.getAnnee());
					e.setNbEntrees(first.getNbEntrees());
				}
				first = first.getSuivant();
			}
		}
		return e;
	}
	
	public FilmHash meilleur2(){

		Film f = new Film("","",0,0);
		FilmHash e = new FilmHash(f,null);
		FilmHash p1 = this.meilleur1();
		
		for(int i=0; i<elements.length; i++){
			FilmHash first = elements[i];
			while(first!=null){
				if(first.getNbEntrees()>e.getNbEntrees() 
						&& first.getNbEntrees()!=p1.getNbEntrees()){
					e.setTitre(first.getTitre());
					e.setRealisateur(first.getRealisateur());
					e.setAnnee(first.getAnnee());
					e.setNbEntrees(first.getNbEntrees());
				}
				first = first.getSuivant();
			}
		}
		return e;
	}
	public FilmHash meilleur3(){
		Film f = new Film("","",0,0);
		FilmHash e = new FilmHash(f,null);
		FilmHash p1 = this.meilleur1();
		FilmHash p2 = this.meilleur2();
		
		for(int i=0; i<elements.length; i++){
			FilmHash first = elements[i];
			while(first!=null){
				if(first.getNbEntrees()>e.getNbEntrees() 
						&& first.getNbEntrees()!=p1.getNbEntrees()
						&& first.getNbEntrees()!=p2.getNbEntrees() ){
					e.setTitre(first.getTitre());
					e.setRealisateur(first.getRealisateur());
					e.setAnnee(first.getAnnee());
					e.setNbEntrees(first.getNbEntrees());
				}
				first = first.getSuivant();
			}
		}
		return e;
	}
	
	
	public double FacteurCharge(){
		return this.nbF/elements.length;
	}
	
	public void doublageTab(){
		FilmHash [] newTab = new FilmHash[elements.length*2];
		for(int i=0; i<elements.length; i++){
			newTab[i] = elements[i];				
		}
		elements = newTab;
	}
	
	public String toString(){
		String res = "Nombre de lignes : "+nbLignes+" \n"+ "Nombres de films : "+nbF+" \n";
		res += this.meilleur1()+" \n";
		res += this.meilleur2()+" \n";
		res += this.meilleur3()+" \n";

		return res;
	}
	

	@Override
	public void addFilm(String titre, String realisateur, int annee, int nbEntrees) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void main(String[] args){
		long debut = System.currentTimeMillis();
		if(args.length<1)
			System.err.println("Nom de fichier manquant");
		else {
			BoxOfficeHash hash = new BoxOfficeHash(args[0]);
			System.out.println(hash);
			System.out.println((System.currentTimeMillis()-debut)/1000.0+" secondes");
			
			
		}	
	}
	
	
}