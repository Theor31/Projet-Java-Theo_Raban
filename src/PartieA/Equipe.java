package PartieA;

public class Equipe {

    private CanardDeCombat[] equipe = new CanardDeCombat[6];
    private final String nomDresseur;
    private static int nbEquipesCrees = 0;

    public Equipe(String nom) {
        this.nomDresseur = nom;
        nbEquipesCrees++;
    }

    public boolean ajouter(CanardDeCombat c) {
        for (int i = 0; i < equipe.length; i++) {
            if (equipe[i] == null) {
                equipe[i] = c;
                return true;
            }
        }
        return false;
    }

    public boolean retirer(String surnom) {
        for (int i = 0; i < equipe.length; i++) {
            if (equipe[i] != null &&
                equipe[i].getSurnom().equals(surnom)) {

                for (int j = i; j < equipe.length - 1; j++) {
                    equipe[j] = equipe[j + 1];
                }

                equipe[equipe.length - 1] = null;
                return true;
            }
        }
        return false;
    }

    public void soignerTous() {
        for (CanardDeCombat c : equipe) {
            if (c != null) {
                c.soigner();
            }
        }
    }

    public CanardDeCombat getPremierValide() {
        for (CanardDeCombat c : equipe) {
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
        for (CanardDeCombat c : equipe) {
            if (c != null)
                System.out.println(c);
        }
    }

    public String getNomDresseur() {
        return nomDresseur;
    }
}