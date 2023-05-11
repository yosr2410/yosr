public class Main {
    public static void main(String[] args) {
        /** Lorsqu'on déclare une variable de type objet, on dit que l'on fait une INSTANCIATION.
         * Un objet est une INSTANCE d'une classe.
         */
        Personnes p = new Personnes("Onyme", "Anne", 50);
        // p.prenom = "Anne";
        // p.nom = "Onyme";
        // p.age = 50;
        // system.out.println(p); ca ne sert à rien
        System.out.println("Nom : " + p.nom);
        System.out.println("Prenom : " + p.prenom);
        System.out.println("Age : " + p.getAge());
        System.out.println(p.identite());
        Personnes p1 = new Personnes("Jean", "Cérien");
        // p1.prenom = "Jean";
        // p1.nom = "Cérien";
        p1.setAge(25);
        System.out.println("Identité de p1 :" + p1.identite());
       

        /* 
         * EXERCICES : 
         * 1. Déclarer un tableau d'objets Personne.
         * 2. Remplir le tableau avec les données utilisées 
         *      dans exempleArray.java (cf. ci-dessous)
         * 3. Affichez toutes les identités des personnes 
         *      (en utilisant la méthode identite()).
         * 4. ajoutez un constructeur qui permet d'instancier 
         *      une personne en définissant directement son prénom, 
         *      son nom et son âge. (Cherchez sur internet 
         * ce qu'est un constructeur et comment le déclarer)
         */
        Personnes[] tableauPersonnes = new Personnes[10];
    for (int i = 0; i < tableauPersonnes.length; i++) {
        tableauPersonnes[i] = new Personnes();
    }
        tableauPersonnes[0].prenom= "Gérard";
        tableauPersonnes[0].nom= "Menfins";
        tableauPersonnes[0].setAge(35);
        tableauPersonnes[0] = new Personnes();
        tableauPersonnes[1].prenom= "Nordine";
        tableauPersonnes[1].nom= "Ateur";
        tableauPersonnes[1].setAge(20);
    for (Personnes personnes : tableauPersonnes) {
        System.out.println(personnes.identite() + " " + personnes.getAge());
    }
    System.out.println(tableauPersonnes[1].identite());
/* NULL est un tupe de données particulier 'qu'on peut considerer comme une valeur particuliere).
 * Une variable qui n'a pas été intialisée est considéré comme étant NULL.
 */
// int n;
// System.out.println(null);


String[][] personnes = new String[10][3];
        personnes[0] = new String[] { "Menfin", "Gérard", "35" };
        personnes[1] = new String[] { "Ateur", "Nordine", "20" };
        personnes[2] = new String[] { "Onyme", "Anne", "50" };
        personnes[3] = new String[] { "Mentor", "Gérard", "61" };
        personnes[4] = new String[] { "Neymar", "Jean", "15" };
        personnes[5] = new String[] { "Cérien", "Jean", "42" };
        personnes[6] = new String[] { "Mal", "Roger", "70" };
        personnes[7] = new String[] { "Kiafessa", "Estelle", "22" };
        personnes[8] = new String[] { "Salah", "Mo", "30" };
        personnes[9] = new String[] { "Bar", "Laurent", "47" };

    }
}