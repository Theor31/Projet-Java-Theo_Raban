public class CanardPlante extends CanardDeCombat {
    public CanardPlante(String n, int pv, int atk) {
        super(n, pv, atk);
    }

    @Override
    public String getType() {
        return "Plante";
    }

    @Override
    public void attaquer(CanardDeCombat c) {
        effectuerAttaque(c, c.etreAttaqueePar(this));
    }

    @Override
    public double etreAttaqueePar(CanardEau a) {
        return 0.5;
    }

    @Override public void finDeTour() {
        int soin = (int)(getPvMax() * 0.05);
        subirDegats(-soin);
        System.out.println(getSurnom() + " régénère " + soin + " PV.");
    }
}