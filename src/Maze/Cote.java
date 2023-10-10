package Maze;

public enum Cote {
 NORD,SUD,EST,OUEST/*,HAUT,BAS*/;
	
/**
 * get the inverse of each COTE
 * @return the inverse of the cote
 **/
public Cote inverse() {
	//if(this.getNum() == 1){
		//return Cote.SUD;}
	switch(this) {
		case NORD:
			return Cote.SUD;
		case SUD :
			return Cote.NORD;
		case EST :
			return Cote.OUEST;
		default : 
			return Cote.EST;
		/*case 5:
			return Cote.BAS;
		case 6:
			return Cote.HAUT; */
	}
		

		
}



}

