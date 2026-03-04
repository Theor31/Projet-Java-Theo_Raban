public class CanardUnique implements Soignable {
    private String surnom;
    private int pvActuels;
    private TypeCanard type;
    private final EspeceTemplate espece;

    public CanardUnique(String surnom, EspeceTemplate espece, TypeCanard type) {
        this.surnom = surnom; this.espece = espece;
        this.type = type; this.pvActuels = espece.getPv();
    }
    public void setType(TypeCanard t) {
        this.type = t;
    }

    @Override
    public void soigner() {
        this.pvActuels = espece.getPv();
    }
    @Override
    public int getPvActuels() {
        return pvActuels;
    }

    @Override
    public int getPvMax() {
        return espece.getPv();
    }
}