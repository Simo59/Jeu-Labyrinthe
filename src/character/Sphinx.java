package character;
import java.util.*;
import Maze.*;
import java.lang.Math;

public class Sphinx extends NPC {
private Random alea = new Random();

private Map<String,String> allAnswers;
protected Scanner scanner = new Scanner(System.in);

public Sphinx(String name,Cell currentCell,String [] q,String [] r) {
	super(name,currentCell,"sphinx");
	this.allAnswers = new HashMap<>();
	this.setAllAnswers(q,r);
}

/**
 *  stocke les tableaux de questions/réponses du sphinx dans une map;
 * @param String[] q : les questions disponibles.
 * @param String[] r: les réponses disponibles.
 */

private void setAllAnswers(String [] q, String [] r) {
	for (int i = 0 ; i<q.length ; i++) {
		this.allAnswers.put(q[i], r[i]);
	}
	
}

/**
 * Calcul la distance entre 2 mots selon Levenshtein.
 * Permet de tolérer des typographies dans les réponses données au sphinx.
 * Algorithme Python de Wagner et Fischer.
 * https://128mots.com/index.php/2021/01/19/levenshtein-python/
 * 
 * @return int : La distance entre 2 mots selon la distance de Levenshtein.
 */
public int distanceLevenshtein (String c1,String c2) {
	
	int taille_c1 = c1.length() + 1;
	int taille_c2 = c2.length() + 1;
	char [] t_c1 = c1.toCharArray();
	char [] t_c2 = c2.toCharArray();
	
	int [][]Levenshtein = new int [taille_c1][taille_c2];
	
	for (int x = 0 ; x<taille_c1 ; x++) {
		Levenshtein[x][0] = 0;
	}
	for (int y = 0 ; y<taille_c2 ; y++) {
		Levenshtein[0][y] = 0;
	}
	
	for (int x = 1 ; x<taille_c1 ; x++) {
		for (int y = 1 ; y<taille_c2 ; y++) {
			if (t_c1[x-1] == t_c2[y-1]) {
				Levenshtein[x][y] = Math.min(
						Levenshtein[x-1][y] + 1,
						Math.min(Levenshtein[x-1][y-1],
						Levenshtein[x][y-1] + 1));
			}
			else {
				Levenshtein[x][y] = Math.min(
						Levenshtein[x-1][y] + 1,
						Math.min(Levenshtein[x-1][y-1] + 1,
						Levenshtein[x][y-1] + 1));
			}
		}
	}
	return Levenshtein[taille_c1-1][taille_c2-1];
	}

@Override
public String clue( ) {
	return this.quest.getGoalDescription();
}
  
@Override
public String respond(Hero h) {
	Set <String> selection ;
	selection = this.allAnswers.keySet();
    String [] tab = selection.toArray(new String[0]); 
    int chosen = alea.nextInt(tab.length);
    System.out.println(tab[chosen]);
    
    String reponse = this.scanner.next();
    if (this.allAnswers.get(tab[chosen]).toLowerCase().equals(reponse.toLowerCase())) {
    	return "Good answer, Human !\n"+this.clue();
    }
    else {
    	return "Wrong answer, see you soon !";
    }
}

public String toString() {
	return "sphinx ";
}
}
