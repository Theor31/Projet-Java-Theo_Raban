public class Equipe {
    private CanardDeCombat[] membres = new CanardDeCombat[6];
    private String dresseur;
    private int taille = 0;

    public Equipe(String dresseur) {
        this.dresseur = dresseur;
    }

    public void ajouter(CanardDeCombat c) {
        if(taille < 6) membres[taille++] = c;
    }

    public CanardDeCombat getActif() {
        for(int i=0; i<taille; i++) if(!membres[i].estKO()) return membres[i];
        return null;
    }

    public boolean estEliminee() {
        return getActif() == null;
    }

    public String getDresseur() {
        return dresseur;
    }
}