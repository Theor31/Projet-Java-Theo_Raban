package PartieB;
public interface Combattant {

    void attaquer(Canard cible);

    boolean estKO();

    String getNom();
}