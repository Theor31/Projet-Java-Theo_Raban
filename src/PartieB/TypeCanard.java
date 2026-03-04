package PartieB;
public enum TypeCanard {

    FEU("Feu"),
    EAU("Eau"),
    PLANTE("Plante"),
    NORMAL("Normal");

    private final String libelle;

    TypeCanard(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    private static final double[][] TABLE = {
            // Cible →     FEU   EAU   PLANTE NORMAL
            /* FEU */     {0.5, 0.5,  2.0,   1.0},
            /* EAU */     {2.0, 0.5,  0.5,   1.0},
            /* PLANTE */  {0.5, 2.0,  0.5,   1.0},
            /* NORMAL */  {1.0, 1.0,  1.0,   1.0}
    };

    public double getMultiplicateur(TypeCanard cible) {
        return TABLE[this.ordinal()][cible.ordinal()];
    }
}