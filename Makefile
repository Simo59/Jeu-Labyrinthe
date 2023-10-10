all : play

classes : src/character/*.java src/consumable/*.java src/game/*.java src/Maze/*.java src/game/goals/*.java src/game/action/*.java
	javac -sourcepath src  -d classes  src/character/*.java
	javac -sourcepath src  -d classes src/consumable/*.java
	javac -sourcepath src  -d classes src/game/*.java
	javac -sourcepath src  -d classes src/game/goals/*.java
	javac -sourcepath src  -d classes src/game/action/*.java
	javac -sourcepath src  -d classes src/Maze/*.java
	
play : classes
	java -classpath classes game.ClassicalGame 2

jar : classes
	jar cvfe jeu.jar game.ClassicalGame -C classes .

doc :src
	javadoc -sourcepath src -d docs -subpackages Maze game game.action game.goals character consumable scan
	
tests:
	javac -classpath test4poo.jar test/*/*.java
	java -jar test4poo.jar  <nom de la classe>

clean :
	rm -rf classes/
	rm -f jeu.jar
