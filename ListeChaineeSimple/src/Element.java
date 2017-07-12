
public class Element {
	private int info;
	private Element suivant;
	
	public Element(int i, Element next){
		info = i;
		suivant = next;
	}
	
	public Element(int i){
		this(i,null);
	}
	public int getInfo(){
		return info;
	}
	public Element getSuivant(){
		return suivant;
	}
	public void setSuivant(Element e){
		suivant = e;
	}
}
