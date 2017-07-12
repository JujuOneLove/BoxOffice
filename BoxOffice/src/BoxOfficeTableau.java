//import java.util.Arrays;

public class BoxOfficeTableau extends BoxOffice {
	
	public final static int TAILLE_INITIALE = 100;
	private Film[] lesFilms;
	public int nbF;
	
	
	public BoxOfficeTableau(String listing){
		super(listing);
	}
	
	public void addFilm(String titre, String realisateur, int annee, int nbEntrees){
		if(lesFilms==null){
			nbF = 0;
			lesFilms = new Film[TAILLE_INITIALE];
		}
			
		Film f = new Film(titre, realisateur, annee, nbEntrees);
		
		
		for(int i=0; i<nbF;i++){ // si le film existe déja 
			if(lesFilms[i] != f && lesFilms[i].getTitre().equals(titre)){
				lesFilms[i].setNbEntrees(lesFilms[i].getNbEntrees()+nbEntrees);
				return;
			}
		}
		lesFilms[nbF++] = f; // ajout du film
		
		if(nbF == lesFilms.length){
			Film [] newTab = new Film[lesFilms.length*2];
			for(int i=0; i<lesFilms.length; i++){
				newTab[i] = lesFilms[i];				
			}
			lesFilms = newTab;
		}
	}
	
	public Film meilleur1(){
		Film f = new Film("","",0,0);
		for(int i=0; i<nbF; i++){
			if(lesFilms[i].getNbEntrees()>f.getNbEntrees() ){
				f = lesFilms[i];
			}
		}
		return f;
	}
	public Film meilleur2(){
		Film f = new Film("","",0,0);
		Film f1 = this.meilleur1();
		for(int i=0; i<nbF; i++){
			if(lesFilms[i].getNbEntrees()>f.getNbEntrees()
					&&lesFilms[i].getNbEntrees()!=f1.getNbEntrees()){
				f = lesFilms[i];
			}
		}
		return f;
	}
	public Film meilleur3(){
		Film f = new Film("","",0,0);
		Film f1 = this.meilleur1();
		Film f2 = this.meilleur2();
		for(int i=0; i<nbF; i++){
			if(lesFilms[i].getNbEntrees()>f.getNbEntrees() 
					&&lesFilms[i].getNbEntrees()!=f1.getNbEntrees()
					&&lesFilms[i].getNbEntrees()!=f2.getNbEntrees()){
				f = lesFilms[i];
			}
		}
		return f;
	}
	
	
	public String toString(){
		String res = "Nombre de lignes : "+nbLignes+" \n"+ "Nombres de films : "+nbF+" \n";
		//tri();
		
		res += this.meilleur1()+"\n";
		res += this.meilleur2()+"\n";
		res += this.meilleur3()+"\n";
		
		return res;
	}

	
	public static void main(String[] args){
		long debut = System.currentTimeMillis();
		if(args.length<1)
			System.err.println("Nom de fichier manquant");
		else {
			BoxOfficeTableau tab = new BoxOfficeTableau(args[0]);
			System.out.println(tab);
			System.out.println((System.currentTimeMillis()-debut)/1000.0+" secondes");
		}
			
	}

	@Override
	public void addFilm(Film f) {
		// TODO Auto-generated method stub
		
	}

	
}
