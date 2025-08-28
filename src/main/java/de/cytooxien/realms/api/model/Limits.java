package de.cytooxien.realms.api.model;

import org.jetbrains.annotations.NotNull;

/**
 * This model class specifies the limits of the realm according to it's current boost level.
 * <p>
 * Date: 30.06.2021
 *
 * @author Exceptionflug
 */
public record Limits(long cpuLimit,
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
    public @NotNull String toString() {
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
