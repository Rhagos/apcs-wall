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
One type of worker to maintain the wall    
One type of defense to bolster wall defenses    
One type of guard to defend the wall and man the defense structure   
One main character which denotes the player which controls an array of people   
One type of Ai which has a set playstyle when interacting with the main character   
One type of Alien enemy with a basic behavior pattern   

Want to Have
-----------------------------------------------------------------------------------
Interactive settings that can change the color/appearance of different wall parts  
Individual worker classes that have different sprites and functions  
Multiple types of Aliens with different sprites and behaviors  
Different types of guards that have multiple behaviors for different defense setups  
Map to show alien setup   
Simplified resource gathering setup  

Stretch
-----------------------------------------------------------------------------------
Get networking to make it so that two people can play the game where one controlls the Ai and the other controlls the human defenses  
Allow for terrain interactions where the player can alter the wall  
Some sort of diversion from the game that allows the humans to go on the defensive against the aliens  
Mod capabilities, allowing the player to change the source code directly  
Random events within the game that can completely change the situation with different variables  
Interaction with out of settlement variables  

Classes: 
-----------------------------------------------------------------------------------
DrawingSurface (PApplet drawings)   
WallGame (Main runner)   
WallPiece (Represents the wall in the game)   
Person (Represents a person)   
Worker (Represents a builder of the wall)   
Guard (Represents a guard of the wall)     
Player (Represents the player of the game and his/her resources)   
Alien (Represents an alien enemy)  

Responsibility List: 
-----------------------------------------------------------------------------------
Anthony will do DrawingSurface, Wall, Wallpiece, Player, + sprites   
Daniel will do Person, Worker, Guard, Player  

Sprite Resources:
------------------------------------------------------------------------------------
http://millionthvector.blogspot.com/
http://7soul1.deviantart.com/art/Spaceship-Game-Sprites-385923888
http://unluckystudio.com/free-top-down-shooterplayer-sprites/
https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
