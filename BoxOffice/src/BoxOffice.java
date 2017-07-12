import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BoxOffice {
	
	private String listing; 
	protected int Annee,nbEntrees;
	protected String nomFilm,Reali,An,nbE;
	public int nbLignes = 0;
		
	public abstract void addFilm(String titre, String realisateur, int annee, int nbEntrees);
	public abstract void addFilm(Film f);
	
	public BoxOffice (String listing) {
		this.listing=listing;
		System.out.println("Fichier : "+listing);
		Scanner scanner;
		try{
			scanner = new Scanner(new File(listing));
			// On boucle sur chaque ligne
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				nbLignes++;
				//faites ici votre traitement
				//System.out.println("Chaine lue : "+line);
				String [] tab = line.split("\t");
				/*for(int i =0; i<tab.length; i++){
					System.out.println("Chaine : "+i + " : "+ tab[i]);
				}*/
				if(tab.length < 5){
					System.out.println("Erreur nb attributs : "+tab.length );
				}
				else{
					nomFilm = tab[0].split("FILM :")[1].trim();
					Reali = tab[1].split(":")[1].trim();
					An = tab[2].split(":")[1].trim();
					nbE = tab[4].split(":")[1].trim();
					Annee = Integer.parseInt(An);
					nbEntrees = Integer.parseInt(nbE);
					Film f = new Film(nomFilm,Reali,Annee,nbEntrees);
					addFilm(nomFilm, Reali, Annee, nbEntrees);
					addFilm(f);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e ){
			e.printStackTrace();
		}
		
	}
	public int getNbLignes() {
		return nbLignes;
	}

	

}


