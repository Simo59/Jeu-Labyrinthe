package game.action;

import java.util.List;

import character.Hero;
import consumable.Consumable;
import scan.Scan;

public class UsingItemAction implements Action {

	@Override
	/**
	 * use an item from the bag
	 * @see action.Action
	 */
	public void now(Hero h) {
		
		System.out.println("which item you want to use ?");
		
		List<String>lis=h.getStrFromBag();
		
		//System.out.println(h.openBag());
		
		int aff =1;
		for(String s :lis) {
			System.out.println(aff+"-"+s+"\n");
			aff++;
		}
		int i =Scan.scanInt();
		while(i <=0 || i > lis.size()) {
			System.out.println("valid number please");
			i = Scan.scanInt();
		}
		
		String answer=lis.get(i-1);
	
		
		Consumable ob = h.removeFromBag(answer);
		System.out.println(ob.consume());
	}

	@Override
	/**
	 * @see action.Action
	 */
	public boolean isPossible(Hero h) {
		if (h.bagIsEmpty()) 
		   return false;
		return true;
	}
	
	
	public String toString() {
		return "UsingItem";
	}

	@Override
	/**
	 * @see action.Action
	 */
	public String getDescription() {
		
		return "UsingItem : Use an item from the bag";
	}

}
