import java.util.List;

public class CLIClassiqueKP {

	public List <Option> options;

	public void ajouterOption(Option option) {

		options.add(option);

	}

	public static Configuration analyser(String ... arguments) {

		Configuration config = new Configuration();

		int i = 0;
		while (i < arguments.length) {
			if (i+1 < arguments.length) {
			Action.faire(config, arguments[i], arguments[++i]);
			
			} else if (arguments[i] == "-C" || arguments[i] == "-P") {
				Action.faire(config, arguments[i], 0);
			}

			i++;
		}
		return config;
	}

	public static void main(String[] args) {

		System.out.println(analyser(args));

	}
}

