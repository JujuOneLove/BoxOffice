package src;

public class FilmArbre extends Film {
		
	private FilmArbre gauche;
	private FilmArbre droite;
	private FilmArbre suivant;
	
	
	public FilmArbre(Film f, FilmArbre g, FilmArbre d, FilmArbre s){
		super(f);
		gauche = g; droite = d; suivant = s;
	}
	
	public FilmArbre(Film f){
		this(f, null, null, null);
	}
	
	public int cle() {
		return this.getTitre().hashCode()+this.getRealisateur().hashCode();
	}
	
	public int size(){
		int nbNoeuds = 1;
		if(gauche != null)
			nbNoeuds += gauche.size();
		if(droite != null)
			nbNoeuds += droite.size();
		return nbNoeuds ; 
	}

	public FilmArbre getSuivant() {
		return suivant;
	}

	public void setSuivant(FilmArbre suivant) {
		this.suivant = suivant;
	}
	
	public FilmArbre getGauche() {
		return gauche;
	}

	public void setGauche(FilmArbre gauche) {
		this.gauche = gauche;
	}

	public FilmArbre getDroite() {
		return droite;
	}

	public void setDroite(FilmArbre droite) {
		this.droite = droite;
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
		super.setRealisateur(realisateur);;
	}
	public int getAnnee() {
		return super.getAnnee();
	}
	public void setAnnee(int annee) {
		super.setAnnee(annee);;
	}
	public int getNbEntrees() {
		return super.getNbEntrees();
	}
	public void setNbEntrees(int nbEntrees) {
		super.setNbEntrees(nbEntrees);;
	}
	public String toString(){
		return super.toString();
	}
}