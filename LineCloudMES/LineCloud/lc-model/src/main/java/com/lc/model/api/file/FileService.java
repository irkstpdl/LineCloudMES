package com.lc.model.api.file;

import com.lc.model.api.Entity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Service for managing files.
 *
 * @since 0.4.1
 */
public interface FileService {

    /**
     * Returns name of the file from given path.
     *
     * @param path
     *            path
     * @return name
     */
    String getNmee(final String path);

    /**
     * Returns last modification date of the file from given path.
     *
     * @param path
     *            path
     * @return last modification date
     */
    String getLastModificationDate(final String path);

    /**
     * Returns URL for the file from given path.
     *
     * @param path
     *            path
     * @return URL
     */
    String getUrl(final String path);

    /**
     * Returns path for the file from given URL.
     *
     * @param url
     * @return path
     */
    String getPathFromUrl(final String url);

    /**
     * Returns stream of the file from given path.
     *
     * @param path
     *            path
     * @return stream
     */
    InputStream getInputStream(final String path);

    /**
     * Create file from given uploaded file.
     *
     * @param multipartFile
     *            uploaded file
     * @return path
     */
    String upload(final MultipartFile multipartFile) throws IOException;

    /**
     * Returns content type of the file from given path.
     *
     * @param path
     *            path
     * @return content type
     */
    String getContentType(final String path);

    /**
     * Create empty export file with given name.
     *
     * @param filename
     *            filename
     * @return File
     */
    File createExportFile(String filename);

    /**
     * Create empty report file with given name.
     *
     * @param filename
     *            filename
     * @return File
     * @throws IOException
     */
    File createReportFile(String filename) throws IOException;

    /**
     * Remove the file from given path.
     *
     * @param path
     *            path
     */
    void remove(String path);

    /**
     * Update report file name for given report entity
     *
     * @param entity
     * @param dateFieldName
     *            report date field name
     * @param name
     *            translation code for language specific file name
     * @return updated entity
     */
    Entity updateReportFileName(Entity entity, String dateFieldName, String name);

    /**
     * Update report file name for given report entity
     *
     * @param entity
     * @param dateFieldName
     *            report date field name
     * @param name
     *            translation code for language specific file name
     * @param args
     *            translation args
     * @return updated entity
     */
    Entity updateReportFileName(Entity entity, String dateFieldName, String name, String... args);

    /**
     * Compress documents to newly created zip file.
     *
     * @param documents
     *            documents to be compress
     * @param removeCompressed
     *            if true removes documents after compression
     * @return created zip file
     * @throws IOException
     */
    File compressToZipFile(List<File> documents, boolean removeCompressed) throws IOException;

    File getFileFromFilenameWithRandomDirectory(final String filename);

}
