package com.literalura.service;

import com.literalura.dto.ApiResponseDTO;
import com.literalura.dto.BookResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    private final String BASE_URL = "http://gutendex.com/books";
    private ApiClientService apiClientService;
    private JsonParseService jsonParseService;

    public ApiService(ApiClientService apiClientService, JsonParseService jsonParseService) {
        this.apiClientService = apiClientService;
        this.jsonParseService = jsonParseService;
    }

    public BookResponseDTO getBookByName(String bookName){
        String url = BASE_URL + "/?search=" + bookName.replace(" ","+");
        String jsonResponse = apiClientService.sendHttpGet(url);

        ApiResponseDTO response = jsonParseService.getData(jsonResponse, ApiResponseDTO.class);

        if (response != null && response.books() != null && !response.books().isEmpty()) {
            return response.books().get(0);
        } else {
            return null;
        }
    }
}
