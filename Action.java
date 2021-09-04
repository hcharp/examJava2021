public class Action {

	public static void faire(Configuration config, String acces, Object valeur) {
		
		switch (acces) {
			case "-K": // Valeur de l'indice à calculer
				try {
					config.indice = (int)valeur;
				} catch (Exception e) {
					System.out.println("Pas le bon type.");
				}
				break;
			case "-E": // Valeur de la précision à atteindre
			try {
				config.epsilon = (double)valeur;
			} catch (Exception e) {
				System.out.println("Pas le bon type.");
			}
				break;
			case "-A": // Valeur de alpha
			try {
				config.alpha = (double)valeur;
			} catch (Exception e) {
				System.out.println("Pas le bon type.");
			}
				break;
			case "-C": // Mode matrice creuse
				config.mode = Mode.CREUSE;
				break;
			case "-P": // Mode matrice pleine
				config.mode = Mode.PLEINE;
				break;
			default:
				System.out.println("Option inconnue : " + acces);
		}

	}	
}

