package com.literalura.util.mapper;

import com.literalura.dto.AuthorReponseDTO;
import com.literalura.model.Author;

public class AuthorMapper {

    public static Author toEntity(AuthorReponseDTO authorDTO){

        Author author = new Author();
        author.setName( authorDTO.name());
        author.setBirthYear( authorDTO.birthYear() != null ? authorDTO.birthYear() : 0);
        author.setDeathYear( authorDTO.deathYear() != null ? authorDTO.deathYear() : 0);

        return author;
    }
}
