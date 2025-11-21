package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book")
    public String getBook(@RequestParam String bookName, @RequestParam Integer bookPages) {

        log.info(bookName);
        log.info(bookPages.toString());

        BookEntity existingBook =  bookRepository.findByNameAndPages(bookName, bookPages);

        if (existingBook == null) {

            BookEntity newbook = BookEntity.builder()
                    .name(bookName)
                    .pages(bookPages)
                    .build();

            bookRepository.save(newbook);

            return "Création du livre";
        }
        else {

            return "Le livre existe déjà";
        }

    }

}
