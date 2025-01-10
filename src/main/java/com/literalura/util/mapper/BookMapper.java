package com.literalura.util.mapper;

import com.literalura.dto.BookResponseDTO;
import com.literalura.model.Book;

public class BookMapper {

    public static Book toEntity(BookResponseDTO dto){

        Book book  = new Book();
        book.setTitle(dto.title());
        book.setMediaType(dto.mediaType());
        book.setLanguage(dto.language());
        book.setDownloadCount(String.valueOf(dto.downloadCount()));
        return book;
    }
}
