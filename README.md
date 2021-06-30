![Logo](https://www.cytooxien.de/data/assets/logo/Cy_T3.png)
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
Dependency:
```xml
<dependency>  
   <groupId>de.exceptionflug</groupId>  
   <artifactId>realms-api</artifactId>  
   <version>1.0-SNAPSHOT</version>  
   <scope>provided</scope>  
</dependency>
```

## Installation
Fire up your realm and just enable the `Realms-API` plugin in your plugin manager.
![Plugin Manager](https://img.exceptionflug.de/javaw_2IFmc18COR.png)
## Providers
There are the following providers available:
| Class name | Description |
|--|--|
| RealmInformationProvider | Basic information and settings of the realm |


## Access Providers
All providers are registered using Bukkit's internal `ServicesManager`. This is how you get an instance of a provider:
```java
RealmInformationProvider informationProvider = Bukkit.getServicesManager().load(RealmInformationProvider.class);
```
