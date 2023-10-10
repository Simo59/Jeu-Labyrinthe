package game;
import java.util.*;
import scan.Scan;

import Maze.*;

import character.*;

import consumable.*;

import game.goals.*;

public class GameMain {
	private static Random alea = new Random();

	
	public static void main(String[]args) {
		int x,y;
		Maze maze;


		
		int lab = choseAlgo();
		
		x = choseWidth();
		
		y = choseHeight();
		
		switch(lab) {
			case 1:
				maze=new RecursiveMaze(x,y);
				break;
			case 2 :
				maze=new SideWinderMaze(x,y);
			default :
				maze=new BinaryMaze(x,y);
				break;
		}
		Goals goldGoal=new GoldGoal(200);
		Goals oneCellGoal=new OneCellGoal(maze.getCell(0, 0));
		List<Goals>tg=new ArrayList<>();
		tg.add(oneCellGoal);
		tg.add(goldGoal);
		Goals cg=new CompositeGoal(tg);
		//Hero
		Hero hero = initHero(x, y, maze);
		//Sphinx
		initSphinx(x, y,maze,cg);
		
		//Merchant
		initMerchant(x, y, maze);
		
		//Selfless
		initSelfless(x, y, maze,cg);
		
		//Insane
		initInsane(x, y, maze,cg);
		
		// Qlqs objets pour tester seulement
		int x_red=alea.nextInt(x);
		int y_red=alea.nextInt(y);
		Cell c_red=maze.getCell(x_red, y_red);
		//Consumable redCr=new PurpleCrystal(c_red,maze);
		
		
		
		int x_blue=alea.nextInt(x);
		int y_blue=alea.nextInt(x);
		Cell c_blue=maze.getCell(x_blue, y_blue);
		
		//blueCr2.setCell(c_blue);
		//maze.display();
		
		// partie pour tester notre travail pour l instant
		
		/*List<Cell> tcel=new ArrayList<>();
		List<Goals> tg=new ArrayList<>();
		tcel.add(maze.getCell(0, 0));
		tcel.add(maze.getCell(0, 1));
		Goals g=new CellGoals(tcel);
		tg.add(g);// tester les objectifs*/
		
		
		
		
		// tester le jewel 
		//Consumable jewel = new Jewel(150);
		//jewel.setCell(maze.getCell(0, 0));
		Consumable scroll = new Scroll(maze, cg);
		scroll.setCell(maze.getCell(0, 0));
		maze.getCell(0,0).setGold(140);
		Play test = new Play(cg,hero,maze);
		test.run();
			
	
	}

	private static void initInsane(int x, int y, Maze maze,Goals g) {
		int x_i = alea.nextInt(x);
		int y_i = alea.nextInt(y);
		Cell c_i = maze.getCell(x_i, y_i);
		Insane i = new Insane("Prince", c_i);
		i.setQuest(g);
		c_i.setCharacter(i);
	}

	private static void initSelfless(int x, int y, Maze maze,Goals g) {
		int x_sl = alea.nextInt(x);
		int y_sl = alea.nextInt(y);
		Cell c_sl = maze.getCell(x_sl, y_sl);
		Selfless sl = new Selfless("Kurt", c_sl);
		sl.setQuest(g);
		c_sl.setCharacter(sl);
	}

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

	private static void initMerchant(int x, int y, Maze maze) {
		int x_m = alea.nextInt(x);
		int y_m = alea.nextInt(y);
		Cell c_m = maze.getCell(x_m, y_m);
		PurpleCrystal p_c = new PurpleCrystal(maze) ;
		
		RedCrystal p_b = new RedCrystal(maze) ;
		Consumable [] items = {p_c,p_b};
		int [] quantity = {1,1};
		int [] price = {1,1};
		Mobile_NPC selfless = new Merchant("Marchant", c_m,items,quantity,price);
		c_m.setCharacter(selfless);
	}

	private static Hero initHero(int x, int y, Maze maze) {
		System.out.println("Quel est ton nom ?");
		String name=Scan.scanStr();
		int x_h = alea.nextInt(x);
		int y_h = alea.nextInt(y);
		Cell c_h = maze.getCell(x_h, y_h);
		Hero hero = new Hero(name,c_h,100);
		c_h.setCharacter(hero);
		return hero;
	}

	private static int choseHeight() {
		int y;
		System.out.println("Quelle est la longueur de votre labyrinth");
		y=Scan.scanInt();
		while(y>100) {
			System.out.println("entrez une longueur plus petite ");
			y=Scan.scanInt();
		}
		return y;
	}

	private static int choseWidth() {
		int x;
		System.out.println("Quelle est la largeur de votre labyrinth");
		x=Scan.scanInt();
		while(x>100) {
			System.out.println("entrez une largeur plus petite");
			x=Scan.scanInt();
		}
		return x;
	}

	private static int choseAlgo() {
		System.out.println("Dans quelle Labyrinthe voulez vous jouer ?");
		System.out.println("1-recursive\n2-SideWinder\n3-Arbre binaire");
		System.out.println("choisissez un numero");
		
		int lab=Scan.scanInt();
		while (lab <1 || lab >3) {
			System.out.println("entrez un numero valide");
			lab=Scan.scanInt();
		}
		return lab;
	}
}
