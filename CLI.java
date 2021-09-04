public class CLI {

	private static Option alpha;
	private static Option epsilon;
	private static Option indice;
	private static Option mode;

	public static Configuration configuration(String... args) {

		Configuration config = new Configuration();
		boolean finOptions = false;
		int i = 0;
		while (i < args.length && ! finOptions) {
			String arg = args[i];
			switch (arg) {
				case "-K": // Valeur de l'indice à calculer
					try {
						config.indice = Integer.parseInt(args[++i]);
						indice = new Option('K',"Valeur de l'indice à calculer", config.indice);
					} catch (Exception e) {
						System.out.println("Pas le bon type.");
					}
					break;
				case "-E": // Valeur de la précision à atteindre
				try {
					config.epsilon = Double.parseDouble(args[++i]);
					epsilon = new Option('E',"Valeur de la précision à atteindre", config.epsilon);
				} catch (Exception e) {
					System.out.println("Pas le bon type.");
				}
					break;
				case "-A": // Valeur de alpha
				try {
					config.alpha = Double.parseDouble(args[++i]);
					alpha = new Option('A',"Valeur de alpha", config.alpha);
				} catch (Exception e) {
					System.out.println("Pas le bon type.");
				}
					break;
				case "-C": // Mode matrice creuse
					config.mode = Mode.CREUSE;
					mode = new Option('C', "Mode matrice creuse");
					break;
				case "-P": // Mode matrice pleine
					config.mode = Mode.PLEINE;
					mode = new Option('P',"Mode matrice pleine");
					break;
				default:
					finOptions = arg.length() == 0 || arg.charAt(0) != '-';
					if (! finOptions) {
						System.out.println("Option inconnue : " + arg);
					}
			}
			i++;
		}
		return config;
	}

	public static void main(String[] args) {
		System.out.println(configuration(args));
	}
}

