public class CanardFeu extends CanardDeCombat {
    private double intensite;
    public CanardFeu(String n, int pv, int atk, double i) {
        super(n, pv, atk);
        this.intensite = i;
    }

    @Override
    public String getType() {
        return "Feu";
    }

    @Override
    public void attaquer(CanardDeCombat c) {
        effectuerAttaque(c, c.etreAttaqueePar(this) * intensite);
    }
}