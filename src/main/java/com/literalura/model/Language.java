package com.literalura.model;

public enum Language {
    US("Ingles"),
    ES("Español");

    private String omdbCategory;

    Language(String omdbCategory) {
        this.omdbCategory = omdbCategory;
    }

    public static Language fromString(String text) {

        for (Language categoria : Language.values()) {
            if (categoria.omdbCategory.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ningún lenguaje encontrada: " + text);
    }

}
