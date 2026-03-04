public enum TypeCanard {
    FEU,
    EAU,
    PLANTE,
    NORMAL;

    public static double getEfficacite(TypeCanard att, TypeCanard cible) {
        if(att == FEU && cible == PLANTE) return 2.0;
        if(att == EAU && cible == FEU) return 2.0;
        if(att == PLANTE && cible == EAU) return 2.0;
        if(att == cible) return 0.5;
        return 1.0;
    }
}