# examJava2021
Examen Java - 1ère année du cycle ingénieur AISL du Cnam


* [Exercice 1](#exercice-1)
* [Exercice 2](#exercice-2)
* [Exercice 3](#exercice-3)
* [Exercice 4](#exercice-4)
* [Exercice 5](#exercice-5)
* [Exercice 6](#exercice-6)
* [Exercice 7](#exercice-7)



## Exercice 1


### 1.1. On considère une poignée p de type T initialisée avec un objet de la classe C. Indiquer comment est traité en Java l’appel de la méthode m suivant, a et b étant des variables. On précisera ce que l’on doit connaître de a et b pour traiter cette question.
    T p = new C();
    p.m(a, b);

On applique à l'instance p de la classe C la méthode m (par exemple : voiture1.avance, voiture1 étant une instance de la classe Voiture, de type String).
Il faut connaître les types de a et de b.


### 1.2. Considérons la déclaration du listing suivant. Nous supposons qu’elle apparaît dans la classe Point vue en cours, TD et TP.

    public class Point {
        public static final Point origine = new Point(0, 0);
        ...
    }


### 1.2.1. Expliquer ce que signifient les mots-clés public , static et final.

* public : mot-clé d'accès.
Pour une classe : depuis n'importe où, même à l'extérieur des packages.
Pour une méthode : depuis toute classe.
Pour une variable : depuis toute classe.

* static : mot-clé pour l'économie de mémoire.
Indique qu'une seule instance peut être créée 

* final : Empêche la modification.
Impossible de redéfinir une variable, une méthode, et impossible d'hériter d'une autre classe.
Un constructeur ne peut pas être "final".
Les variables d'une interface sont "final" par défaut.

### 1.2.2. Indiquer, en justifiant la réponse, si on peut être sûr que l’attribut origine de la classe Point aura toujours pour coordonnées (0, 0).

Si on le définit en "final", oui. Sinon non.

### 1.3. On veut écrire une méthode classer qui ajoute chaque élément d’une première liste soit dans une liste petits soit dans une liste grands suivant que l’élément est plus petit ou plus grand qu’une valeur pivot. Un appel à cette méthode pourrait être le suivant :
`classer(pivot, elements, petits, grands);`


### 1.3.1. Donner la signature de cette méthode.

    // Je vais dire que les éléments, c'est des entiers, mais ça pourrait être aussi de type Element
    public void classer(int pivot, int [] elements , int [] petits, int [] grands) {
        
    }

### 1.3.2. Écrire le code de cette méthode.

    // Je vais dire que les éléments, c'est des entiers, mais ça pourrait être aussi de type Element
    public void classer(int pivot, int [] elements , int [] petits, int [] grands) {

        for (element in elements) {
            if (element < pivot) {
                petits.add(element);
            } else if (element > pivot) {
                grands.add(element);
            } else {
                Sytem.out.println("C'est le pivot. Bye-ee.");
            }
        }
        
    }


### 1.4. Indiquer où sont utilisés les patrons suivants dans la bibliothèque Swing : Composite, Stratégie, Observateur.

Composite : Lorsque l'on crée l'interface.
=> Container (avec Panel, Window, Component dedans), Component (avec Button, Field, ...)

Stratégie : Lorsque l'on place les objets (boutons, menus)
=> LayoutManager (Border, Flow, Grid pour savoir où on les place)

Observateur : Avertir lors d'une action (clic par exemple)
=> Listener

---
[retour en haut](#examjava2021)
## Exercice 2


### 2.1. Expliquer ce que signifie @Override . Pourquoi apparait-elle ici ? Est-elle obligatoire ?

@override est utilisé pour redéfinir une méthode d'une classe dont on hérite et permet de vérifier qu'on le fait correctement (nom de la méthode, arguments, ...), et renvoie un avertissement sinon.
Elle apparaît ici parce que toString, ça existe déjà en Java, on redéfinit la méthode en ajoutant des return pour alpha et epsilon.

### 2.2. Expliquer pourquoi les attributs ne devraient pas être déclarés publics et indiquer le droit d’accès qu’il faudrait leur donner.

Il vaudrait mieux mettre les attributs en `private` pour que l'utilisateur ne puisse pas modifier les valeurs de alpha, epsilon et indice. (Exemple de la gravité : il vaut mieux ne pas laisser en `public` la valeur de g = 9.81 ; idem avec le nombre de minutes dans une heure, etc)

### 2.3. On souhaite savoir si deux objets c1 et c2 de type Configuration sont égaux (même valeur des attributs). Est-ce qu’écrire c1.equals(c2) est possible ? Dans l’affirmative, est-ce que le résultat est le bon ? Dans la négative à l’une des deux questions précédentes, que faut-il faire pour que cette expression soit acceptée et donne le résultat attendu ?

Il faut surcharger la méthode equals(). Elle permet de comparer des String, des types numériques et des booléens, mais là il y a plusieurs éléments dans un objet de type Configuration (double, double, int, Mode).
Donc il va falloir ajouter une surcharge :

    @override
    public boolean equals() {
        // pour chaque éléments qui compose un objet de type Configuration
        // if (avec un get pour obtenir cet élément).equals(this.leMemeGet()) {
            return True;
        } else  {
            return False;
        }
    }

---
[retour en haut](#examjava2021)
## Exercice 3


### 3.1. Écrire une classe de test JUnit qui ne fait qu’un seul test : l’exemple du sujet.

Voir fichier [CLIClassiqueTest](CLIClassiqueTest.java).

### 3.2. Voici le résultat que l’on obtient quand on exécute : java CLIClassique -K 15.5 -P 
__Que peut-on en déduire sur le programme ?__

Il y a un problème au moment de parser la chaîne de caractères "15.5" vers des entiers.
En même temps, 15.5, c'est pas vraiment un entier, mais un float (d'où le NumberFormatException).

### 3.3. L’exception NumberFormatException n’est pas vérifiée par le compilateur. Peut-on le déduire de la lecture du listing 3 ? La réponse doit être justifiée.

On ne peut pas vérifier que c'est un entier parce que c'est déjà compilé quand on donne l'argument qui n'est pas castable en entier.
On pourrait ajouter dans la classe CLIClassique un try catch except pour que ça ne fasse pas tout planter dans l'application mais juste afficher une erreur plus _user experience_.

### 3.4. On veut afficher un message d’erreur à l’utilisateur si les valeurs de alpha, indice ou epsilon ne sont pas au bon format. Comment modifier ce programme pour obtenir ce résultat, sachant que le  message pourrait apparaître plusieurs fois si plusieurs erreurs sont commises par l’utilisateur ? Répondre directement sur le sujet.

Voir fichier [CLIClassique](CLIClassique.java).

### 3.5. Ce programme contient encore des erreurs. Lesquelles ?

????

---
[retour en haut](examjava2021)
## Exercice 4


### 4.1. Dessiner le diagramme de classe qui fait apparaître les éléments mentionnés dans les paragraphes précédents. Pour assurer la traçabilité entre le paragraphe et l’élément on mettra à côté de l’élément le numéro du paragraphe correspondant dans un cercle.

Voir fichiers [DiagClass](DiagClass.drawio)

### 4.2. Écrire avec ce nouveau framework l’équivalent du programme du listing 3 en se limitant aux options K et P.

Voir fichier [CLIKP](CLIKP.java)

### 4.3. Indiquer la structure de données de l’API des collections à utiliser pour stocker les options d’une CLI. La réponse doit être justifiée.

Une liste permet d'ajouter des éléments. Une ArrayList permet un accès direct et plus efficace aux données.

---
[retour en haut](#examjava2021)
## Exercice 5


### 5.1. Expliquer comment produire la vue.

La fenêtre sert de racine (JFrame), on y lie les éléments suivants :

Un premier panneau (JPanel) contient :
- des boutons(JButton) Creuse et Pleine sur une ligne avec FlowLayout.CENTER pour que les deux boutons soient sur la même ligne, centrés

Un deuxième panneau avec BoxLayout pour que les éléments soient alignés les uns avec les autres : 
- des descriptions textuelles (JLabel)
- des champs textes éditables (JTextField)
- des boutons

Un troisième et dernier panneau : 
- une barre d'état (JLabel)



### 5.2. Expliquer comment faire pour que « -C » soit ajouté en bas quand l’utilisateur clique sur « Creuse (C) ».

Il faut un observateur avec Listener qui va réagir au clic de l'utilisateur.
On récupère tout ce qui est écrit (chaîne a) dans la barre d'état, et on concatène cette chaîne avec la chaîne "-C", puis on remplace dans la barre d'état :
a = a + "-C";

---
[retour en haut](#examjava2021)
## Exercice 6


### 6.1. Dans la classe CLIOutils, définir une méthode de classe fromClass qui retourne un objet de type CLI construit à partir du nom d’une classe de configuration en respectant les règles précédentes. On ne traitera pas les actions associées aux options.

Voir fichier [CLIOutils](CLIOutils.java).

### 6.2. Expliquer comment on pourrait traiter les actions associées aux options.

Dans la classe Action, on a la méthode faire, qui traite les actions selon les accès.
On pourrait interroger myConf pour savoir quel accès est concerné, et faire deux cas : celui où l'accès est C ou P, donc pas de valeur, ou non.
Et on appelle la méthode de classe dans CLIOutils.

---
[retour en haut](#examjava2021)
## Exercice 7


### 7.1. Écrire une DTD telle que le document du listing 4 lui soit conforme.

Voir fichier [CLI.dtd](CLI.dtd)


### 7.2. Produire un fichier XML conforme à la DTD précédente à partir d’un objet CLI.

Voir fichier [anotherCLI.xml](anotherCLI.xml))

### 7.3. La définition des arguments de la ligne de commande pourrait se faire directement sous la forme d’un fichier XML comme le précédent. Expliquer comment il pourrait être exploité en Java pour produire un objet CLI.

Il suffit de parser un fichier XML avec SAX : en effet, SAX reconnaît la syntaxe XML et peut le convertir en JDOM, un DOM adapté à Java (lisibilité, utilisation des bibliothèques, ...). Il faut ensuite modifier le code pour actualiser la valeur des paramètres.
