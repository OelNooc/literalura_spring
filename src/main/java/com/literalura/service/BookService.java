package com.literalura.service;

import com.literalura.dto.BookResponseDTO;
import com.literalura.model.Author;
import com.literalura.model.Book;
import com.literalura.repository.BookRepository;
import com.literalura.util.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BookService {

    private ApiService apiService;
    private BookRepository bookRepository;
    private AuthorService authorService;
    private Scanner scanner = new Scanner(System.in);

    public BookService(ApiService apiService, BookRepository bookRepository, AuthorService authorService) {
        this.apiService = apiService;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public void searchBookByTitle() {

        System.out.println("Escriba el nombre del libro a buscar");
        String bookName = scanner.nextLine();
        BookResponseDTO bookDTO = apiService.getBookByName( bookName );

        if (bookDTO == null) {
            System.out.println("No se encontró ningún libro con el título: " + bookName);
            return;
        }

        Author author = authorService.findOrCreateAuthor( bookDTO.authors().get(0) );

        Book book = BookMapper.toEntity(bookDTO);
        book.setAuthor(author);
        bookRepository.save(book);

        System.out.println(book);

    }

    public void listRegisteredBooks() {

        List<Book> books = bookRepository.findAll();

        if( !books.isEmpty()){
            books.forEach(System.out::println);
        }else{
            System.out.println("No hay libros agregados");
        }
    }

    public void listBooksByLanguage() {
        List<String> languages = bookRepository.groupByBooksLanguage();

        for (int i = 0; i < languages.size(); i++) {
            System.out.println((i + 1) + ". " + languages.get(i));
        }

        System.out.println("Ingrese el numero del idioma de los libros a buscar");
        String input = scanner.nextLine();
        int option;

        if (!input.matches("\\d+")) {
            System.out.println("Solo se permiten números");
            return;
        }
        option = Integer.parseInt(input);
        option = option -1;

        List<Book> books = bookRepository.findByLanguage( languages.get(option) );

        if ( !books.isEmpty()){
            books.forEach(System.out::println);
        }else{
            System.out.println("No Se encontró el libro");
        }
    }
}
