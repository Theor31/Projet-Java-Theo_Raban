public class Arene {
    public void combat(Equipe e1, Equipe e2) {
        System.out.println("Début du combat : " + e1.getDresseur() + " vs " + e2.getDresseur());
        while(!e1.estEliminee() && !e2.estEliminee()) {
            CanardDeCombat c1 = e1.getActif();
            CanardDeCombat c2 = e2.getActif();

            c1.attaquer(c2);
            if(!c2.estKO()) c2.attaquer(c1);

            c1.finDeTour();
            c2.finDeTour();
        }
        String vainqueur = e1.estEliminee() ? e2.getDresseur() : e1.getDresseur();
        System.out.println("Vainqueur : " + vainqueur);
    }
}