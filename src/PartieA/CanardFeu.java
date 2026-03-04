package PartieA;
public class CanardFeu extends CanardDeCombat {

    private double intensiteFlamme;

    public CanardFeu(String surnom) {
        this("Canard Flamme", 39, 52, surnom, 1.2);
    }

    public CanardFeu(String nom, int pv, int atk, String surnom, double intensite) {
        super(nom, pv, atk);
        setSurnom(surnom);
        this.intensiteFlamme = intensite;
    }

    @Override
    public String getType() {
        return "Feu";
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this) * intensiteFlamme;
        effectuerAttaque(cible, mult);
    }

    @Override
    public String toString() {
        return super.toString() + " (Intensité: " + intensiteFlamme + ")";
    }

    @Override
    public double etreAttaqueePar(CanardEau attaquant) { return 2.0; }

    @Override
    public double etreAttaqueePar(CanardFeu attaquant) { return 0.5; }

    @Override
    public double etreAttaqueePar(CanardPlante attaquant) { return 0.5; }
}