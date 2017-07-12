public class FilmHash extends Film {
	
	private FilmHash suivant;
	
	public FilmHash(Film f, FilmHash next){
		super(f);
		suivant = next;
	}
	
	public FilmHash(FilmHash f){
		this(f, null);
	}
	
	public int cle() {
		int cle = this.getTitre().hashCode();
		return Math.abs(cle);
	}
	
	public FilmHash getSuivant(){
		return suivant;
	}
	public void setSuivant(FilmHash fc){
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