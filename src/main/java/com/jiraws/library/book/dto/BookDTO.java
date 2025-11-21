package com.jiraws.library.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BookDTO {


    @AllArgsConstructor
    @Data
    @Builder
    public static class PostInput {

        String bookName;
        Integer bookPages;

    }
}
