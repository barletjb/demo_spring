package com.jiraws.library.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BookDTO {


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class PostInput {

        private String bookName;
        private Integer bookPages;

    }
}
