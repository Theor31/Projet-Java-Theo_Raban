package PartieB;

public class AreneB {

    public void combattre(EquipeB e1, EquipeB e2) {

        int tour = 1;

        while (!e1.touteKO() && !e2.touteKO()) {

            System.out.println("\n=== Tour " + tour + " ===");

            Canard c1 = e1.getPremierValide();
            Canard c2 = e2.getPremierValide();

            if (c1 == null || c2 == null) break;

            c1.attaquer(c2);
            if (!c2.estKO()) {
                c2.attaquer(c1);
            }

            c1.finDeTour();
            c2.finDeTour();

            tour++;
        }

        if (e1.touteKO())
            System.out.println("Victoire de " + e2.getNomDresseur());
        else
            System.out.println("Victoire de " + e1.getNomDresseur());
    }
} {
    
}
