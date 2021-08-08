![Logo](https://i.imgur.com/6QQrjjA.png)
# Realms Api
This is the repository of the Cytooxien Realm API. Here you can find the wiki which contain basic information about the usage of this API.

## Maven
Repository:
```xml
<repository>  
   <id>exceptionflug</id>  
   <url>https://mvn.exceptionflug.de/repository/exceptionflug-public/</url>  
</repository>
```
Dependencies:
```xml
<!-- Actual RealmsAPI -->
<dependency>  
   <groupId>de.exceptionflug</groupId>  
   <artifactId>realms-api</artifactId>  
   <version>1.1-SNAPSHOT</version>  
   <scope>provided</scope>  
</dependency>
<!-- Cytooxien Realms Display System -->
<dependency>
  <groupId>de.cytooxien.realms</groupId>
  <artifactId>realms-spigot-display</artifactId>
  <version>0.1</version>
  <scope>provided</scope>
</dependency>
```

## Installation
Fire up your realm and just enable the `Realms-API` plugin in your plugin manager.


![Plugin Manager](https://i.imgur.com/XW4S9vO.png)
## Providers
There are the following providers available:
| Class name | Description |
|--|--|
| RealmInformationProvider | Basic information and settings of the realm |
| RealmPermissionProvider | Allows you to access and realm permission groups |


## Access Providers
All providers are registered using Bukkit's internal `ServicesManager`. This is how you get an instance of a provider:
```java
RealmInformationProvider informationProvider = Bukkit.getServicesManager().load(RealmInformationProvider.class);
```

## Access Display System
You can access the display system using the following code:
```java
DisplayController controller = JavaPlugin.getPlugin(DisplayPlugin.class).displayController();
```

### Changing the prefix of a player
This is a quick example on how to change the prefix of a player:
```java
DisplayController controller = JavaPlugin.getPlugin(DisplayPlugin.class).displayController();
MasterDisplayData masterDisplayData = controller.getCache().getMaster(player.getUniqueId());
// This sets prefix to "§a" for CHAT, TABLIST and NAMETAG
masterDisplayData.getPrefixes().forEach((displayTarget, map) -> map.put("group", "§a"));
```

### Add suffix for a player which can only be seen by another player
You can edit the DisplayData for a special viewer:
```java
DisplayController controller = JavaPlugin.getPlugin(DisplayPlugin.class).displayController();
DiffedDisplayData diff = controller.getCache().getDiff(player.getUniqueId(), viewer.getUniqueId());
diff.getSuffixes().get(DisplayTarget.TABLIST).put("party", "§8[§dParty§8]");
```