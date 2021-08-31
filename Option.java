public class Option {

	public Option(String description, Object valeur, Char acces) {
		this.description = description;
		this.valeur = valeur; // pas si pleine/creuse
		this.acces = acces;
	}

	public Option(String description, Char acces) {
		this.description = description;
		this.acces = acces;
	}

	public String description;
	public Object valeur;
	public Char acces;
	
}

