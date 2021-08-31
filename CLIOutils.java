public class CLIOutils {
    
    public static CLI fromClass(Configuration myConf) {

        CLIClassique myCLI;
        myCLI.alpha = Option('A',"Valeur de alpha", myConf.alpha);
        myCLI.epsilon = Option('E',"Valeur de la précision à atteindre", myConf.epsilon);
        myCLI.indice = Option('K',"Valeur de l'indice à calculer", myConf.indice);

        if (myConf.mode == Mode.Creuse)
        {
            myCLI.mode = Option('C',"Matrice mode creuse");
        }
        else
        {
            myCLI.mode = Option('P',"Matrice mode pleine");
        }

        return myCLI;
    }

}
