## LDTS_0606 - Shell Shift

Shell Shift is an endless platformer where the player tries to survive for the longest time by dodging or killing enemies or by avoiding falling outside the map borders. Collect coins along the way to enhance Chell's strength and upgrade her weaponry through the in-game Shop.

After navigating the dangerous Aperture Science facility, Chell stumbles upon a mysterious portal that transports her not to another testing chamber, but to an unfamiliar and surreal realm – the Linux Shell. Now your mission is to get Chell through the unstable Shell and all its unique bugs. Gather coins and eliminate every bug you encounter, all while maintaining a careful balance and ensuring Chell doesn't succumb to the lethal consequences of the Shell's coding abyss.

This project is developed by *António Santos* (*up202205469@up.pt*), *Vanessa Queirós* (*up202207919@up.pt*) and *Vasco Costa* (*up202109923@up.pt*) for LDTS 23/24.

### IMPLEMENTED FEATURES

- **Main Menu** - When the game starts, a player will be prompted with options to the different menus available as well as starting a game or exiting the application. [Current Main Menu implemented](CurrentMainMenu.png)

### PLANNED FEATURES

- **Movement** - Chell will be able to move in every direction as well as jumping when the arrow keys are pressed.
- **Shooting** - Chell carries a gun that can be shot using the space bar.
- **Platforms** - Random platforms will appear throughout the infinite game.
- **Monsters, Coins & PowerUps** - As you navigate through the endless platforms, different monsters, coins and powerups will appear on Chell's path. 
- **Chell Colision** - If Chell collides with a monster she will be hurt and lose a percentage of HP.
- **Screen Borders** - If Chell either falls off a platform or leaves the screen's left border, she will die.
- **Collecting Coins** - Throughout the game there will appear coins, when Chell goes over them they will be added to her own coins.
- **Shop** - Using the coins she gathered, Chell will be able to upgrade her equipment and buy extra-lives.
- **Gun Upgrades** - After collecting enough coins, Chell will be able to buy different gun upgrades: *rapid fire*, *extra damage*, etc.
- **Player Statistics** - A player can check Chell's statistics, such as *Coins Collected*, *Monsters Killed*, before and after each played game.
- **"AI" Monsters** - Monsters will be able to follow Chell's movement as well as throw projectiles in her way.

#### Mockups:
- [Main Menu](MainMenuMockUp.jpg)
- [Gameplay](InGameMockUp.jpg)
- [Shop](ShopMockUp.jpg)
- [Player Statistics](StatisticsMockUp.jpg)


# Model-View-Controller Pattern

In the initial design of our game, there was a lack of clear separation between the user interface, game logic, and data. This made it challenging to maintain and extend the codebase, while maintaining code readibility. 

MVC separates the application into three interconnected components:

1. **Model (Data):** Represents the game data, including Chell (with lives and a gun), the gun (with bullets and a `FireStrategy`), different enemies, platforms, coins, and bullets (with an associated `damageMultiplier`). The model encapsulates the game's data and logic, managing the state of the game and interactions between different elements.
2. **View (User Interface):** Manages the presentation of the game and its various menus to the player. This includes rendering Chell, enemies, platforms, coins, and other visual elements. The view interacts with the model to obtain necessary data for display.
3. **Controller (User Input):** Handles user input and translates it into actions that the model and view can understand. This involves managing player movements and interactions between different game elements, such as collisions. The controller communicates with the model to update the game state based on user input.

![](MVC.png)
- [Models Implementation](https://github.com/FEUP-LDTS-2023/project-l06gr06/tree/bb562b88bc7733ae005f4d3ad7aadc0dbc0a4ef2/src/main/java/com/l06g06/shellshift/model)
- [Viewers Implementation](https://github.com/FEUP-LDTS-2023/project-l06gr06/tree/bb562b88bc7733ae005f4d3ad7aadc0dbc0a4ef2/src/main/java/com/l06g06/shellshift/viewer)
- [Controllers Implementation](https://github.com/FEUP-LDTS-2023/project-l06gr06/tree/bb562b88bc7733ae005f4d3ad7aadc0dbc0a4ef2/src/main/java/com/l06g06/shellshift/controller)

# State Pattern

While designing the UML we noticed that our game would have issues transitioning from menu to menu and from menu to the actual game. We noticed these issues because we had planned to use if conditions to determine if a certain condition was met. 

This meant that the game would start with a menu loop which would interact with the controller for the menu. Depending on the user choice (let's assume that it decides to start the game) the loop would now stop and a new loop (the actual game) would be started.

But then we realized that this would be very inefficient as every state (when Chell dies, when the player decides to go to the shop or when the player decides to see the rankings) would not only require if conditions inside the aforementioned loops but would require new loops and possibly goto statements.

So to solve this issue we decided to implement the State Pattern. This allows for the concrete state and it's controller to decide what to do next (controller is the transition). Also the loops would be a lot more simpler as each state would have a single instruction `step` which allows us to recive a `KeyPress`, execute a call to the concrete controller to process the `KeyPress` and a call to the concrete viewer to draw the GUI. 

This way Game would only require a single loop ( containing `step` ) and we would also not have to worry about other if conditions, loops or goto statements as these are handled by the respective state.

![](StateDiagram.png)
# Strategy Pattern

Soon in the development process, we decided that having multiple types of enemies/monsters aswell as different types of guns, would make the gameplay more interesting and engaging. 

To achieve this we decided to implement two different Strategy Pattern:
- **EnemyStrategy**: This interface defines a method `move()`  used by two different moving strategies for enemies, `VerticalEnemyStrategy` blocking movement on the x axis and `HorizontalEnemyStrateggy` blocking movement on the y axis.

![](EnemyStrategyUML.png)

- **FireStrategy**: Chell's gun has a different firing strategy allowing not only to diversify the shooting mechanics but also to simplify the process of adding new mechanics in the future. Every class that implements `FireStrategy`has a `fire()` method that will make the bullets behave in different ways. For example, `SpreeFireStrategy`, will make the gun similar to a shotgun, with 3 bullets shot at the same time with different angles.

![](FireStrategyUML.png)

# Adapter Pattern
Although we are only using Lanterna on our game, there could be an instance where it would be interesting to use a different library to handle the graphical parts of the Game.
To achieve this goal, we have an interface `GUI` with the methods that we have found relevant to process graphics in our game, such as `drawText` or `drawChell`, that are implemented using Lanterna in `LanternaGui` and used by `Viewer<T>`.

![](AdapterUML.png)
- [GUI Wrapper implementation](https://github.com/FEUP-LDTS-2023/project-l06gr06/tree/bb562b88bc7733ae005f4d3ad7aadc0dbc0a4ef2/src/main/java/com/l06g06/shellshift/gui)

---

### SELF-EVALUATION

- António Santos: 33%
- Vanessa Queirós: 33%
- Vasco Costa: 33%