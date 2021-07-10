public class CLIClassiqueKP {

	public Option[] options;

	public static ajouterOption(option) {

		options.add(option);

	}

	public static analyser(arguments) {

		Configuration config = new Configuration();
		boolean finOptions = false;
		int i = 0;
		while (i < args.length && ! finOptions) {
			String arg = args[i];

			faire(acces, finOptions);

			i++;
		}
		return config;
	}

	public static void main(String[] args) {
		System.out.println(configuration(args));
	}
}

