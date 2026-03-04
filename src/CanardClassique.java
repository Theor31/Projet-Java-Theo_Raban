public class CanardClassique extends CanardDeCombat {
    public CanardClassique(String n, int pv, int atk) {
        super(n, pv, atk);
    }

    @Override
    public String getType() {
        return "Normal";
    }

    @Override
    public void attaquer(CanardDeCombat c) {
        effectuerAttaque(c, c.etreAttaqueePar(this));
    }
}