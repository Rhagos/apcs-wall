# apcs-wall
AP Computer Science final project  

Wall Simulator By Anthony Ma and Daniel Wu 5/9/2016  

This program is a game where the player character builds and manages the building of a wall to keep an evil alien species from eating the village. The overall rules are that the player cannot directly build the wall or interact with the supplies or aliens. This game is a mix of a base defense/tower defense and a base management simulator, featuring basic computer controlled towers, guards, and workers along with an alien threat that must be stopped. The primary features for our program is an AI controlled population that performs the construction, defense, maintainence, and assault of the wall.

Instructions:  
Open the jar file after extracting, and follow on-screen instructions  
The workers and defenders will routinely perform their tasks autonomously and all allied units and structures are upgradable for various benefits  

Must Have
-----------------------------------------------------------------------------------
Menu with buttons and options that include instructions and settings    
(Completed) One type of worker to maintain the wall    
(Completed) One type of defense to bolster wall defenses    
(Completed) One type of guard to defend the wall 
(Completed) One main character which denotes the player which controls an array of people   
(Completed) One type of Alien enemy with a basic behavior pattern   

Want to Have
-----------------------------------------------------------------------------------
Interactive settings that can change the color/appearance of different wall parts  
Individual worker classes that have different sprites and functions  
(Completed) Multiple types of Aliens with different sprites and behaviors  
(Completed) Different types of guards that have multiple behaviors for different defense setups  
(Incomplete) Map to show alien setup   
(Completed) Simplified resource gathering setup  

Stretch
-----------------------------------------------------------------------------------
(Incomplete)Get networking to make it so that two people can play the game where one controlls the Ai and the other controlls the human defenses  
(Sort Of) Allow for terrain interactions where the player can alter the wall  
(Incomeplete) Some sort of diversion from the game that allows the humans to go on the offensive against the aliens  
(Incomeplete) Mod capabilities, allowing the player to change the source code directly  
(Sorta) Random events within the game that can completely change the situation with different variables  


Classes: 
-----------------------------------------------------------------------------------
Alien (Represents a superclass for alientype mobs)  
Base (Represent a Human Building) 
BombAlien (Represents an alien that will commit suicide and inflict massive damage to the wall) 
Building (Represents a superclass to base both person and alien spawner off of) 
DestroyerAlien (Represents an alien that will only attack walls)
Entity (Represents a superclass to base both person and alien objects off of) 
Guard (Represents a type of person that hunts all alien types) 
HunterAlien (Represents a type of alien that hunts person specific objects)
MovingImage (Represents all images used in the game)   
Person (Represents all player controllable objects)
Player (Represents the player of the game and his/her assets) 
Spawner (Represents the an alien exclusive building that creates all types of alien types) 
Wall (Represents the entire collection of wallpieces)
WallBuyScreen (Represents the option to add more guards and workers to the field) 
WallGameScreen (Represents the game panel where the game takes place)
WallInstructionsScreen (Represents the panel that describes the purpose and how to of the program)
WallMain (Represents the place where all the jPanels are called) 
WallPiece (Represents an indivudal piece that makes up the Wall)
WallRunnerScreen (Represents the first JPanel interactable with and has start, instruction, and setting buttons)
Worker (Represents an type Person object that can fix the walls that are damaged but not entirely destroyed) 

Responsibility List: 
-----------------------------------------------------------------------------------
Anthony will do Menu classes, Alien classes, Music, Sprites, Powerpoint, and Readme 
Daniel will do Person classes, Menu classes, URl, Wall/Building Clases 

Sprite/Outside Library Resources:
------------------------------------------------------------------------------------
http://millionthvector.blogspot.com/
http://7soul1.deviantart.com/art/Spaceship-Game-Sprites-385923888
http://unluckystudio.com/free-top-down-shooterplayer-sprites/
https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
