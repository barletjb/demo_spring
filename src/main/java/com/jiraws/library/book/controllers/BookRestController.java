package com.jiraws.library.book.controllers;

import com.jiraws.library.book.dto.BookDTO;
import com.jiraws.library.book.model.BookEntity;
import com.jiraws.library.book.model.exception.BookCreationException;
import com.jiraws.library.book.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO.PostOutput createBook(@Valid @RequestBody BookDTO.PostInput input) throws BookCreationException {

        log.info(input.getBookName());
        log.info(String.valueOf(input.getBookPages()));

        BookEntity newBook = bookService.createBook(input.getBookName(), input.getBookPages());

        return BookDTO.PostOutput.builder()
                .id(newBook.getId())
                .bookName(newBook.getName())
                .bookPages(newBook.getPages())
                .build();
    }

}
