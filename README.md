# Space-Invaders


> This project implements arrays, classes, and methods to create a Space Invaders type game. The main class was the Frame class that calls all other classes and methods to run the program. 

## How to Play

> To begin, select a difficulty by pressing either 1, 2, or 3 on your keyboard. Use the WASD or arrow keys to control the ship and space to fire. The objective of this game is to clear the screen of all the aliens while avoiding all the enemy bombs, and once that is complete, you will level up. As you progress, the amount of time you have to complete each level decreases.

![image](https://user-images.githubusercontent.com/67216058/148602901-f0ff2d2b-e626-47a1-a2e0-1d627db4ef34.png)
![image](https://user-images.githubusercontent.com/67216058/148603150-0ceb355d-5acb-4b39-9d4a-3316ac604c43.png)

## Gameplay
https://user-images.githubusercontent.com/78383186/148603002-b7068385-8e32-4dc1-b48d-632e983a690d.mp4

## Characters
![image](https://user-images.githubusercontent.com/67216058/148603758-5bb4cf0f-d0ed-40c7-bcd7-8df9cc89a923.png)
![image](https://user-images.githubusercontent.com/67216058/148604110-4f4d6a63-6d8d-4b6d-a8cb-af83a0276a77.png)
![image](https://user-images.githubusercontent.com/67216058/148604161-5dee37b5-0145-40ad-a6ef-f44c92e34ff3.png)

### These are the aliens. After the collapse of your colony, these aliens are invading your world to collect your remaining resources. Your job is to destroy them.



## Frame

![image](https://user-images.githubusercontent.com/78383186/148125433-3c1f5492-fa44-4ced-b4a3-edab907b3585.png)   
#### The top of the class was devoted to initializing all of the ArrayLists, objects, and variables used in the program.
![image](https://user-images.githubusercontent.com/78383186/148125510-b2cb5c19-5158-427c-b2db-9dbc7c2bf20e.png)   
#### This method would initialize the JFrame window so that the program can be viewed.
![image](https://user-images.githubusercontent.com/78383186/148125745-c993796b-a6aa-43f2-a3e8-7b6577f20a9d.png)   
#### The first if statement checks if the time has run out in the game. If it isn't it changes the time by one second and if it is it ends the game. The second if statement checks if the stage has been cleared so that it can deisplay the next stage.
![image](https://user-images.githubusercontent.com/78383186/148125772-230a7ab8-03b9-4057-afbc-d9a5fd687c67.png) 
#### These if statements display text when needed throughout the program.
![image](https://user-images.githubusercontent.com/78383186/148125807-2000b458-d8ba-480a-8ca4-eebea3a62d45.png)    
#### This area paints all the elements in the program
![image](https://user-images.githubusercontent.com/78383186/148125849-1ac6f00e-a76e-48ed-a6e6-d6b9de90d75f.png)
#### When there is a game over, this code runs to do certain actions.
![image](https://user-images.githubusercontent.com/78383186/148125933-a2e3c6bd-410a-4344-a323-874fdadf8714.png)   
#### This block fo code fires the projectile and calculates the rate of fire when left click is pressed.
![image](https://user-images.githubusercontent.com/78383186/148125998-edc0591e-c845-455d-aedf-3c784546712b.png)    
#### The if loop here moves all of the objects in the game.
![image](https://user-images.githubusercontent.com/78383186/148126055-8a6afd45-0a6d-4e04-959b-ac49fd82cf83.png)   
#### This code moves the player from left to right.
![image](https://user-images.githubusercontent.com/78383186/148126113-eec959c7-2ab9-4fbd-8b6b-a7eb7107397f.png)    
#### Here is where the program sets the difficulty when the user inputs a key.
![image](https://user-images.githubusercontent.com/78383186/148126151-3ccce086-72c7-4fdc-8c3f-8169780e001b.png)    
#### This code stops the player from moving and fires/calculates the rate of fire of the projectile when space is pressed.
![image](https://user-images.githubusercontent.com/78383186/148126186-0d56d925-0f15-4a90-8183-ad2cc7c8d99c.png)   
#### There are 4 blocks of code each a copy of the one displayed that finds out when a projectile hits an enemy.
![image](https://user-images.githubusercontent.com/78383186/148126265-bf766c41-2e1e-4592-9fa4-4dfc93fc58f3.png)   
#### This code checks when the stage is cleared and returns a boolean value.
![image](https://user-images.githubusercontent.com/78383186/148126334-ac7702b6-9cd9-4cf5-a6c5-b81d655d4b6a.png)    
#### These two pieces of code reset all parameter either for the start of the game or for the next stage.
![image](https://user-images.githubusercontent.com/78383186/148126385-09e8c135-94e6-464b-8444-a1ba9e69e9ab.png)    
#### This increments the time for each second and gives extra score for the time remaining.
![image](https://user-images.githubusercontent.com/78383186/148126434-29fa590b-c529-44b8-bc7b-7325efc06810.png)    
#### The first method displays the stage number. The next method calculates the amount of bullets the enemies fire.
![image](https://user-images.githubusercontent.com/78383186/148126456-b336343d-f476-4807-a4f4-34fde69d43d1.png)    
#### These 3 methods each change certain variables for the difficulty. 
