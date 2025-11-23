package com.jiraws.library.book.controllers;

import com.jiraws.library.book.dto.BookDTO;
import com.jiraws.library.book.model.exception.BookCreationException;
import com.jiraws.library.book.service.BookService;
import jakarta.validation.Valid;
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
        return "Ok Get";
    }


    @PostMapping
    public String createBook(@Valid @RequestBody BookDTO.PostInput input) throws BookCreationException {

        log.info(input.getBookName());
        log.info(String.valueOf(input.getBookPages()));

        return bookService.createBook(input.getBookName(), input.getBookPages());
    }

}
