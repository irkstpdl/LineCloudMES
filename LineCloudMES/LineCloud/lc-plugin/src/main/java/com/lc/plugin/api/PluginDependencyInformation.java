package com.lc.plugin.api;

/**
 * Plugin's requirements. It holds required plugin's identifier and optionally required version.
 *
 * @since 0.1.0
 */
public class PluginDependencyInformation {

    private final String identifier;

    private final VersionOfDependency version;

    /**
     * Creates requirement for plugin with given identifier, no required version provided.
     *
     * @param identifier
     *            required plugin's identifier
     */
    public PluginDependencyInformation(final String identifier) {
        this(identifier, new VersionOfDependency(""));
    }

    /**
     * 为具有给定标识符和版本的插件创建要求。
     * @param identifier
     *            required plugin's identifier
     * @param version
     *            required plugin's version
     */
    public PluginDependencyInformation(final String identifier,final VersionOfDependency version) {
        this.identifier =identifier;
        this.version = version;
    }

    /**
     * 返回所需插件的标识符。
     *
     * @return 所需插件的标识符
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 返回所需插件的版本
     *
     * @return 所需插件的版本
     */
    public VersionOfDependency getVersionOfDependency() {
        return version;
    }

    /**
     * Returns true if the required plugin's version contains the given one.
     *
     * @param version
     *            version
     * @return true if the required plugin's version contains the given one
     */
    public boolean contains(final Version version) {
        return this.version.contains(version);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return identifier + " " + version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PluginDependencyInformation)) {
            return false;
        }
        PluginDependencyInformation other = (PluginDependencyInformation) obj;
        if (identifier ==null) {
            if (other.identifier !=null) {
                return false;
            }
        } else if (!identifier.equals(other.identifier)) {
            return false;
        }
        if (version == null) {
            if (other.version !=null) {
                return false;
            }
        } else if (!version.equals(other.version)) {
            return false;
        }
        return true;
    }

}
