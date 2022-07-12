package com.lc.plugin.api;

import java.io.Serializable;

/**
 * 插件的版本 - 包含三个数字 - 主要、次要和分支。
 *
 * @since 0.1.0
 */
public class Version implements Comparable<Version>,Serializable {

    private static final long serialVersionUID = 2842201303893250557L;

    private final int major;

    private final int minor;

    private final int branch;

    /**
     * 从字符串创建版本。 数字使用点分割,破折号和它之后的一切都被忽略了。
     * 如果有一个数字，minor 和 branch 将被设置为 0。
     * 如果有两个数字，则 branch 将被设置为 0。
     *
     * 例如:
     *
     * <ul>
     * <li>2.3.4-SNAPSHOT: 2.3.4</li>
     * <li>2.3.4: 2.3.4</li>
     * <li>2.3: 2.3.0</li>
     * <li>2: 2.0.0</li>
     * </ul>
     *
     * @param version
     *            version
     * @throws IllegalStateException
     *             if there are more than three numbers or less than 1
     * @throws NumberFormatException
     *             if any of the number is not valid integer
     */
    public Version(final String version) {

        String[] split = version.split("-")[0].split("\\.");

        if (split.length > 3 || split.length < 1) {
            throw new IllegalStateException("Version " + version + " is invalid");
        }

        if (split.length > 0) {
            major = Integer.parseInt(split[0]);
        } else {
            major = 0;
        }

        if (split.length > 1) {
            minor = Integer.parseInt(split[1]);
        } else {
            minor = 0;
        }

        if (split.length > 2) {
            branch = Integer.parseInt(split[2]);
        } else {
            branch = 0;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(final Version otherVersion) {
        if (major < otherVersion.major) {
            return -1;
        } else if (major > otherVersion.major) {
            return 1;
        }

        if (minor < otherVersion.minor) {
            return -1;
        } else if (minor > otherVersion.minor) {
            return 1;
        }

        if (branch < otherVersion.branch) {
            return -1;
        } else if (branch > otherVersion.branch) {
            return 1;
        }

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return major + "." + minor + "." + branch;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + branch;
        result = prime * result + major;
        result = prime * result + minor;
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
        if (!(obj instanceof Version)) {
            return false;
        }
        Version other = (Version) obj;
        if (branch != other.branch) {
            return false;
        }
        if (major != other.major) {
            return false;
        }
        if (minor != other.minor) {
            return false;
        }
        return true;
    }
}
