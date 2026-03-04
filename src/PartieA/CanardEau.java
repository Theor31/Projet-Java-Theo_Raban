package PartieA;
public class CanardEau extends CanardDeCombat {

    private int pressionJet;

    public CanardEau(String surnom) {
        this("Canard Marin", 44, 48, surnom, 10);
    }

    public CanardEau(String nom, int pv, int atk, String surnom, int pression) {
        super(nom, pv, atk);
        setSurnom(surnom);
        this.pressionJet = pression;
    }

    @Override
    public String getType() {
        return "Eau";
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        System.out.println("💦 Jet d'eau (pression: " + pressionJet + ") !");
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }

    @Override
    public double etreAttaqueePar(CanardFeu attaquant) { return 0.5; }

    @Override
    public double etreAttaqueePar(CanardEau attaquant) { return 0.5; }

    @Override
    public double etreAttaqueePar(CanardPlante attaquant) { return 2.0; }
}