package game.action;
import java.util.*;
import Maze.Cell;
import Maze.Cote;
import character.Hero;
import scan.Scan;

public class MoveAction implements Action {
	 //faut effacer dans Hero  
	@Override
    /**
     * Move the Hero in a specified direction. Can't go where there is a wall.
     * If there is a wall the hero loose a turn.
     * 
     * @param h Hero : The player
     */
	public void now(Hero h) {
		ArrayList<String>directions=new ArrayList<>();
		directions.add("nord");
		directions.add("sud");
		directions.add("est");
		directions.add("ouest");
		directions.add("exit");
		
		
		
		
		
		Cote c = null;
		boolean exit = false ;
		boolean isCote = false;
		Cote [] tab= Cote.values();
		Map<Cote,Cell> openCell=h.getCurrentCell().getPaths();
		
		
		System.out.println("Open cells  are :");
		for (Cote co : openCell.keySet()) {
			System.out.println("Cell "+openCell.get(co).getNumber() +" could be reached by choosing "+co);
		}
		
		
		System.out.println("Where do you wanna go ?");
		
		int aff =1;
		for(String d:directions) {
			System.out.println(aff+"-"+d+"\n");
			aff++;
		}
		
		
		int answer=Scan.scanInt();
		while(answer <1 || answer>5) {
			System.out.println("a valid integer please");
			answer=Scan.scanInt();
		}
		String direction=directions.get(answer-1);
		while(!exit) {
			
			
			if (direction.equals("exit")) {
				exit = true ;
			}
			else {
				for(int i =0;i<tab.length;i++) {
					if (direction.toLowerCase().equals(tab[i].toString().toLowerCase())) {
						isCote = true;
					}
		 		}
				
				if (isCote){
					exit = true;
				}
				/*else {
					// verifier cette partie
					System.out.println("The only possibility are :\n - sud\n- nord\n- est\n- ouest\n- exit\n");
					direction=scanner.next();
				}*/
			}
			
		}
			
		
		switch(direction.toLowerCase()) {
		case "sud" :
			c = Cote.SUD;
			break;
		case "nord" :
			c = Cote.NORD;
			break;
		case "est" :
			c = Cote.EST;
			break;
		case  "ouest":
			c = Cote.OUEST;
			break;
		default :
			h.setCell(h.getCurrentCell());
			
		}
    	if (isCote && h.getCurrentCell().getPaths().containsKey(c)) {
    		Cell old =h.getCurrentCell();
    		h.setCell( old.getPaths().get(c));
    		h.getCurrentCell().setCharacter(h);
    		old.removeCharacFromCell(h);
    	}
	}

	@Override
	/**
	 * @see  action.Action 
	 */
	public boolean isPossible(Hero h) {
		return true;
	}
	
	public String toString() {
		return "Move";
	}

	@Override 
	/**
	 * @see  action.Action 
	 */
	public String getDescription() {
		
		return "Move: choose a direction,but watch out you can lose a turn if you get into a wall ";
	}
}
