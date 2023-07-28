package org.itacademy.squeezertest.utils;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Log4j2
public class JsonUtils {

    public static <T> T getObjectFromFile(String fileName, Class<T> clazz) {
        log.info("filename: " + fileName + " class: " + clazz);
        URL resourceItems = JsonUtils.class.getClassLoader().getResource("data/" + fileName);
        File fileItems = new File(Objects.requireNonNull(resourceItems).getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        T object;
        try {
            object = objectMapper.readValue(fileItems, clazz);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public static void setObjectToFile(Object object, String fileName) {
        File file = new File("src/main/resources/data/" + fileName);
        try {
            file.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(file, object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}