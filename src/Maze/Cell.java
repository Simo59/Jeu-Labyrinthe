package Maze;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import character.Character;
import character.*;
import consumable.Consumable;

public class Cell {
	
	private Map<Cote,Cell> paths;
	private int coordX;
	private int coordY; 
	private  int  number ;// pour mieux reconnaitre les cell
	private Consumable tresor;
	private List<Character> charactersOnTheCell;
	private int gold;
	/**
	 * create a cell with coordinate x and y 
	 * @param x : the coordinate x of the cell
	 * @param y : the coordinate y of the cell
	 * @param number the number of the cell in the maze
	 * */
	public Cell(int x,int y,int number) {
		this.coordX=x;
		this.coordY=y;
		this.paths=new HashMap<>();
		this.tresor=null;
		this.number = number;
		this.charactersOnTheCell=new ArrayList<>();
		this.gold=0;
	}
	
	/**
	 * Close the walls of the cell
	 */
	private void closeCell() {
		// BOUCLE POUR LES COTE ET REMOVE A LA PLACE DE PUT 
		this.paths.remove(Cote.NORD);
		this.paths.remove(Cote.SUD);
		this.paths.remove(Cote.EST);
		this.paths.remove(Cote.OUEST);
	} 
	
	/**
	 * Get the coordinate on x of the cell
	 * */
	public int getCoordX() {
		return this.coordX;
	}
	
	
	/**
	 * Get the coordinate on y of the cell
	 * */
	public int getCoordY() {
		return this.coordY;
	}
	
	/**
	 * Close the the wall c of the cell
	 * @param c the wall of the cell to close
	 * @param cel the cell situated after the current cell by the dircetion c 
	 * */
	
	public void closeCote(Cote c, Cell cel) {
		this.paths.remove(c);
		cel.getPaths().remove(c.inverse());
	}
	
	/**
	 * Open the wall given  of the cell
	 * @param c the wall to open
	 * @param cel the cell situated next to the wall will be opened 
	 * */
	public void openCote(Cote c, Cell cel) {
		this.paths.put(c, cel);
		cel.getPaths().put(c.inverse(),this);
	}
	
	/**
	 * Get the map of walls 
	 * @return the walls of the cell 
	 * */
   public Map<Cote,Cell> getPaths() {
	   return this.paths;
   }
   
    
   /**
    * Get the list of mobile NPC present on the cell
    * @return the list of mobile NPC present on the cell
    */
   public List<Mobile_NPC> getMobileNPCs(){
	   List<Mobile_NPC> res=new ArrayList<>();
	   for(Character c : this.charactersOnTheCell) {
		   if(c instanceof Mobile_NPC) {
			   res.add((Mobile_NPC)c);
		   }
	   }
	   return res;
   }
	
   /**
    * Set a consumable in the cell 
    * @param c a consumable 
    */
   public void setTresor(Consumable c) {
	   this.tresor=c;
   }
   
   /**
    * Verify if there is a consumable on the cell or no
    * @return true if there is a consumable else false
    */
   public boolean containsTresor() {
	   return this.tresor!=null;
   }
   
   /**
    * Get the consumable on the cell
    * @return the consumable on the cell if there isn't ot returns null
    */
   public Consumable getTresor() {
	   return this.tresor;
   }
   
   /**
    * Set a character into the cell
    * @param c the character to set
    */
   public void setCharacter(Character c) {
	   this.charactersOnTheCell.add(c);
	   c.setCell(this);
   }
   
   /**
    * Unset a character in the cell
    * @param c the character to unset
    */
   public void unsetCharacter(Character c) {
	   this.charactersOnTheCell.remove(c);
   } 
   
   /**
    * Get the list of the characters on the cell
    * @return the characters on the cell
    */
   public List<Character> getCharcters(){
	   return this.charactersOnTheCell;
   }
   
   /**
    * Get the number of the cell given when creation
    * @return the number of the cell given when creation
    */
   public int getNumber() {
	   return this.number;
   }
   
   /**
    * Remove a consumable from the cell
    * @param c the consumable to remove
    */
   public void removeFromTresor(Consumable c) {
		this.tresor=null;
		
	}
   
   /**
    * Remove a character from the cell 
    * @param c the character removed 
    */
   public void removeCharacFromCell(Character c) {
	   for(Character i :this.charactersOnTheCell) {
		   if(c.getId().equals(i.getId())) {
			   this.charactersOnTheCell.remove(i);
			   break;
		   }
	   }
   }
   
   /**
    * Verify if the hero is on the cell or not 
    * @return true if the hero is on the cell else fals
    */
   public boolean isHeroOnTheCell() {
	   for (Character c:this.charactersOnTheCell) {
		   if (c instanceof Hero ) {
			   return true;
		   }
	   }
	   return false;
   }
   
   /**
    * Get the list of NPCs that can be asked 
    * @return the list of NPCs that can be asked 
    */
   public List<NPC> whoCanbeAsked(){
	   List <NPC> listeNpc = new ArrayList<>();
	   List <NPC> res = new ArrayList<>();
	   for (Character c:this.charactersOnTheCell) {
		   if (c instanceof NPC ) {
			   listeNpc.add((NPC)c);
		   }
	   }
	   
	   for (NPC c:listeNpc) {
		   if (  c.getStatus()) {
			   res.add(c);
		   }
	   }
	   return res;
   }

   
   /**
    * display the cell 
    * @return a string reprsenting the cell
    */
   
	public String toString() {
		String res="";
		//res="the coorinate x of this Cell are " + this.coordX +" and the coordinate y are "+ this.coordY+"\n";
		res ="You are on the cell number "+this.number+"\n\n";
		if(this.charactersOnTheCell.size()>1) {
			res+= "The charcters on the cell are: \n";
			for (Character c :this.charactersOnTheCell) {
				if(c instanceof Hero == false) {
					res=res+"\t- "+c.toString()+"\n";
				}
			}
		}
		if (this.tresor != null) {
			res =res+"There is : "+this.tresor.toString()+" in the room\n";
		}
		if (this.gold!=0) {
			res += "There is : "+this.gold+" pieces on the floor ...";
		}
		return res ;
	}

	/**
	 * Get the number of gold present in the cell
	 * @return the number of gold present in the cell
	 */
	public int getGold() {
		return this.gold;
	}

	/**
	 * Set a number of gold to the cell
	 * @param g the new number of gold
	 */
	public void setGold(int g) {
		this.gold=g;
	}
	
	
	public String display() {
		String res="Cell "+ this.number+"there is "+this.gold+"pieces";
		if(this.charactersOnTheCell.size()!=0) {
			res+=" \n and there is ";
			for(Character c :this.charactersOnTheCell) {
				res+=c.toString();
			}
		}
		if(this.containsTresor()) {
			res+="it contains "+this.tresor;
		}
		return res;
	}
	

}
