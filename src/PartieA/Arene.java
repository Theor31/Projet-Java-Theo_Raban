package PartieA;

public class Arene {

    public void combattre(Equipe e1, Equipe e2) {

        int tour = 1;

        while (!e1.touteKO() && !e2.touteKO()) {

            System.out.println("\n=== Tour " + tour + " ===");

            CanardDeCombat c1 = e1.getPremierValide();
            CanardDeCombat c2 = e2.getPremierValide();

            if (c1 == null || c2 == null) break;

            c1.attaquer(c2);

            if (!c2.estKO()) {
                c2.attaquer(c1);
            }

            if (c1 instanceof CanardPlante && !c1.estKO()) {
                ((CanardPlante) c1).regenerer();
            }

            if (c2 instanceof CanardPlante && !c2.estKO()) {
                ((CanardPlante) c2).regenerer();
            }

            tour++;
        }

        if (e1.touteKO())
            System.out.println("Victoire de " + e2.getNomDresseur());
        else
            System.out.println("Victoire de " + e1.getNomDresseur());
    }
}