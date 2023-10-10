package game.goals;

import java.util.List;
import java.util.Random;

import character.Hero;

public class CompositeGoal extends Goals {
	private List<Goals> allGoals;
	public CompositeGoal(List<Goals> ag) {
		super();
		this.allGoals=ag;
	}
	/**
	 * verify if all the goals were completed, and change achieved to true in this case.
	 * @param h the hero  
	 */
	public void verify(Hero h) {
		for(Goals g:allGoals) {
			g.verify(h);
		}
		
		boolean tmp = true;
		for (Goals g : this.allGoals) {
			if( ! g.isAchieved()) {
				tmp = false; 
			}
		}
		
		if(tmp) {
			this.achieved=true;
		}		
	}
	/**
	 * choose from the goals generated one, and create a clue from it.
	 * @return the clue generated from the goal.
	 */
	public String getGoalDescription() {
		Random alea = new Random();
		Goals chosed = this.allGoals.get(alea.nextInt(this.allGoals.size()));
		return chosed.getGoalDescription();
	}
	
	/**
	 * choose from the goals generated one, and create a fake clue from it.
	 * @return the false clue generated from the goal.
	 */
	public String getFalseClue() {
		Random alea = new Random();
		Goals chosed = this.allGoals.get(alea.nextInt(this.allGoals.size()));
		return chosed.getFalseClue();
	}
	
	
}


