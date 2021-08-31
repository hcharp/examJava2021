public class CLIKP {

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

