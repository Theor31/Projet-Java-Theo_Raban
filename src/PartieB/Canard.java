public class Canard implements Combattant, Soignable {

    private final EspeceCanard espece;
    private final String surnom;
    private final int pvMax;
    private int pvActuels;
    private final int atk;

    private static int nbCanardsCrees = 0;

    public Canard(EspeceCanard espece, String surnom) {
        this.espece = espece;
        this.surnom = surnom;
        this.pvMax = espece.getPvBase();
        this.pvActuels = pvMax;
        this.atk = espece.getAtkBase();

        nbCanardsCrees++;
    }

    public static int getNbCanardsCrees() {
        return nbCanardsCrees;
    }

    public TypeCanard getType() {
        return espece.getType();
    }

    @Override
    public String getNom() {
        return espece.getNom();
    }

    public String getSurnom() {
        return surnom;
    }

    public int getAtk() {
        return atk;
    }

    @Override
    public int getPvActuels() {
        return pvActuels;
    }

    @Override
    public int getPvMax() {
        return pvMax;
    }

    @Override
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
    public void attaquer(Canard cible) {

        double mult = this.getType()
                .getMultiplicateur(cible.getType());

        int degats = (int) (atk * mult);

        System.out.println(surnom + " attaque " +
                cible.surnom + " ! (" +
                getType().getLibelle() + " → " +
                cible.getType().getLibelle() +
                " : x" + mult + ") → " +
                degats + " dégâts");

        cible.subirDegats(degats);
    }

    // Régénération spécifique aux Plante
    public void finDeTour() {
        if (getType() == TypeCanard.PLANTE && !estKO()) {
            int regen = (int)(pvMax * 0.1);
            pvActuels += regen;
            if (pvActuels > pvMax) pvActuels = pvMax;

            System.out.println(surnom +
                    " régénère " + regen + " PV !");
        }
    }

    @Override
    public String toString() {
        return "[" + getType().getLibelle() + "] "
                + espece.getNom() + " «"
                + surnom + "» (PV: "
                + pvActuels + "/" + pvMax
                + " | ATK: " + atk + ")";
    }
}