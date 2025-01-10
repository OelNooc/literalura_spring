package com.literalura;

import com.literalura.service.AuthorService;
import com.literalura.service.BookService;
import main.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {


    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Menu menu = new Menu( bookService, authorService );
        menu.menuOptions();
    }
}
