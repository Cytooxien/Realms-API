# Changelog

All notable changes to this project are documented in this file.

## 4.0.1

### Fixed
- Derive `RealmPlayerJoinEvent` from `PlayerEvent` (was `PlayerJoinEvent`).
- Add a dedicated `HandlerList` and decouple dispatch from Bukkit's `PlayerJoinEvent` pipeline.

## 4.0.0

This is a major release with breaking API changes.

### Added
- New events:
  - `RealmBoostEvent`
  - `RealmPlayerJoinEvent`
  - `RealmPlayerLanguageChangeEvent`
  - `RealmPrePauseEvent`, `RealmPostPauseEvent`
- New enums: `Language`, `JoinReason`.
- New player boost accessors on `PlayerInformationProvider`:
  - `Action<Integer> boostCount(UUID playerId)`
  - `Action<List<Boost>> boosts(UUID playerId)`

### Changed
- Versioning switched to SemVer; current artifact version is `4.0.0`.
- Refactor models to Java records: `Group`, `Limits`, `DefinedWorld`, `Boost`.
- Moved `WorldRule` and `WorldPreset` from `de.cytooxien.realms.api.world` to `de.cytooxien.realms.api.enums`.
- `PlayerInformationProvider.language(UUID)` now returns `Language` enum instead of `String`.
- Player-specific boost query moved from `RealmInformationProvider` to `PlayerInformationProvider`.
- Boost model field renamed: `expireDate` → `expireTimestamp` (Unix epoch seconds), and boost collections now use `List<Boost>` instead of `Boost[]`.

### Removed
- `RealmInformationProvider.boostsByPlayer(UUID)`.
- JavaBean-style getters on models that are now records (use record component accessors instead, e.g. `group.name()`).

### Migration
See `MIGRATION-4.0.md` for step-by-step migration instructions from 3.x to 4.0.0.
