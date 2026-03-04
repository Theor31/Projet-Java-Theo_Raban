public class CanardEau extends CanardDeCombat {

    public CanardEau(String n, int pv, int atk) {
        super(n, pv, atk);
    }

    @Override
    public String getType() {
        return "Eau";
    }

    @Override
    public void attaquer(CanardDeCombat c) {
        effectuerAttaque(c, c.etreAttaqueePar(this));
    }

    @Override
    public double etreAttaqueePar(CanardFeu a) {
        return 0.5;
    }
}