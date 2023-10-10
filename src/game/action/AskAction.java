package game.action;
import scan.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import character.*;
import character.Character;

public class AskAction implements Action {

	@Override
	/**
	 * @see  action.Action 
	 * ask a charachter present on the current cell of the hero
	 */
	public void now(Hero h) {
		List<NPC> lc = new ArrayList<>();
		// recuperer tout les caaractere sur la cell ;
		lc=h.getCurrentCell().whoCanbeAsked();
		
		System.out.println("which one to ask?");
		int i=1;
		for (Character c :lc ) {
			System.out.println(i+"-"+c+"\n");
			i++;
		}
		//Scanner scan = new Scanner(System.in);
		int answer = Scan.scanInt();
		while(answer <=0 || answer > lc.size()) {
			System.out.println("valid number please");
			answer = Scan.scanInt();
		}
		NPC toAsk=lc.get(answer-1);
		System.out.println(toAsk.respond(h));
		toAsk.alreadyAsked();
		

	}

	@Override
	public boolean isPossible(Hero h) {
		if(h.getCurrentCell().whoCanbeAsked().size() >0) {
				return true;
	     }
		return false;

}
	
	public String toString() {
		return "ask";
	}

	@Override
	public String getDescription() {
		
		return "Ask: Ask A charachter present in the same cell you can win a hint ";
	}
}
