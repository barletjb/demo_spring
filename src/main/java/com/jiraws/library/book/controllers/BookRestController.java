package com.jiraws.library.book.controllers;

import com.jiraws.library.book.dto.BookDTO;
import com.jiraws.library.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    @GetMapping
    public String getBook(@RequestParam String bookName, @RequestParam Integer bookPages) {

//        log.info(bookName);
//        log.info(bookPages.toString());
//
//        return bookService.createBook(bookName, bookPages);

        return "Ok Get";
    }


    @PostMapping
    public String createBook(@RequestBody BookDTO.PostInput input) {

        log.info(input.getBookName());
        log.info(input.getBookPages().toString());

        return bookService.createBook(input.getBookName(), input.getBookPages());
    }

}
