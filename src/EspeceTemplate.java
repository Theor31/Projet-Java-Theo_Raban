public class EspeceTemplate {
    private final String nomEspece;
    private final int pvBase, atkBase;

    public EspeceTemplate(String n, int p, int a) {
        this.nomEspece = n; this.pvBase = p; this.atkBase = a;
    }
    public String getNom() {
        return nomEspece;
    }

    public int getPv() {
        return pvBase;
    }

    public int getAtk() {
        return atkBase;
    }
}