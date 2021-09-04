public class CLIOutils {
    
    public static CLI fromClass(Configuration myConf) {

        CLI myCLI;
        myCLI.alpha = new Option('A',"Valeur de alpha", myConf.alpha);
        myCLI.epsilon = new Option('E',"Valeur de la précision à atteindre", myConf.epsilon);
        myCLI.indice = new Option('K',"Valeur de l'indice à calculer", myConf.indice);

        if (myConf.mode == Mode.Creuse)
        {
            myCLI.mode = new Option('C',"Matrice mode creuse");
        }
        else
        {
            myCLI.mode = new Option('P',"Matrice mode pleine");
        }

        return myCLI;
    }

}
