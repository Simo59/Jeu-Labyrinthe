package game;
import java.util.*;
import scan.Scan;
import Maze.*;
import character.*;
import consumable.*;
import game.goals.*;

public class ClassicalGame {

	private static Random alea = new Random();

	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("an Integer beetwen 1 and 3 in parameter ");
			System.exit(0);
		}
		
		int w = 10;
		int h = 10;
		
		int choice =Integer.parseInt(args[0]);
		Maze maze =initMaze(choice,w,h);
		Hero hero = initHero(w,h,maze);
		Goals goals = initGoals(maze);
		initCharacter(w,h,maze,goals);
		initItems(w,h,maze,goals);		
		
		Play play = new Play(goals, hero, maze);
		play.run();
	}
	/**
	 * creates a maze defined by the following parameters.
	 * @param choice int : choice between the 3 available maze algorithm.
	 * @param w int :  define the width of the maze (in cell number)
	 * @param h int : define the height of the maze (in cell number)
	 * @return the maze created.
	 */
	private static Maze initMaze(int choice,int w,int h) {
		Maze maze;
		if(choice == 1) {maze=new BinaryMaze(w,h);}
		else if( choice ==2) {maze=new SideWinderMaze(w,h);}
		else {maze=new RecursiveMaze(w,h);}
		
		int nbCells = (w*h)/10;
		for (int i = 0; i<nbCells; i++) {
			int xc =alea.nextInt(w);
			int yc =alea.nextInt(h);
			if (maze.getCell(xc, yc).getGold() != 0) {nbCells++;}
			maze.getCell(xc, yc).setGold(1);
		}
		
		return maze;
	}
	/**
	 * spawns all characters into the maze.
	 * @param w : the width of the maze, needed to spawn characters in a location of the maze.
	 * @param h : the height of the maze, needed to spawn characters in a location of the maze.
	 * @param maze : the maze in which characters will be spawned.
	 * @param goals : what goals will be needed to win the game, needed in order to give clues to characters.
	 */
	private static void initCharacter(int w, int h, Maze maze, Goals goals) {
		int nbSphynx=7;
		int nbInsane=7;
		int nbSelfless=6;
		int nbMerchant=6;
		
		for(int i = 0; i<nbInsane; i++) {initInsane(w,h,maze,goals);}
		for(int i = 0; i<nbSelfless; i++) {initSelfless(w,h,maze,goals);}
		for(int i = 0; i<nbSphynx; i++) {initSphinx(w,h,maze,goals);}
		for(int i = 0; i<nbMerchant; i++) {initMerchant(w,h,maze,goals);}
	}
	/**
	 * spawns all items needed into the maze.
	 * @param w : the width of the maze, needed to spawn item within the size of the maze.
	 * @param h : the height of the maze, needed to spawn item  within the size of the maze.
	 * @param maze : the maze in which items will be spawned.
	 * @param goals : what goals will be needed to win the game, needed in order to give a clue to a hero using the scroll.
	 */ 
	private static void initItems(int w, int h, Maze maze, Goals goals) {
		int nbRedCrystal=6;
		int nbPurpleCrystal=6;
		int nbJewel=6;
		int nbScroll=6;
		for(int i = 0; i<nbRedCrystal; i++) {initRedCrystal(w,h,maze);}
		for(int i = 0; i<nbPurpleCrystal; i++) {initPurpleCrystal(w,h,maze);}
		for(int i = 0; i<nbJewel; i++) {initJewel(w,h,maze,1);}
		for(int i = 0; i<nbScroll; i++) {initScroll(w,h,maze,goals);}
	}
	/**
	 * spawns a scroll into the maze.
	 * @param x int : the width of the maze, needed to spawn item within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn item  within the size of the maze.
	 * @param maze Maze : the maze in which the scroll will be spawned
	 * @param goals Goals : what goal will be contained by the scroll.
	 */
	private static void initScroll(int x, int y, Maze maze,Goals goals) {
		int x_blue=alea.nextInt(x);
		int y_blue=alea.nextInt(y);
		Cell c = maze.getCell(x_blue,y_blue);
		while (c.getTresor()!= null) {
			x_blue=alea.nextInt(x);
			y_blue=alea.nextInt(y);
			c = maze.getCell(x_blue,y_blue);
		}
		Consumable skurt = new Scroll(maze,goals);
		skurt.setCell(c);
	}
	
	/**
	 * spawns a jewel into the maze.
	 * @param x int : the width of the maze, needed to spawn item within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn item  within the size of the maze.
	 * @param maze Maze : the maze in which the scroll will be spawned
	 * @param g int :  how much gold the jewel will convert into.
	 */
	private static void initJewel(int x, int y, Maze maze, int g) {
		int x_blue=alea.nextInt(x);
		int y_blue=alea.nextInt(y);
		Cell c = maze.getCell(x_blue,y_blue);
		while (c.getTresor()!= null) {
			x_blue=alea.nextInt(x);
			y_blue=alea.nextInt(y);
			c = maze.getCell(x_blue,y_blue);
		}
		Consumable jew = new Jewel(g);
		jew.setCell(c);
	}
	/**
	 * spawns a Red Crystal into the maze.
	 * @param x int : the width of the maze, needed to spawn item within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn item  within the size of the maze.
	 * @param maze Maze : the maze in which the RedCrystal will be spawned
	 */
	
	private static void initRedCrystal(int x,int y,Maze maze) {
		int x_blue=alea.nextInt(x);
		int y_blue=alea.nextInt(y);
		Cell c=maze.getCell(x_blue, y_blue);
		while (c.getTresor()!= null) {
			x_blue=alea.nextInt(x);
			y_blue=alea.nextInt(y);
			c = maze.getCell(x_blue,y_blue);
		}
		Consumable bCr = new RedCrystal(maze);
		bCr.setCell(c);
	}
	/**
	 * spawns a Purple Crystal into the maze.
	 * @param x int : the width of the maze, needed to spawn item within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn item  within the size of the maze.
	 * @param maze Maze : the maze in which the PurpleCrystal will be spawned
	 */
	private static void initPurpleCrystal(int x,int y,Maze maze) {
		int x_blue=alea.nextInt(x);
		int y_blue=alea.nextInt(y);
		Cell c=maze.getCell(x_blue, y_blue);
		while (c.getTresor()!= null) {
			x_blue=alea.nextInt(x);
			y_blue=alea.nextInt(y);
			c = maze.getCell(x_blue,y_blue);
		}
		Consumable rCr = new PurpleCrystal(maze);
		rCr.setCell(c);
	}
	/**
	 * creates goals for the hero to accomplish. 
	 * @param maze Maze : the maze in which the goals will be created.
	 * @return cg CompositeGoal : all the goals that will be created for the game.
	 */
	private static Goals initGoals(Maze maze) {
		Goals goldGoal=new GoldGoal(5);
		Goals oneCellGoal=new OneCellGoal(maze.getCell(8, 3));
		List<Goals>tg=new ArrayList<>();
		tg.add(oneCellGoal);
		tg.add(goldGoal);
		Goals cg=new CompositeGoal(tg);
		return cg;
	}
	/**
	 * spawns an insane NPC into the maze.
	 * @param x int : the width of the maze, needed to spawn the character within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn the character within the size of the maze.
	 * @param maze Maze : the maze in which the insane will be spawned.
	 * @param g Goals : the goal used for giving a clue to the player.
	 */
	private static void initInsane(int x, int y, Maze maze,Goals g) {
		int x_i = alea.nextInt(x);
		int y_i = alea.nextInt(y);
		Cell c_i = maze.getCell(x_i, y_i);
		Insane i = new Insane("Prince", c_i);
		i.setQuest(g);
		c_i.setCharacter(i);
	}
	/**
	 * spawns a selfless NPC into the maze.
	 * @param x int : the width of the maze, needed to spawn the character within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn the character within the size of the maze.
	 * @param maze Maze : the maze in which the selfless will be spawned.
	 * @param g Goals : the goal used for giving a clue to the player.
	 */
	private static void initSelfless(int x, int y, Maze maze,Goals g) {
		int x_sl = alea.nextInt(x);
		int y_sl = alea.nextInt(y);
		Cell c_sl = maze.getCell(x_sl, y_sl);
		Selfless sl = new Selfless("Kurt", c_sl);
		sl.setQuest(g);
		c_sl.setCharacter(sl);
	}
	/**
	 * spawns a Sphinx NPC into the maze.
	 * @param x int : the width of the maze, needed to spawn the character within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn the character within the size of the maze.
	 * @param maze Maze : the maze in which the Sphinx will be spawned.
	 * @param g Goals : the goal used for giving a clue to the player.
	 */
	private static void initSphinx(int x, int y,Maze maze,Goals g) {
		int x_sx = alea.nextInt(x);
		int y_sx = alea.nextInt(y);
		Cell c_sx = maze.getCell(x_sx, y_sx);
		String[] q = {
				"Quel est le nom de la plus grande pyramide d'Egypte ?",
				"Quel est le nom du monstre du labyrinthe ?",
				"Dans la mythologie Grecque, où est construit le labyrinthe de Dédale pour y enfermer un monstre ?",
				"Comment ai-je perdu mon nez ?"
				};
		String[] r = {
				"Khéops",
				"Minotaur",
				"Crète",
				"Obelix"
				,};
		Sphinx sphx = new Sphinx("Sphinx",c_sx,q,r);
		sphx.setQuest(g);
		c_sx.setCharacter(sphx);
	}
	/**
	 * spawns a Merchant NPC into the maze.
	 * @param x int : the width of the maze, needed to spawn the character within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn the character within the size of the maze.
	 * @param maze Maze : the maze in which the Merchant will be spawned.
	 * @param g Goals : the goal used for giving a clue to the player.
	 */
	private static void initMerchant(int x, int y, Maze maze,Goals goals) {
		int x_m = alea.nextInt(x);
		int y_m = alea.nextInt(y);
		Cell c_m = maze.getCell(x_m, y_m);
		PurpleCrystal p_c = new PurpleCrystal(maze) ;
		RedCrystal p_b = new RedCrystal(maze) ;
		Consumable skurt = new Scroll(maze,goals);
		Consumable jew = new Jewel(2);
		Consumable [] items = {p_c,p_b,skurt,jew};
		int [] quantity = {1,1,1,1};
		int [] price = {1,1,2,1};
		Mobile_NPC merchant = new Merchant("Marchant", c_m,items,quantity,price);
		c_m.setCharacter(merchant);
	}
	/**
	 * Creates a hero for the player to play the game.
	 * @param x int : the width of the maze, needed to spawn the character within the size of the maze.
	 * @param y int : the height of the maze, needed to spawn the character within the size of the maze.
	 * @param maze Maze : the maze in which the insane will be spawned.
	 * @return hero Hero : the hero of the game, that will be controlled by the player.
	 */
	private static Hero initHero(int x, int y, Maze maze) {
		System.out.println("Quel est ton nom ?");
		String name=Scan.scanStr();
		int x_h = alea.nextInt(x);
		int y_h = alea.nextInt(y);
		Cell c_h = maze.getCell(x_h, y_h);
		Hero hero = new Hero(name,c_h,0);
		c_h.setCharacter(hero);
		return hero;
	}

}
