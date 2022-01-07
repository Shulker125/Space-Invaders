# Space-Invaders

> This project implements arrays, classes, and methods to create a Space Invaders type game. The main class was the Frame class that calls all other classes and methods to run the program. 

# How to Play

> To begin, select a difficulty by pressing either 1, 2, or 3 on your keyboard. Use the WASD or arrow keys to control the ship and space to fire. The objective of this game is to clear the screen of all the aliens, and once that is complete, you will level up. As you progress, the amount of time you have to complete each level decreases.

![image](https://user-images.githubusercontent.com/67216058/148602901-f0ff2d2b-e626-47a1-a2e0-1d627db4ef34.png)


## Background
![Capture](https://user-images.githubusercontent.com/67216058/148125948-3f45b715-d9ca-4a3f-90a9-69f2e4dc3fe5.PNG)
#### This class had code that relates to the background of the game. It had 2 methods that changed the background each stage and resetted the background to the first index.
  
## Enemy
![Capture1](https://user-images.githubusercontent.com/67216058/148125946-1d810cc7-b833-406e-99f5-8f79e6492e53.PNG)
#### This class had code that relates to the enemies in the game. There are 4 rows of enemies in the game but the code is the same for all of them. It has only one method that controls the bounds of the enemy ships.

## Player
![Capture2](https://user-images.githubusercontent.com/67216058/148125944-6f50173f-d02f-4aa8-973d-6aca384ee14f.PNG)

## Projectile
![Capture3](https://user-images.githubusercontent.com/67216058/148125950-d3583789-c761-4ac0-bb3c-dd1e89fcea45.PNG)

## Title
![Capture4](https://user-images.githubusercontent.com/67216058/148125949-26125074-205e-4896-adbd-1e38a5f54dfd.PNG)


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
