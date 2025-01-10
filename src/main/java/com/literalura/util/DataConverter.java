package com.literalura.util;

public interface DataConverter {
    public <T> T getData(String json, Class<T> className);
}
