public class Action {

	public static void faire(acces, finOptions) {
		

		switch (arg) {
			case "-K": // Valeur de l'indice à calculer
				try {
					config.indice = Integer.parseInt(args[++i]);
				} catch (Exception e) {
					System.out.println("Pas le bon type.");
				}
				break;
			case "-E": // Valeur de la précision à atteindre
			try {
				config.epsilon = Double.parseDouble(args[++i]);
			} catch (Exception e) {
				System.out.println("Pas le bon type.");
			}
				break;
			case "-A": // Valeur de alpha
			try {
				config.alpha = Double.parseDouble(args[++i]);
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
				finOptions = arg.length() == 0 || arg.charAt(0) != '-';
				if (! finOptions) {
					System.out.println("Option inconnue : " + arg);
				}
		}

	}	
}

