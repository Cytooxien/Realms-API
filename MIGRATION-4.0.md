# Migration Guide: 3.x → 4.0.1

This guide helps you upgrade your plugins and integrations from Realms API 3.x to 4.0.1.

4.0.1 introduces SemVer versioning, new events, enum-based language handling, and record-based models. Several breaking API changes are listed below with concrete before/after examples.

## 1) Adjust Imports for World Enums

Moved from `...world` to `...enums`:

- `de.cytooxien.realms.api.world.WorldRule` → `de.cytooxien.realms.api.enums.WorldRule`
- `de.cytooxien.realms.api.world.WorldPreset` → `de.cytooxien.realms.api.enums.WorldPreset`

## 2) Language Is Now an Enum

Before (3.x):

```java
String lang = playerInfo.language(playerId);
if ("DE".equalsIgnoreCase(lang)) { ... }
```

After (4.0.1):

```java
import de.cytooxien.realms.api.enums.Language;

Language lang = playerInfo.language(playerId);
if (lang == Language.DE) { ... }
```

## 3) Player Boost Queries Moved

- Removed: `RealmInformationProvider.boostsByPlayer(UUID)`
- New: `PlayerInformationProvider` now provides player-specific boost access:

```java
Action<Integer> count = playerInfo.boostCount(playerId);
Action<List<Boost>> list = playerInfo.boosts(playerId);
```

The realm-wide `int boostCount()` on `RealmInformationProvider` remains unchanged.

## 4) Models are Java Records

`Group`, `Limits`, `DefinedWorld`, and `Boost` are records. JavaBean-style getters are removed. Use record component accessors.

Examples:

- `group.getName()` → `group.name()`
- `limits.getMaxPlayers()` → `limits.maxPlayers()`
- `definedWorld.getWorldFolder()` → `definedWorld.worldFolder()`

Factory methods like `Group.create(...)` and `DefinedWorld.create(...)` remain and return records.

## 5) Boost Model Changes

- New record: `Boost(UUID playerId, long expireTimestamp, int amount)`
- Field rename: `expireDate` → `expireTimestamp` (Unix epoch seconds)
- Collections: `Boost[]` → `List<Boost>`

Example:

```java
Boost boost = ...;
UUID id = boost.playerId();
int amount = boost.amount();
Instant expiry = Instant.ofEpochSecond(boost.expireTimestamp());
```

## 6) New Events

Register listeners as usual and consume the new events:

```java
@EventHandler
public void onBoost(RealmBoostEvent e) {
  int amount = e.getBoostAmount();
  long expires = e.getExpireTimestamp();
}

@EventHandler
public void onJoin(RealmPlayerJoinEvent e) {
  JoinReason reason = e.getJoinReason();
}

@EventHandler
public void onLanguage(RealmPlayerLanguageChangeEvent e) {
  Language oldLang = e.getOldLanguage();
  Language newLang = e.getNewLanguage();
}

@EventHandler
public void onPrePause(RealmPrePauseEvent e) { /* ... */ }

@EventHandler
public void onPostPause(RealmPostPauseEvent e) { /* ... */ }
```

## 7) Quick Checklist

- Update dependency coordinates to JitPack and version `4.0.1`.
- Replace imports of `WorldRule`/`WorldPreset` to `...enums`.
- Change `language(UUID)` usage to `Language` enum.
- Replace `boostsByPlayer(...)` with `PlayerInformationProvider.boostCount(...)` / `boosts(...)`.
- Update model access to record component methods (no JavaBean getters).
- Adjust any `Boost` handling to `expireTimestamp` (epoch seconds) and `List<Boost>`.
- Build against minimum Paper 1.21.1 and Java 21.

If you run into anything not covered here, please open an issue with code examples so we can extend this guide.
