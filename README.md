![Logo](https://i.imgur.com/6QQrjjA.png)
# Realms Api
This is the repository of the Cytooxien Realm API. Here you can find the wiki which contain basic information about the usage of this API.

[![](https://jitpack.io/v/cytooxien/realms-api.svg)](https://jitpack.io/#cytooxien/realms-api)

## Maven
Repository:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
Dependencies:
```xml
<dependency>  
   <groupId>com.github.cytooxien</groupId>  
   <artifactId>realms-api</artifactId>  
   <version>4.0.1</version>  
   <scope>provided</scope>  
</dependency>
```

## Gradle
Repository:
```gradle
repositories {
    maven {
        url 'https://jitpack.io'
    }
}
```
Dependencies:
```gradle
dependencies {
    compileOnly 'com.github.cytooxien:realms-api:4.0.1'
}
```

## Access Providers
All providers are registered using Bukkit's internal `ServicesManager`. This is how you get an instance of a provider:
```java
RealmInformationProvider informationProvider = Bukkit.getServicesManager().load(RealmInformationProvider.class);
```

## Access Display System
You can access the display system using the following code:
```java
DisplayProvider displayProvider = Bukkit.getServicesManager().load(DisplayProvider.class);
```

### Changing the prefix of a player
This is a quick example on how to change the prefix of a player:

```java
DisplayProvider displayProvider = Bukkit.getServicesManager().load(DisplayProvider.class);
// changes the chat prefix of a player
displayProvider.setCustomChatPrefix(player, Component.text("Group", NamedTextColor.RED));
// changes the tab prefix of a player
displayProvider.setCustomTabPrefix(player, Component.text("Group", NamedTextColor.RED));
```
