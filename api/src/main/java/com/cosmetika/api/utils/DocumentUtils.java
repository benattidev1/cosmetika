package com.cosmetika.api.utils;

public class DocumentUtils {

    private DocumentUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String normalizeDocument(String document) {
        if (document == null || document.isBlank()) {
            return null;
        }
        return document.replaceAll("[^a-zA-Z0-9]", "");
    }
}
