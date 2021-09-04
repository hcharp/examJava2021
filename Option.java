public class Option {

	public Option(char acces, String description, Object valeur) {
		this.acces = acces;
		this.description = description;
		this.valeur = valeur; // pas si pleine/creuse

	}

	public Option(String description, char acces) {
		this.description = description;
		this.acces = acces;
	}

	public String description;
	public Object valeur;
	public char acces;
	
}

// TODO: Au lieu de Object, on peut utiliser Template, plus efficace en Java qui le gère, et qui évite de caster
