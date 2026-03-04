# Projet-Java-Theo_Raban

## Section 1 - Modélisation par héritage

### R1 : Duplication des données 
Le problème est la redondance. Si deux canards sont de l'espèce "Canard Flamme", ils stockent inutilement les mêmes PV de base et le même nom. Cela gaspille de la mémoire et rend l'équilibrage difficile (il faut modifier chaque instance au lieu d'une seule "matrice" d'espèce).

### R2 : Surcharge vs Redéfinition
La tentative échoue car la surcharge est statique (résolue à la compilation). Le compilateur voit une cible de type CanardDeCombat et ne peut pas choisir la méthode spécifique (Eau, Feu, etc.) avant l'exécution.

### R3 : Coût du Double Dispatch
Pour N types, il faut N2 méthodes. L'ajout d'un 5ème type oblige à modifier la classe mère et toutes les sous-classes existantes, ce qui viole le principe de conception "Open/Closed".

### R4 : Utilité des Interfaces
Elles permettent le polymorphisme horizontal. On peut créer un RobotDeCombat qui implémente Combattant sans hériter de la classe Canard, permettant à l'Arène de le gérer sans modification de code.

### R5 : Explosion combinatoire
Si l'on veut combiner des types (Feu, Eau) avec des états (Confus, Enragé), le nombre de classes explose (Types×Etats). L'héritage est trop rigide pour gérer ces combinaisons.

### R6 : Instanceof vs Méthode de cycle de vie
Utiliser instanceof est une mauvaise pratique ici. Il vaut mieux créer une méthode finDeTour() dans la classe mère que chaque sous-classe redéfinit. Cela permet d'ajouter n'importe quel effet (soin, dégât de gel) de façon transparente.

## Section 2 - Refactorisation vers la Composition

### R7 : Avantages de l'Enum 
L'ajout d'un type devient une simple ligne dans l'Enum. Le changement de type en combat devient possible (ex: un canard qui change d'élément), ce que l'héritage interdit.

### R8 : Séparation des responsabilités
En séparant l'Espèce (stats fixes) de l'Instance (PV actuels), on élimine la duplication soulevée en R1.

### R9 : Flexibilité du comportement
En utilisant la composition, un Canard possède un Comportement. On peut lui donner un ComportementConfus dynamiquement sans changer sa classe.

### R10 : Simplification de la table des types
La logique des dégâts passe d'une forêt de méthodes Double Dispatch à une simple matrice (ou Map) stockée dans l'Enum TypeCanard.

### R11 : Évolutivité du système
Le système devient "piloté par les données". On peut ajouter 100 espèces de canards en créant simplement des objets de configuration, sans écrire 100 classes Java.

### R12 : Conclusion sur le Design
L'héritage est utile pour une structure "Est un" (is-a) stricte, mais la composition est supérieure pour la modularité et les systèmes complexes ("A un" / has-a).

## Section 3 - Comparaison des deux approches

| Critère | Partie A (héritage) | Partie B (composition) |
| :--- | :--- | :--- |
| **Ajouter un nouveau type (ex. Électrique)** | **Lourd** : nécessite de créer une nouvelle classe, d'ajouter une méthode dans la classe mère et de modifier TOUTES les sous-classes existantes ($N^2$ méthodes). | **Simple** : il suffit d'ajouter une valeur à l'Enum `TypeCanard` et une ligne dans la table des multiplicateurs. |
| **Ajouter un nouveau comportement (ex. Confus)** | **Explosion combinatoire** : nécessite de créer autant de sous-classes qu'il y a de types (CanardFeuConfus, CanardEauConfus, etc.). | **Modulaire** : on crée une seule classe de comportement (Pattern Strategy) que l'on affecte à n'importe quel canard. |
| **Deux canards de la même espèce en mémoire** | **Duplication** : chaque instance possède sa propre copie des statistiques de base (nom, PV max, ATK de base). | **Optimisé** : utilisation du pattern *Flyweight*. Les instances partagent une référence commune vers un "Template" d'espèce. |
| **Changer le type d’un canard à l’exécution** | **Impossible** : l'identité d'un objet est fixée à son instanciation par sa classe. | **Possible** : il suffit de modifier l'attribut `type` du canard (via un setter) en plein combat. |
| **Nombre de `instanceof` nécessaires dans l’arène** | **Élevé** : souvent utilisé (à tort) pour gérer les effets spécifiques ou les soins, rendant le code rigide. | **Nul** : le polymorphisme d'objet et les attributs d'état remplacent avantageusement les tests de classe. |
| **Lisibilité du code pour un débutant** | **Plus intuitive** au départ car elle reflète une hiérarchie biologique simple ("Est un"). | **Plus abstraite** mais beaucoup plus propre et maintenable sur le long terme. |
| **Quand préférer cette approche ?** | Pour des petits projets avec une hiérarchie fixe et peu d'évolutions prévues. | Pour des systèmes complexes et évolutifs (type RPG) nécessitant une grande flexibilité. |

### Commentaire synthétique
La **Partie A** illustre les limites de l'héritage : bien que simple à comprendre, elle mène à une rigidité structurelle dès que le nombre de caractéristiques (types, états, espèces) augmente.
La **Partie B** adopte une approche "pilotée par les données" (data-driven). En utilisant la composition, on transforme des classes rigides en composants interchangeables, respectant ainsi le principe de conception : *"Favoriser la composition par rapport à l'héritage"*.