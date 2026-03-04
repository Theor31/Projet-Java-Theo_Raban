public class CanardConfus extends CanardEau {

    public CanardConfus(String n, int pv, int atk) {
        super(n, pv, atk);
    }

    @Override public void attaquer(CanardDeCombat c) {
        if (Math.random() < 0.25) {
            System.out.println(getSurnom() + " est confus et se blesse !");
            this.subirDegats(15);
        } else super.attaquer(c);
    }
}