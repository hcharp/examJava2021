public class Option {

	public Option(char acces, String description, Object valeur) {
		this.acces = acces;
		this.description = description;
		this.valeur = valeur; // pas si pleine/creuse

	}

	public Option(String description, Char acces) {
		this.description = description;
		this.acces = acces;
	}

	public String description;
	public Object valeur;
	public Char acces;
	
}

