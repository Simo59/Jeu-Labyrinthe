package character;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Maze.Cell;
import consumable.Consumable;
import scan.Scan;

public class Merchant extends Mobile_NPC {
	
	protected Map< Consumable , Map< Integer , Integer> > Shop;
	
	public Merchant(String name,Cell cell ,Consumable[] Items, int[] Quantity, int[] Price) {
		super(name,cell,"merchant");
		setShop(Items,Quantity,Price);
	}
	
	/**
	 * Set shop with array of items, prices, Quantity, index of each array correspond to the others at same index
	 * 
	 * @param Items Consumable Items : Array of items available in the shop
	 * @param Quantity int[] Quantity : Quantity of each Items
	 * @param Price  int[] Price of each Items
	 */
	public void setShop(Consumable[] Items, int[] Quantity, int[] Price) {
		this.Shop = new HashMap<>();
		Map<Integer,Integer> QandP;
		
		for (int i = 0 ; i<Items.length ; i++) {
			QandP = new HashMap<>();
			QandP.put(Quantity[i], Price[i]);
			this.Shop.put(Items[i], QandP);
		}
	}
	
	
	/**
	 * Show the shop of the merchant, Items with prices and Quantity
	 * print a String containing all the available items with prices and quantity.
	 * @return Consumable[] : the items available in the shop.
	 */
	public Consumable[] showShop() {
		
		Consumable [] Items = new Consumable[this.Shop.keySet().size()];
		this.Shop.keySet().toArray(Items);
		int [] Prices = new int[Items.length];
		int [] Quantity = new int[Items.length];
		
		for(int i = 0 ; i<Items.length ; i++) {
			Prices[i] = (int)this.Shop.get(Items[i]).values().toArray()[0];
			Quantity[i] = (int)this.Shop.get(Items[i]).keySet().toArray()[0];
		}
		String res = "Items in the shop :\n";
		for (int i = 0 ; i<Items.length ; i++) {
			res += i+" - "+Quantity[i]+" : "+Items[i].toString()+" | "+Prices[i]+" Gold\n" ;
		}
		System.out.println(res);
		return Items;
	}
	
	/**
	*Sell the selected item from what's available in Shop, item can be sold if the merchant has enough quantity of it,
	*and the hero has enough gold to buy the item. After purchase hero has his gold - item's price, merchant has item's quantity - quantity asked by hero
	*@param item Consumable item : consumable wanted by the hero
	*@param Quantity the quantity to purchase
	*@param hero : The hero who is buying
	*@return String : Indication of what happened with the purchase to the hero
	*/
	public String sell(Consumable item,int Quantity, Hero hero) {
		
		int price = (int)this.Shop.get(item).values().toArray()[0];
		int QuantityMerchant = (int)this.Shop.get(item).keySet().toArray()[0];
		
		if (this.Shop.containsKey(item) && (QuantityMerchant>0) && (QuantityMerchant>=Quantity) ) {
		
			if (hero.getGold()>=Quantity*price) {
				hero.addBag(item, Quantity);
				
				this.Shop.get(item).put(QuantityMerchant-Quantity, price);
				
				hero.setGold(hero.getGold()-price*Quantity);
				
				System.out.println(this.Shop.keySet());
				this.showShop();
				
				return "You bought "+Quantity+" "+item;
			}
			else {
				return "You can't buy this item. You don't have enough Gold.";
			}
		}
		else {
			return "There is not enough quantity for this item.";
		}
	}
	
	@Override
	public String clue( ) {
		//TODO Fonction à écrire une fois Quest implémentée
		return "";
	}
	
	/**
	 * Function which allows communication between NPC and Hero
	 * 
	 * @return String : Interaction of the Merchant with the Hero
	 */
	@Override
	public String respond(Hero h) {
		Consumable [] items=this.showShop();
		
		System.out.println("which item ? \n");
		int answer=Scan.scanInt();
		while(answer < 0 || answer >=items.length){
			System.out.println(" a valid merchandise please");
			answer=Scan.scanInt();
		}
		String answerForItem=items[answer].toString();
		Consumable item= this.getFromShopById(answerForItem);
		System.out.println("how many ? \n");
		int q=Scan.scanInt();
		return sell(item,q,h);
	}
	/**
	 * return the marchant's name.
	 * @return String : marchant's name with his title (marchant).
	 */
	public String toString() {
		return "merchant ";
	}
	/**
	 * get an item from the shop of the merchant by id.
	 * @param id String : the id of the wanted item.
	 * @return c Consumable : the wanted item.
	 */
	private Consumable getFromShopById(String id) {
		for (Consumable c :this.Shop.keySet()) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	/**
	 * Verify the shop emptiness.
	 * @return true if the shop is empty; false if not.
	 */
	public boolean emptyShop() {
		for(Consumable c :this.Shop.keySet()) {
			int quantityMerchant = (int)this.Shop.get(c).keySet().toArray()[0];
			if(quantityMerchant>0) {
				return false;
			}	
		}
		return true;
		
	}
	/**
	 * modify the availability of the merchant; has he already interacted with the hero or not.
	 */
	public void alreadyAsked() {
		if(this.emptyShop()) {
			this.status=false;
		}
			
	}
}
