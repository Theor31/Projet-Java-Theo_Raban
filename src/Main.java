public class Main {
    public static void main(String[] args) {
        Equipe sacha = new Equipe("Sacha");
        sacha.ajouter(new CanardFeu("Gérard", 50, 10, 1.2));
        sacha.ajouter(new CanardPlante("Fernand", 60, 8));

        Equipe ondine = new Equipe("Ondine");
        ondine.ajouter(new CanardEau("Hubert", 55, 9));

        Arene arena = new Arene();
        arena.combat(sacha, ondine);

        System.out.println("Canards créés au total : " + CanardDeCombat.getNbCanardsCrees());
    }
}