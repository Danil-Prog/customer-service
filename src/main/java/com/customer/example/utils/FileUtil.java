package com.customer.example.utils;

import com.customer.example.exception.FileNotFoundException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileUtil {

    public static boolean isFileExist(String path) {
        return Files.exists(Paths.get(path));
    }

    public static File getFile(String path) {
        if (isFileExist(path)) {
            return new File(path);
        }
        throw new FileNotFoundException("On the way " + path + " the file was not found");
    }
}
