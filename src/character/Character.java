package character;
import Maze.*;

public abstract class Character {

    protected String name;
    protected Cell currentCell;
    protected String id; 

    public Character(String name, Cell cell,String id){
        this.name = name;
        this.currentCell = cell;
        this.id=id;
    }
    /**
     *Set the name of a character.
     * @param n the string that will be given to the character.
     */
    public void setName(String n){
        this.name = n;
    }
    /**
     * get the name of a character.
     * @return the name of the character.
     */
    public String getName(){
        return this.name;
    }
    /**
     * set the cell of a character.
     * @param c the cell that will be assigned to the character.
     */
    public void setCell(Cell c){
        this.currentCell = c;
    }
    
    
    /**
     * Return the current Cell of a Character.
     * @return Cell : Current Cell of the Character.
     */
    public Cell getCurrentCell() {
    	return this.currentCell;
    }
    
    /**
     * get the ID of a character.
     * @return the string id of a character.
     */
    public String getId() {
    	return this.id;
    }
    /**
     * return the name of the character.
     * @return the name of the character.
     */
    public String toString() {
    	return this.name;
    }

}
