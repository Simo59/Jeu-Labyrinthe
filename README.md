# l2s4-projet-2022

# Equipe

- Hakim LAKROUT
- Simon CONAN
- Mohammed ouramdane HACHOUR
- Clovis TSHIZA

# Sujet

[Le sujet 2022](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
# Lien vers nos UML:
[UML](https://lucid.app/lucidchart/95fbc51f-d14d-40c0-bfd4-3b731b6f5d50/edit?invitationId=inv_0b03299e-8ae6-4139-856f-2084af9eb7a3)
## UML :
Vous pouver vous rendre dans ce dossier pour trouvez tous nos UML
[Tout les UML's](UML/)

# Instructions pour l'execution  
Vous trouverez dans notre projet un makefile qui permet lexecution du jeu .  
Pour lancer l jeu il suffit d'ouvrir un terminal dans le dossier du projet et executer la commande suivante :  
```bash
make play
```  
Pour generer le jar executable la commande <code>make jar </code> suffit puis pour lancer le jeu avec le jar la commande :  
<code>java -jar jeu.jar </code> en ajoutant un parametre a la commande precedents ce parametr doit etre 1 ou 2 ou 3 .  

Pour generer la doc la commande <code>make doc</code> suffit .

A propos des tests la compilation des tests se fait avec le makefile avec <code> make tests</code> pour l'execution
il suffit de lancer la commande  
   
```bash
java -jar test4poo.jar  <nom de la classe de tests a executer >
```
# Rendu:
La classe ClassicalGAme est la classe demandé ou se deroule le jeu comme decrit dans les instruction du rendu final sur le FIL 

# Livrables

## Livrable 1
Nous avons choisi 2 algorithmes de labyrinthes : 
#### Algerithme des arbres binaires : 
Cette algorithme a pour pseudo code :  

```
entree:aucune
sortie:aucune
Debut
pour i de 0 a width-1
    pour j de 0 height-1
        essayer de faire :
            choisir au hasard le mur à casser parmi l'est et le sud
            recuperer la cell courrante 
            si le mur à casser et le mur est 
                recuperer la cell à l'est de la cell courrante 
                casser le mur est de la cell courrante 
                casser le mur ouest de la cell à l'est que nous avons recuperé
            sinon:
                recuperer la cell au sud de la cell courrante
                casser le mur sud de la cell courrante 
                casser le mur nord de la cell à l'est que nous avons recuperé

        si on deborde lors de la recuperation des cell :
            si on est a une des cell des la derniere ligne et que l'on ne soit pas à la dernière cell de coordonnées(width-1,height-1):
                on recupere le cell est de la cell courante
                on casse le  mur est de la cell courrante
                on casse le mur ouest de la cell sud que nous avons recuperé.
            sinon si on est a une des cell des la derniere  colonne et que l'on ne soit pas à la dernière cell de coordonnées(width-1,height-1):
                on recupere le cell sud de la cell courante
                on casse le  mur sud de la cell courrante
                on casse le mur nord de la cell sud que nous avons recuperé.
Fin


```

#### Algorithme de division recursive : 
Cette algorithme a pour pesuodo code :  

```
entree:x,y,width,height,orientation
sortie:aucune
Debut
    si width>=2 et height>=2 :
        si orientation est horizontal :
            on choisit l'emplacement du mur horizontal
            on choisit au hasard une porte à ouvrir dans ce mur
            on fixe la direction 
            on fixe la longueur du mur à width 
            on ajoute le mur horizontal et on ouvre au hasard dans le mur que nous avons ajouté
        sinon
            on choisit l'emplacement du mur vertical
            on choisit au hasard une porte a ouvrir dans ce mur
            on fixe la direction 
            on fixe la longueur du mur a height
            on ajoute le mur vertical et on ouvre au hasard dans le mur que nous avons ajouté
    on appelle la fonction elle même 2 fois sur les deux partie du labyrinthe genéré 
Fin

```

#### EXTRA :
Voici le pesudo code de l 'algorithme de sidewinder que nous avons ajouté en plus  

```
entree:aucune
sortie:aucune
Debut
    pour i de 0 a width-1:
        casser le mur est de la cell de coordonnées (i,0)
    pour y de 1 a height-1:
        formater la liste de cell parcorue. 
        pour x de 0 width-1:
            ajouter la cell courante a la liste des cell parcourue
            choisir au hasard si on casse le mur est ou pas
            Si on casse le mur est et x+1<width :
                on casse le mur est de la cell courante 
                on casse le mur ouest de la cell qui est situe en l'est de la cell courante
            sinon:
                on choisit au hasard une cell dans la liste des cells parcourues
                on casse le mur nord de la cell choisie au hasard 
                on casse le mur sud de la cell situe au nord de la cell choisie au hasard
                on formate la liste des cells parcourues

Fin


```









### Atteinte des objectifs
Pour le livrable 1 nous avons reussi à implementer les 2 algorithmes de génération de labyrinthe choisie lors de la première séance

### Difficultés restant à résoudre

## Livrable 2
Le livrable 2 se concentre sur la modélisation, le creation et l'implémentation des personnages et des objets présent dans le jeu.
la reflexion c'est principalement axée sur la portée des actions des personnages, la fixations des limites des possibilitées de ces derniers, 
l'appropriation des fonction par les bonnes classes (exemple : "est-ce le héros qui achète au vendeur, ou est-ce le vendeur qui vends au héros ?"),
la solution a ces questions ont été trouvées par la volonté de rendre le jeu extensible à l'avenir (exemple : dans le cas d'un jeu multijoueur,
le vendeur pourra vendre à plusieurs héros, mais l'inverse n'aurait pas de sens.)


### Atteinte des objectifs
Pouvoir placer les personnages et les objets du jeu : validé, les personnages chargés existent dans le labyrinthe.



### Difficultés restant à résoudre

## Livrable 3
Pour ce livrable nous avons trouvez sur les actions et les interactions vous trouverez notre progression dans le journal de bord

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4
Pour ce livrable nous avons reussi la modelisation final du jeu
### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
 Selection d'Algorithmes :
 Nous avons choisis l'algorithme "arbre binaire" et l'algorithme de labyrinthe récursif, ceux-ci
 sont assez différents et contraires ( l'un commence par ouvrir les accès, l'autre les bloquent).
 		
#### Algorithme "Arbre binaire ": 
 		
 * construire un tableau à deux dimensions d'objets Cellules dont tout les accès sont bloqués(qui contiennent une hashmap(coté,case accessible)) 
 * Pour chaque case, on casse  soit le mur est, soit le mur sud, selon notre axe de parcours du tableau;
 - si on est dans les cases dont l'indice se situent dans les extrémités des axes de parcours, on détruit aucun mur.
 - si on est dans Une des deux extrémités du tableau (par rapport a l'axe de parcours) on choisir la seule porte disponible (sud ou est)
 (remarque : pour les autres cases, on choisi aléatoirement entre les deux cotés disponibles.)
 		 
#### Algorithme récursif :
 	
 * construire un tableau 2D de Cell dont tous les accès sont ouverts entre les cells.
 * (dans une fonction) On ajoute un mur ( on bloque l'accès des cellules selon des parametres (x,y,cote) choisis et on ouvre des portes aléatoirement sur l'axe de parcours.
 - on divise le tableau initial par 4 parties appelées chambre (par l'ajout de deux murs), on reprends les coordonées X,Y des murs
et on en fait de même pour chaque chambre, repetitivement, jusqu'a ce que chaque chambres soit egale à une case 
 		
## Semaine 2

Cette semaine, nous avons commencé le codage de l'algorithme " Arbre binaire".
les difficultés rencontrées sont :  

* la visualisation (mentale) des axes du labyrinthe par rapport à la construction du tableau(x,y).
* des soucis au niveau de la fonction toString (boucle infinie due à l'appel de la fonction imbriquée de 	toString à l'infini
* la gestion des fin de tableaux, ( len(x), len(y) et (len(x),len(y))
* En solutions, nous avons repris pas à pas la construction du tableau à deux dimensions,
* pour le soucis de toString , nous avons optés pour un afficheur, qui affiche 1 ou 0 selon la présence d'un mur.
* pour la gestion des fin de tableaux, nous nous sommes servis des exceptions pour s'assurer des 3 règles suivante : pour x = width, pour y=height, pour x=width & y = height. (les exceptions faisant parti de la construction du tableau.  

 les problèmes se situaient au niveau des paramètres du tableau.
 nous nous sommes attelés à la complétion de l'UML, ainsi que le rajout de methode afin de simplifier nos codes.
 Nous débutons le codage de l'algorithme récursif.

## Semaine 3
Cette semaine nous avons commencé a coder l'algorithme 2 (recursive division), et nous avons commencé à chercher une méthode pour mieux afficher les labyrinthes sur la console. de plus, rajout d'un main pour executer nos 2 algorithmes. 

## Semaine 4
Cette semaine nous avons reussi a finir le deuxieme algo (recursive division) apres de nombreux essai et aussi nous avons codé les test pour la majorité de nos methodes et la javadoc pour tous les methodes de notre projet et aussi nous avons mis un affichage pour les labyrinthe. A la fin de cette semaine nous avons ajouté une troisieme algo (sideWinder) en extra . Comme nous étions entrain d 'essayer de reussir le recursive  nous avons codé l'algo de sidewinder parce que il etait moins compliqué mais a la fin nous avons reussi le recursive donc a la fin de la semaine 4 nous avons 3 algo .Alors nous avons decidé d'inclure en extra l'algo de sidewinder. 
## Semaine 5
Nous avons commencé à modéliser les personnages et objets.
un problème se dessine : "Hero" hérite de move() mais ne bouge pas de la meme façon que les NPC (héritant aussi de move()) la surcharge ne fonctionnerait pas car elle changerait la signature de la methode. deux idées :  
- laisser move() vide et faire une méthode de déplacement propre à la classe hero.  

- Creer une fonction input() qui interagit avec la méthode move() du hero. 
solution choisie : mettre un paramètre à la fonction move() qui sera régit par l'input coté Hero, et par random du coté NPC.

Au niveau des objets : la gestion des pouvoir de chaque cristaux.  
-Premiere idée : faire un enum de couleur de crystaux associées à un pouvoir; Mais problème de répétition et probleme de flexibilité par rapport aux potentiels extentions.
-deuxieme idée : Cristal devient abstract et chaque cristal de couleur à sa propre classe et methode contenant le pouvoir.

## Semaine 6
nous avons continué la modelisaton et l'implementation, avancement ralenti par les examens, nous avons repris le travail et normalement nous avons modelisé tous ce qu'il fallait pour le livrable 2 `character et objets` et nous avons commencé aussi a implanter les actions comme les mouvements et l interaction entre les characters et a la fin nous avons commencé a coder une methode main dans laquelle elle se deroulera la partie.
pour l'instant nous avons initialise une partie et nous pensons a comment faire pour la quete pour qu on puisse jouer  
Pour les tests nous somme un peu perdu si je peux dire parce que nous avons utiliser plusieurs fois un scanner dans les methode donc on sait pas encore comment tester ces methode. Et aussi est ce que on doit tester les getters et les setters?

## Semaine 7
création des classes de personnages, d'un coté et consumable de l'autre.
création des fonctions de celles-ci.  
modifications des classes personnages et consommables suite à la révision de la conception.
finalisation des methodes `consume`
mise à jour GameMain (début du travail réél sur celui-ci)
reflexion, developpement des systemes de question/réponses du sphinx, ainsi que de la gestion de l'invetaire/interaction marchant.

## Semaine 8
finalisation du developpement spĥinx/marchant/inventaire.
avancement des actions/déroulement du jeu.
debut du developpement des objectifs.

## Semaine 9
à venir : verification du déroulement (correction des failles, erreurs.)

## Semaine 10
à venir : TESTS et docs
## Semaine 11
à venir : diapo
## Semaine 12
à venir : soutenance