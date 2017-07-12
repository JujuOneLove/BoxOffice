public class BoxOfficeChaine extends BoxOffice {
	
	private FilmChaine first;

	
	public BoxOfficeChaine (String listing){
		super(listing);
	}
	public FilmChaine getFirst(){
		//System.out.println("First : "+first.toString());
		return first;
	}
	
	public void ajoutTete(Film m){
		//System.out.println("Ajout Tete");
		FilmChaine nouveau = new FilmChaine(m,first);
		first = nouveau;
	}
	
	public void addFilm(Film m){  // ajout en Queue
		FilmChaine e = first;
			
		while(e!=null){
			if(e != m && e.getTitre().equals(m.getTitre())){
				e.setNbEntrees(e.getNbEntrees()+m.getNbEntrees());
				return;
			}
			e = e.getSuivant();
		}
		ajoutTete(m);
	}
	
	public FilmChaine meilleur1(){
		Film f = new Film("","",0,0);
		FilmChaine e = new FilmChaine(f,null);
		FilmChaine F = first;
		while(F!=null){
			if(F.getNbEntrees()>e.getNbEntrees() ){
				e.setTitre(F.getTitre());
				e.setRealisateur(F.getRealisateur());
				e.setAnnee(F.getAnnee());
				e.setNbEntrees(F.getNbEntrees());
			}
			F = F.getSuivant();
		}
		return e;
	}
	public FilmChaine meilleur2(){
		Film f = new Film("","",0,0);
		FilmChaine e = new FilmChaine(f,null);
		FilmChaine f1 = this.meilleur1();
		FilmChaine F = first;
		while(F!=null){
			if(F.getNbEntrees()>e.getNbEntrees() 
					&& F.getNbEntrees()!=f1.getNbEntrees()){
				e.setTitre(F.getTitre());
				e.setRealisateur(F.getRealisateur());
				e.setAnnee(F.getAnnee());
				e.setNbEntrees(F.getNbEntrees());
			}
			F = F.getSuivant();
		}
		return e;
	}
	public FilmChaine meilleur3(){
		Film f = new Film("","",0,0);
		FilmChaine e = new FilmChaine(f,null);
		FilmChaine f1 = this.meilleur1();
		FilmChaine f2 = this.meilleur2();
		FilmChaine F = first;
		while(F!=null){
			if(F.getNbEntrees()>e.getNbEntrees()
					&& F.getNbEntrees()!=f1.getNbEntrees()
					&& F.getNbEntrees()!=f2.getNbEntrees()){
				e.setTitre(F.getTitre());
				e.setRealisateur(F.getRealisateur());
				e.setAnnee(F.getAnnee());
				e.setNbEntrees(F.getNbEntrees());
			}
			F = F.getSuivant();
		}
		return e;
	}
	
	
	public String toString(){
		String res = "";
		//sort();
		FilmChaine e = first;
		res += this.meilleur1()+"\n";
		res += this.meilleur2()+"\n";
		res += this.meilleur3()+"\n";
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
			BoxOfficeChaine Chaine = new BoxOfficeChaine(args[0]);
			System.out.println(Chaine);
			System.out.println((System.currentTimeMillis()-debut)/1000.0+" secondes");
			
		}	
	}


}