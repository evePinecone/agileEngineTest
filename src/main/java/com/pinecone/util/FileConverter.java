package com.pinecone.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class FileConverter {

    private static String CHARSET_NAME = "utf8";

    public static File convertToFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                return file;
            }
        }
        System.err.println("No such file exception " + path);
        throw new IOException();
    }

    public static Document convertFileToDocument(File file) throws IOException {
        return Jsoup.parse(
                file,
                CHARSET_NAME,
                file.getAbsolutePath());

    }
}
