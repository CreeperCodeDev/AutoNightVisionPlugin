# AutoNightVisionPlugin
Minecraft server plugin for auto enabling night vision for a player/all players.  Can also manually enable/disable night vision for a user or all users until they respawn.

## Platform Information
- Tested on PaperMC (https://papermc.io/) version 1.18.1
- Java version: OpenJDK 17
- Dev Platform: IntelliJ Community Edition

## Installation
1. Using IntelliJ open the pom.xml file
2. Click the icon to import Maven dependencies (this may take a few moments)
3. Expand the Maven tab on the top right to access Maven commands
4. Expand "AutoNightVisionPlugin" > "Lifecycle" and double click on "Package"
5. Check the console for errors. If there are no errors look in your local project folder for a new folder called "target" This is where you will find the compiled jar file.
6. Place compiled jar (AutoNightVisionPlugin-1.0.jar) in the server "plugins" folder and restart:


    Example:
    /opt/minecraft/paper/plugins/AutoNightVisionPlugin-1.0.jar

## Usage:
Note: This plugin is only available to Operators

    Enable plugin: 
    /nightvision on

    Disable plugin:
    /nightvision off

    Get plugin status:
    /nightvision status

    Manually turn on nightvision for a user. Example, they were already on the server when OP enabled the plugin.
    /nightvision USERNAME on

    Manually turn off nightvision for a user.  Users on respawn will get night vision again.
    /nightvision USERNAME off

    Manually turn on nightvision for all users.
    /nightvision @a on

    Manually turn off nightvision for all users. Users on respawn will get night vision again.
    /nightvision @a off

