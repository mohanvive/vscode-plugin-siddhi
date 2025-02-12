package io.siddhi.langserver.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * File utils for reading the file content.
 */
public class FileUtil {

    private static final JsonParser JSON_PARSER = new JsonParser();

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

    public static final Path RES_DIR = Paths.get("src/test/resources/").toAbsolutePath();

    /**
     * Get the file content.
     * @param filePath path to the file
     * @return {@link JsonObject} file content as a jsonObject
     */
    public static JsonObject fileContentAsObject(String filePath) {
        String contentAsString = "";
        try {
            contentAsString = new String(Files.readAllBytes(RES_DIR.resolve(filePath)));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return JSON_PARSER.parse(contentAsString).getAsJsonObject();
    }

    /**
     * Get the file content.
     * @param filePath path to the file
     * @return {@link String} file content as a String
     */
    public static String fileContent(String filePath) {
        String stringContent = "";
        try {
            stringContent = new String(Files.readAllBytes(RES_DIR.resolve(filePath)));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return stringContent;
    }
}
