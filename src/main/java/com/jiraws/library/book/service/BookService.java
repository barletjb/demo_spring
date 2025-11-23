package com.jiraws.library.book.service;

import com.jiraws.library.book.model.exception.BookCreationException;
import com.jiraws.library.book.persistence.BookRepository;
import com.jiraws.library.book.model.BookEntity;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public String createBook(String bookName, Integer bookPages) throws BookCreationException {

        if(bookName == null || StringUtils.isBlank(bookName)) {
            throw new BookCreationException("Book name is null or empty");
        }

        if(bookPages == null || bookPages <= 0) {
            throw new BookCreationException("Le nombre de pages doit être supérieur à 0");
        }

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

            throw new BookCreationException("Le livre existe déjà");
        }

    }

}
