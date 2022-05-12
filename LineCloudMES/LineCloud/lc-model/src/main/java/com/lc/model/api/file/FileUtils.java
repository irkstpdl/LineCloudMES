package com.lc.model.api.file;

import com.lc.model.internal.file.FileServiceImpl;

/**
 * Helper for getting the {@link FileService} instance.
 *
 * @since 0.4.1
 */
public final class FileUtils {

    private FileUtils() {
    }
    /**
     * Returns the {@link FileService} instance.
     *
     * @return file service
     */
    public static FileService  getInstance(){
        return FileServiceImpl.getInstance();
    }
}
