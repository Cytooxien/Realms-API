package de.cytooxien.realms.api.model;

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
