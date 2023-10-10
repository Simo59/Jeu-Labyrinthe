package game;

import java.util.ArrayList;
import java.util.List;

import Maze.Maze;
import character.Hero;
import character.Mobile_NPC;
import game.action.Action;
import game.goals.Goals;
import scan.Scan;
public class Play {
	private Goals quest;
	
	private Hero hero ;
	private int nbTurnsToLose;
	private Maze maze ;
	
	public Play(Goals cg,Hero h,Maze m) {
		this.hero=h;
		this.nbTurnsToLose=(m.getHeight()*m.getWidth()) + (m.getHeight()*m.getWidth())/10;
		this.maze =m;
		this.quest=cg;
	}
	
	public boolean won() {
		return this.quest.isAchieved();
	}
	
	public void run() {
		int nbTurnsPlayed = 0;
		while(this.won()==false   && nbTurnsPlayed < this.nbTurnsToLose) {
			this.maze.display();
			System.out.println("\n");
			System.out.println(this.nbTurnsToLose - nbTurnsPlayed + " turns remaining!");
			// afficher la cell courante     fait
			System.out.println(this.hero.getCurrentCell());
			System.out.println("You have "+this.hero.getGold()+" pieces\n");
			
			//System.out.println("boucle");
			
			// determiner les action dispo dans ce tour 
			List<Action>  available =getAvailableActions();
			
			// afficher les actions
			List <String> availablesString =initStringListAction(available);
			displayAvalaibleActions(availablesString);
			
			// choisir l action 
			//Scanner scan =new Scanner(System.in);
			int chosed=Scan.scanInt();
			while (chosed<1 || chosed>availablesString.size()) {
				System.out.println("give a valid number");
				chosed=Scan.scanInt();
				
			}
			
			Action ac=available.get(chosed-1);
			ac.now(this.hero);
			
			// verifier l etat des objectif
			this.quest.verify(hero);
			
			// verifier si il a gagne ou a perdu pu il continue a jouer
			if(this.won()) {
			System.out.println("Congratulations you have won !!!!! ");
			break;
			}
			nbTurnsPlayed+=1;
			if(this.nbTurnsToLose==nbTurnsPlayed) {
				System.out.println("Game over ");
			}
			
			List<Mobile_NPC> npcToMove=this.maze.getAllmobileNpc();
			for (Mobile_NPC n : npcToMove) {
				n.randomMove();
			}
			
			
			
			System.out.println("________________________________________________\n");
		}
	}

	private void displayAvalaibleActions(List<String> availablesToString) {
		int i =1;
		for(String c :availablesToString  ) {
			System.out.println(i+"-"+c+"\n");
			i++;
		}
	}

	private List<String> initStringListAction(List<Action> available) {
		List <String> availablesToString = new ArrayList<>();
		for(Action c : available) {
			availablesToString.add(c.toString());
		}
		return availablesToString;
	}

	private List<Action> getAvailableActions() {
		List<Action> all = this.hero.getAllActions();
		List<Action> available=new ArrayList<>();
		for (Action c : all) {
			if (c.isPossible(this.hero)) {
				available.add(c);
			}
		}
		return available;
	}
	 
	
}
