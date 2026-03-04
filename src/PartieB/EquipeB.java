package PartieB;


public class EquipeB {

    private Canard[] equipe = new Canard[6];
    private final String nomDresseur;

    public EquipeB(String nomDresseur) {
        this.nomDresseur = nomDresseur;
    }

    public boolean ajouter(Canard c) {
        for (int i = 0; i < equipe.length; i++) {
            if (equipe[i] == null) {
                equipe[i] = c;
                return true;
            }
        }
        return false;
    }

    public Canard getPremierValide() {
        for (Canard c : equipe) {
            if (c != null && !c.estKO())
                return c;
        }
        return null;
    }

    public boolean touteKO() {
        return getPremierValide() == null;
    }

    public void afficher() {
        System.out.println("=== ÉQUIPE de " + nomDresseur + " ===");
        for (Canard c : equipe) {
            if (c != null)
                System.out.println(c);
        }
    }

    public String getNomDresseur() {
        return nomDresseur;
    }
}