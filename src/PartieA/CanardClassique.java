public class CanardClassique extends CanardDeCombat {

    public CanardClassique(String surnom) {
        this("Canard Classique", 50, 45, surnom);
    }

    public CanardClassique(String nom, int pv, int atk, String surnom) {
        super(nom, pv, atk);
        setSurnom(surnom);
    }

    @Override
    public String getType() {
        return "Normal";
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }
}