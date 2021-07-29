package de.exceptionflug.realms.api.model;

import java.util.Objects;

/**
 * This model class specifies the limits of the realm according to it's current boost level.
 *
 * Date: 30.06.2021
 *
 * @author Exceptionflug
 */
public class Limits {

    private final long cpuLimit;
    private final long memoryMegabytes;
    private final long diskMegabytes;
    private final int loadedWorldsCount;
    private final int customGroupsCount;
    private final int unusedShutdownMinutes;
    private final int stoppedUnloadMinutes;
    private final boolean customPlugins;
    private final int pluginCount;
    private final int maxPlayers;
    private final boolean subdomain;

    private Limits(long cpuLimit,
                   long memoryMegabytes,
                   long diskMegabytes,
                   int loadedWorldsCount,
                   int customGroupsCount,
                   int unusedShutdownMinutes,
                   int stoppedUnloadMinutes,
                   boolean customPlugins,
                   int pluginCount,
                   int maxPlayers,
                   boolean subdomain) {
        this.cpuLimit = cpuLimit;
        this.memoryMegabytes = memoryMegabytes;
        this.diskMegabytes = diskMegabytes;
        this.loadedWorldsCount = loadedWorldsCount;
        this.customGroupsCount = customGroupsCount;
        this.unusedShutdownMinutes = unusedShutdownMinutes;
        this.stoppedUnloadMinutes = stoppedUnloadMinutes;
        this.customPlugins = customPlugins;
        this.pluginCount = pluginCount;
        this.maxPlayers = maxPlayers;
        this.subdomain = subdomain;
    }

    public long cpuLimit() {
        return cpuLimit;
    }

    public long memoryMegabytes() {
        return memoryMegabytes;
    }

    public long diskMegabytes() {
        return diskMegabytes;
    }

    public int loadedWorldsCount() {
        return loadedWorldsCount;
    }

    public int customGroupsCount() {
        return customGroupsCount;
    }

    public int unusedShutdownMinutes() {
        return unusedShutdownMinutes;
    }

    public int stoppedUnloadMinutes() {
        return stoppedUnloadMinutes;
    }

    public boolean customPlugins() {
        return customPlugins;
    }

    public int pluginCount() {
        return pluginCount;
    }

    public int maxPlayers() {
        return maxPlayers;
    }

    public boolean subdomain() {
        return subdomain;
    }

    public static Limits create(long cpuLimit,
                                long memoryMegabytes,
                                long diskMegabytes,
                                int loadedWorldsCount,
                                int customGroupsCount,
                                int unusedShutdownMinutes,
                                int stoppedUnloadMinutes,
                                boolean customPlugins,
                                int pluginCount,
                                int maxPlayers,
                                boolean subdomain) {
        return new Limits(cpuLimit, memoryMegabytes, diskMegabytes, loadedWorldsCount,
                customGroupsCount, unusedShutdownMinutes, stoppedUnloadMinutes, customPlugins,
                pluginCount, maxPlayers, subdomain);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Limits limits = (Limits) o;
        return cpuLimit == limits.cpuLimit && memoryMegabytes == limits.memoryMegabytes && diskMegabytes == limits.diskMegabytes && loadedWorldsCount == limits.loadedWorldsCount && customGroupsCount == limits.customGroupsCount && unusedShutdownMinutes == limits.unusedShutdownMinutes && stoppedUnloadMinutes == limits.stoppedUnloadMinutes && customPlugins == limits.customPlugins && pluginCount == limits.pluginCount && maxPlayers == limits.maxPlayers && subdomain == limits.subdomain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpuLimit, memoryMegabytes, diskMegabytes, loadedWorldsCount, customGroupsCount, unusedShutdownMinutes, stoppedUnloadMinutes, customPlugins, pluginCount, maxPlayers, subdomain);
    }

    @Override
    public String toString() {
        return "Limits{" +
                "cpuLimit=" + cpuLimit +
                ", memoryMegabytes=" + memoryMegabytes +
                ", diskMegabytes=" + diskMegabytes +
                ", loadedWorldsCount=" + loadedWorldsCount +
                ", customGroupsCount=" + customGroupsCount +
                ", unusedShutdownMinutes=" + unusedShutdownMinutes +
                ", stoppedUnloadMinutes=" + stoppedUnloadMinutes +
                ", customPlugins=" + customPlugins +
                ", pluginCount=" + pluginCount +
                ", maxPlayers=" + maxPlayers +
                ", subdomain=" + subdomain +
                '}';
    }
}
