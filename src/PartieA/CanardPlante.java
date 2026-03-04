package PartieA;
public class CanardPlante extends CanardDeCombat {

    public CanardPlante(String surnom) {
        this("Canard Mousse", 45, 49, surnom);
    }

    public CanardPlante(String nom, int pv, int atk, String surnom) {
        super(nom, pv, atk);
        setSurnom(surnom);
    }

    @Override
    public String getType() {
        return "Plante";
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }

    public void regenerer() {
        int regen = (int)(getPvMax() * 0.1);
        subirDegats(-regen);
    }

    @Override
    public double etreAttaqueePar(CanardFeu attaquant) { return 2.0; }

    @Override
    public double etreAttaqueePar(CanardEau attaquant) { return 0.5; }

    @Override
    public double etreAttaqueePar(CanardPlante attaquant) { return 0.5; }
}