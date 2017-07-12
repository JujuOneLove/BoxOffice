
public class ListeChainee {
	private Element first;
	
	public ListeChainee(){
		first = null;
	}
	
	public Element getFirst(){
		return first;
	}
	
	public int size(){
		Element e = first;
		int nbElement = 0;
		while(e!=null){
			e = e.getSuivant();
			nbElement++;
		}
		return nbElement;
	}
	
	public void print(){
		Element e = first;
		while(e!=null){
			System.out.println(e.getInfo());
			e = e.getSuivant();
		}
	}
	
	public boolean search(int i){
		Element e = first;
		while(e!=null){
			if(e.getInfo() == i){
				System.out.println("Trouve : "+i);
				return true;
			}
			e = e.getSuivant();
		}
		System.out.println("Pas Trouve : "+i);
		return false;
	}
	
	public void ajoutTete(int i){
		Element nouveau = new Element(i,first);
		first = nouveau;
	}
	
	public void ajoutQueue(int i){
		if(first==null)ajoutTete(i);
		else{
			Element dernier = first;
			while(dernier.getSuivant() != null)
				dernier = dernier.getSuivant();
			dernier.setSuivant(new Element(i,null));
		}
	}
	
	public boolean ajout(int i, int position){
		if(position == 0){
			ajoutTete(i);
			return true;
		}
		else{
			int positionCourante = 0;
			Element precedent = null;
			Element e = first;
			while(e!=null && positionCourante<position){
				positionCourante++;
				precedent = e ;
				e = e.getSuivant();
			}
			if(positionCourante < position)return false;
			Element nouveau = new Element(i,e);
			precedent.setSuivant(nouveau);
			return true;
		}
	}
	
	public boolean remove(int i){
		Element e = first;
		Element precedent = null;
		while(e!=null && e.getInfo() != i){
			precedent = e;
			e = e.getSuivant();
		}
		if(e==null)return false;
		if(precedent != null){
			precedent.setSuivant(e.getSuivant());
		}
		else
			first = first.getSuivant();
		return true;
	}
	
	public boolean removeAll(int i){
		boolean trouve = false;
		while(first != null && first.getInfo() == i){
			first = first.getSuivant();
			trouve = true;
		}
		if(first == null)return true;
		
		Element precedent = first;
		Element e = precedent.getSuivant();
		
		while(e!=null){
			if(e.getInfo() != i){
				precedent =e;
				e=e.getSuivant();
			}
			else{
				trouve = true;
				while(e!=null && e.getInfo()==i){
					e=e.getSuivant();
				}
				precedent.setSuivant(e);
			}
		}
		return true;
	}
	
	public boolean removePosition(int i){
		Element precedent = null;
		Element e = first;
		int pos = 0;
		while(e!=null && pos < i){
			pos++;
			precedent = e;
			e=e.getSuivant();
		}
		if(e==null)return false;
		if(precedent == null)first = first.getSuivant();
		else precedent.setSuivant(e.getSuivant());
		return true;
	}
	
	/*ListeChainee duplicate(){
		ListeChainee nouvelle = new ListeChainee();
		Element e = first;
		while(e!=null){
			nouvelle.ajoutQueue(e.getInfo());
			e=e.getSuivant();
		}
		return nouvelle;
	}
	*/
	ListeChainee duplicate(){
		ListeChainee nouvelle = duplicateReverse();
		return nouvelle.duplicateReverse();		
	}
	
	ListeChainee duplicateReverse(){
		ListeChainee nouvelle = new ListeChainee();
		Element e = first;
		while(e!=null){
			nouvelle.ajoutTete(e.getInfo());
			e=e.getSuivant();
		}
		return nouvelle;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
