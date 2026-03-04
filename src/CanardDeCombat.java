public abstract class CanardDeCombat implements Soignable, Combattant {
    private final String nom;
    private String surnom;
    private final int pvMax;
    private int pvActuels;
    private int atk;
    private static int nbCanardsCrees = 0;

    public CanardDeCombat(String nom, int pvMax, int atk) {
        if (pvMax <= 0 || atk < 1) throw new IllegalArgumentException("Stats invalides");
        this.nom = nom;
        this.pvMax = pvMax;
        this.pvActuels = pvMax;
        this.surnom = nom;
        this.atk = atk;
        nbCanardsCrees++;
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }
    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String s) {
        this.surnom = s;
    }
    public int getPvMax() {
        return pvMax;
    }

    public int getPvActuels() {
        return pvActuels;
    }
    public int getAtk() {
        return atk;
    }

    public static int getNbCanardsCrees() {
        return nbCanardsCrees;
    }

    public boolean estKO() {
        return pvActuels <= 0;
    }

    public void soigner() {
        this.pvActuels = pvMax;
    }

    public void subirDegats(int d) {
        this.pvActuels = Math.max(0, this.pvActuels - d);
        System.out.println(surnom + " perd " + d + " PV. (Reste: " + pvActuels + ")");
    }

    public double etreAttaqueePar(CanardFeu a) {
        return 1.0;
    }

    public double etreAttaqueePar(CanardEau a) {
        return 1.0;
    }

    public double etreAttaqueePar(CanardPlante a) {
        return 1.0;
    }

    public double etreAttaqueePar(CanardClassique a) {
        return 1.0;
    }

    protected void effectuerAttaque(CanardDeCombat cible, double mult) {
        int degats = (int) (this.atk * mult);
        System.out.println(surnom + " [" + getType() + "] attaque " + cible.getSurnom() + " !");
        cible.subirDegats(degats);
    }

    public abstract String getType();
    public void finDeTour() {}

    @Override
    public String toString() {
        return String.format("[%s] %s (%d/%d PV)", getType(), surnom, pvActuels, pvMax);
    }
}