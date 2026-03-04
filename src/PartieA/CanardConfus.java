package PartieA;

import java.util.Random;

public class CanardConfus extends CanardEau {

    private boolean enrage = false;
    private Random random = new Random();

    public CanardConfus(String surnom) {
        super(surnom);
    }

    @Override
    public void attaquer(CanardDeCombat cible) {

        if (random.nextInt(4) == 0) {
            System.out.println(getSurnom() +
                    " est confus ! Il se cogne la tête... Coin coin ?");
            this.subirDegats(getAtk() / 2);
            return;
        }

        int atkTemp = getAtk();
        if (enrage) {
            System.out.println("⚡ Attaque doublée !");
            enrage = false;
        }

        super.attaquer(cible);
    }

    public void migraine() {
        System.out.println(getSurnom() +
                " se tient la tête... COIN. COIN.");
        enrage = true;
    }

    @Override
    public String toString() {
        return super.toString() + " 🌀";
    }
}