package character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Maze.Cell;
import Maze.Cote;
import consumable.Consumable;
import game.action.*;

public class Hero extends Character {

    protected Map<Consumable,Integer> bag;
    protected int gold;
    protected List<Action> allActions;


    public Hero(String name,Cell cell,int gold){
        super(name,cell,"hero");
        this.bag=new HashMap<>();
        this.gold = gold;
        this.allActions=new ArrayList<>();
        this.initAllActions();
    }
    
    /**
     * enable the player to use actions available for the hero.
     */
    private void initAllActions() {
    	this.allActions.add(new MoveAction());
    	this.allActions.add(new AskAction());
    	this.allActions.add(new AddingItemAction());
    	this.allActions.add(new UsingItemAction());
    	this.allActions.add(new HelpAction());
    	this.allActions.add(new AddGoldAction());
    	this.allActions.add(new QuitAction());
    }

    /**
     * Set the gold of the Hero
     * @param g int : number of gold we want to set for the hero
     */
    public void setGold(int g){
        this.gold = g;
    }
    
    /**
     * Return the gold of the Hero 
     * @return int : Hero's gold
     */
    public int getGold(){
        return this.gold;
    }
    
    /**
     * Open the hero's bag 
     * @return String : bag inside's description.
     */
    public String openBag(){
    	String res = "";
        res += "The bag contains :\n";
        for(Map.Entry<Consumable,Integer> entry : this.bag.entrySet()){
            res += entry.getKey()+" quantity : "+ entry.getValue()+"\n";
        }
        return res;
    }
    /**
     * add an integer value to the integer gold of the Hero.
     * @param g int : the quantity of gold to be added to the hero's account.
     */
    public void addGold(int g) {
    	this.gold+=g;
    }
    
  
    /**
     * Add a consumable with a quantity to the bag of the Hero
     * If items already in the bag it add the consumable to the one in the bag
     * Otherwise it puts items in the bag
     * 
     * @param c Consumable : Consumable added to the Bag
     * @param Q int : Quantity of the consumable
     * @return String : Indicates if the items was added to the bag
     */
    public String addBag(Consumable c,int Q) {
    	if (!this.bag.containsKey(c)) {
    		this.bag.put(c, Q);
    		c.setHero(this);
    	}
    	else {
    		this.bag.put(c,this.bag.remove(c)+Q);
    	}
    	
    	return "Item(s) added to the bag";
    }
    /**
     * Verify if the bag is empty.
     * @return True if empty; false if not.
     */
    public boolean bagIsEmpty() {
    	if(this.bag.keySet().size()==0) {
    		return true;
    	}
    	for (Consumable c : this.bag.keySet()) {
    		if(this.bag.get(c)>0) {
    			return false ;
    		}
    	}
    	return true;
    }
    /**
     * returns the bag of the hero
     * @return Map : bag, the bag of the hero.
     */
    public Map<Consumable,Integer> getBag(){
    	return this.bag;
    }
    /**
     * remove a item from the hero's bag.
     * @param id String : the id of the selected item.
     * @return consumable : res, the item removed from the bag.
     */
    public Consumable removeFromBag(String id) {
    	List <Consumable> tmp=new ArrayList<>();
    	for (Consumable c : this.bag.keySet()) {
    		if(this.bag.get(c)>0 && c.getId().equals(id)) {
    			tmp.add(c);
    		}
    	}
    	Consumable res =tmp.get(0);
    	this.bag.put(res, this.bag.get(res)-1);
    	return res;
    }
    
    
    /**
     * return all actions available to the hero.
     * @return List : allActions, the available actions list.
     */
    public List<Action>getAllActions(){
    	return this.allActions;
    }
    
    /**
     * return a String list of the item of the bag (to browse through the menu using numbers). 
     * @return List  : res, the list of strings. 
     */
    public List<String> getStrFromBag(){
    	List<String> res=new ArrayList<>();
    	for (Consumable c : this.bag.keySet()) {
    		if(this.bag.get(c)>0) {
    		res.add(c.toString());
    		}
    	}
    	return res;
    }
    
    public String toString() {
    	return "hero";
    	
    }
    


}
