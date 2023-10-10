package game.action;

import character.Hero;
import scan.Scan;

public class QuitAction implements Action {



	@Override
	/**
	 * @see action.Action
	 * let to the to quit the game at any time
	 */
	public void now(Hero h) {
		System.out.println("you decided to quit the game , Are you sure \n 1-yes \n 2-no \n please confirm");
		int confirmation = Scan.scanInt();
		while(confirmation!=1 && confirmation !=2) {
			System.out.println("please confirm with a valid number please");
			confirmation =Scan.scanInt();
		}
		if(confirmation ==1 ) {
			System.out.println("see you soon thank for trying our game");
			System.exit(0);
		}
		else {
			System.out.println("good choice wish you wille get out of the maze");
		}

	}

	@Override
	/**
	 * @see action.Action
	 */
	public boolean isPossible(Hero h) {
		
		return true;
	}

	@Override
	/**
	 * @see action.Action
	 */
	public String getDescription() {
		
		return "Quit : quit the game";
	}
	public String toString() {
		
		return "Quit";
	}

}
