public class Personnes {
    /* Les propriétés (ou attributs) définies dans une classe
     * correspondant aux caractéristique des objets qui vont
     * etre crées à partir de cette classe.
     * 
     */

    public String prenom = "défaut";
    public String nom;
    private int age;

    /** CONSTRUCTEUR
     * Un costructeur est une méthode qui est exécutée quand un objet est instancié.
     * Toutes les classes ont un constructeur par défaut dans Java. 
     * Ce constructeur a le meme nom de la calsse. Par exemple : 
     * Personnes p ) new Personnes();
     * 
     * On peut définir un nouveau constructeur.
     *     Un constructeur ne DOIT PAS retouner une valeur. Donc il n'u a pas de type 
     *     avant le nom de la méthode lors de la declaration.
     * En géneral, les condtructeurs sont utilisés pour inintialiser la valeur des
     *     propriétés de l'objet. 
     */
    public Personnes(String name, String firstname, int old){
        nom = name;
        prenom = firstname;
        age = old;
        // coeur / l'instruction
    }
    /**
     * Quand on définit un constructeur, le constructeur par defaut n'est plus accessible.
     * Si on veut l'utiliser à nouveau, il  faut déclarer un constructeur sans argument.
     * NB : on peut laisser les {} vides si aucune instruction ne doit etre exécuteé.
     * PS : on peut déclarer autant de constructeurs que l'on veut
     */
    public Personnes(){}
    public Personnes (String name, int old, String firstname){ 
        // constructeru il doit avoir le meme nom que la classe comme exemple "Personnes"
        // il faut changer l'ordre ou le nombre de var ou les noms de variable sinon ca va etre duplicate avec la 1er fonction(pour moi :D)
    }
    public Personnes(String prenom, String nom){
        this.prenom= prenom;
        this.nom= nom;
        // this represante l'objet (on parle de la proprité objet)
    }
    /**
     * Une fonction dans une calsse est appelée une METHODE.
     * @return String concaténation du prenom et du nom
     */

    public String identite(){
        System.out.println("la fonction identite est exécutée");
        return this.prenom + "" + this.nom;
    //  this represante l'objet
    }
    public String identite(boolean vrai){
        return this.prenom+ " " + this.nom + ", agé de " + this.age + " ans";
    }
    public int getAge(){
        return this.age;
    } // get = pour recuperer
    public void  setAge (int age){
       this.age = age;
    //set = pour definir
    }

}