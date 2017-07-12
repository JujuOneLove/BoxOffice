public class FilmChaine extends Film {
	
	private FilmChaine suivant;
	
	public FilmChaine(Film f, FilmChaine next){
		super(f);
		suivant = next;
	}
	
	public FilmChaine(FilmChaine f){
		this(f, null);
	}

	public FilmChaine getSuivant(){
		return suivant;
	}
	public void setSuivant(FilmChaine fc){
		suivant = fc;
	}

	public String getTitre() {
		return super.getTitre();
	}
	public void setTitre(String titre) {
		super.setTitre(titre);
	}
	public String getRealisateur() {
		return super.getRealisateur();
	}
	public void setRealisateur(String realisateur) {
		super.setRealisateur(realisateur);
	}
	public int getAnnee() {
		return super.getAnnee();
	}
	public void setAnnee(int annee) {
		super.setAnnee(annee);
	}
	public int getNbEntrees() {
		return super.getNbEntrees();
	}
	public void setNbEntrees(int nbEntrees) {
		super.setNbEntrees(nbEntrees);
	}
	public String toString(){
		return super.toString();
	}
}