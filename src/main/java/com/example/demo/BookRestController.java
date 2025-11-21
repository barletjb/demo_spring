package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/book")
    public String getBook(@RequestParam String bookName, @RequestParam Integer bookPages) {

        log.info(bookName);
        log.info(bookPages.toString());

        return bookService.createBook(bookName, bookPages);

    }

}
