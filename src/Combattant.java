public interface Combattant {
    void attaquer(CanardDeCombat cible);
    boolean estKO();
    String getNom();
}