public class MainB {

    public static void main(String[] args) {

        EquipeB e1 = new EquipeB("Sacha");
        EquipeB e2 = new EquipeB("Ondine");

        Canard gerard =
                new Canard(EspeceCanard.CANARD_FLAMME, "Gérard");

        Canard hubert =
                new Canard(EspeceCanard.CANARD_MARIN, "Hubert");

        Canard marcel =
                new Canard(EspeceCanard.CANARD_CLASSIQUE, "Marcel");

        Canard fernand =
                new Canard(EspeceCanard.CANARD_MOUSSE, "Fernand");

        Canard colette =
                new Canard(EspeceCanard.CANARD_MOUSSE, "Colette");

        e1.ajouter(gerard);
        e1.ajouter(fernand);

        e2.ajouter(hubert);
        e2.ajouter(marcel);
        e2.ajouter(colette);

        e1.afficher();
        e2.afficher();

        AreneB arene = new AreneB();
        arene.combattre(e1, e2);

        System.out.println("\nNombre total de canards créés : "
                + Canard.getNbCanardsCrees());
    }
}