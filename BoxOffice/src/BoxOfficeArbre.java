package src;

public class BoxOfficeArbre extends BoxOffice {
	
	private static FilmArbre racine;
	private FilmArbre premier = new FilmArbre(racine);
	private FilmArbre second = new FilmArbre(racine);
	private FilmArbre troisieme = new FilmArbre(racine);
	
	public BoxOfficeArbre (String listing) {
		super(listing);
		System.out.println("\n"+"Fichier : "+listing);
	}
	
	public void addFilm(Film f) {
		if(racine==null){
			racine = new FilmArbre(f); //http://www-sop.inria.fr/oasis/personnel/Guillaume.Dufay/MASS2/tp11/Arbre.java
		}
		else{
			FilmArbre a = racine;
			FilmArbre nouveau = new FilmArbre(f);
			boolean place = false;
			
			while(place==false){
				if(a.cle() < nouveau.cle()){
					if(a.getDroite()==null){
						a.setDroite(nouveau);
						place=true;
					}
					else{
						a=a.getDroite();
					}
				}
				else if(a.cle() > nouveau.cle()){
					if(a.getGauche()==null){
						a.setGauche(nouveau);
						place=true;
					}
					else{
						a=a.getGauche();
					}
				}
				else if(a.cle() == nouveau.cle()){
					if(a.getTitre().equalsIgnoreCase(nouveau.getTitre())){
						a.setNbEntrees(a.getNbEntrees()+nouveau.getNbEntrees());
						place=true;
					}
					else{
						a.setSuivant(nouveau);
						place=true;
					}
				}
			}
		}
		         
				
	}
	
	public int size(){
		return racine.size();
	}
	
	
	
	public void ParcoursPrefixe(FilmArbre f){
		System.out.println(f.toString());
		
		if(f.getGauche()!=null){
			ParcoursPrefixe(f.getGauche());
		}
		
		if(f.getDroite() != null){
			ParcoursPrefixe(f.getDroite());
		}
	}
	
	
	public void meilleur1(FilmArbre f){
		if(f.getGauche()!=null){
			meilleur1(f.getGauche());
		}
		
		if(f.getDroite() != null){
			meilleur1(f.getDroite());
		}
		if(premier.getNbEntrees() < f.getNbEntrees()){
			premier=f;
		}
	}
	
	public void meilleur2(FilmArbre f){
		if(f.getGauche()!=null){
			meilleur2(f.getGauche());
		}
		
		if(f.getDroite() != null){
			meilleur2(f.getDroite());
		}
		if(second.getNbEntrees() < f.getNbEntrees() 
				&& f.getNbEntrees()!=premier.getNbEntrees()){
			second=f;
		}
	}
	
	public void meilleur3(FilmArbre f){
		if(f.getGauche()!=null){
			meilleur3(f.getGauche());
		}
		
		if(f.getDroite() != null){
			meilleur3(f.getDroite());
		}
		if(troisieme.getNbEntrees() < f.getNbEntrees() 
				&& f.getNbEntrees()!=premier.getNbEntrees()
				&& f.getNbEntrees()!=second.getNbEntrees()){
			troisieme=f;
		}
	}
	
	public String toString(){
		//this.ParcoursPrefixe(racine);
		this.meilleur1(racine);
		this.meilleur2(racine);
		this.meilleur3(racine);
		String res = "Nombre de lignes : "+nbLignes+" \n"+ "Nombres de films : "+this.size()+"  \n";
		res += this.premier+" \n";
		res += this.second+" \n";
		res += this.troisieme+" \n";

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
			BoxOfficeArbre ABR = new BoxOfficeArbre(args[0]);
			System.out.println(ABR);
			System.out.println((System.currentTimeMillis()-debut)/1000.0+" secondes");
		}	
	}
}

