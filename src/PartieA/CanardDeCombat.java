package PartieA;

public abstract class CanardDeCombat implements Soignable, Combattant {

    private final String nom;
    private String surnom;
    private final int pvMax;
    private int pvActuels;
    private int atk;

    private static int nbCanardsCrees = 0;
    public static final int ATK_MIN = 1;

    public CanardDeCombat(String nom, int pvMax, int atk) {
        if (pvMax <= 0) {
            throw new IllegalArgumentException("pvMax doit être > 0");
        }
        if (atk < ATK_MIN) {
            throw new IllegalArgumentException("atk doit être >= " + ATK_MIN);
        }

        this.nom = nom;
        this.surnom = nom;
        this.pvMax = pvMax;
        this.pvActuels = pvMax;
        this.atk = atk;

        nbCanardsCrees++;
    }

    public String getNom() { return nom; }
    public String getSurnom() { return surnom; }
    public void setSurnom(String surnom) { this.surnom = surnom; }
    public int getPvMax() { return pvMax; }
    public int getPvActuels() { return pvActuels; }
    public int getAtk() { return atk; }
    public static int getNbCanardsCrees() { return nbCanardsCrees; }

    public boolean estKO() {
        return pvActuels <= 0;
    }

    public void subirDegats(int degats) {
        pvActuels -= degats;
        if (pvActuels < 0) pvActuels = 0;

        System.out.println(surnom + " subit " + degats +
                " dégâts ! (PV: " + pvActuels + "/" + pvMax + ")");
    }

    @Override
    public void soigner() {
        pvActuels = pvMax;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + nom + " «" + surnom + "» (PV: "
                + pvActuels + "/" + pvMax + " | ATK: " + atk + ")";
    }

    public double etreAttaqueePar(CanardFeu attaquant) { return 1.0; }
    public double etreAttaqueePar(CanardEau attaquant) { return 1.0; }
    public double etreAttaqueePar(CanardPlante attaquant) { return 1.0; }
    public double etreAttaqueePar(CanardClassique attaquant) { return 1.0; }

    protected void effectuerAttaque(CanardDeCombat cible, double mult) {

        int degats = (int)(atk * mult);

        System.out.println(surnom + " attaque " + cible.getSurnom()
                + " ! (" + getType() + " → " + cible.getType()
                + " : x" + mult + ") → " + degats + " dégâts");

        cible.subirDegats(degats);
    }

    @Override
    public abstract void attaquer(CanardDeCombat cible);

    public abstract String getType();
}