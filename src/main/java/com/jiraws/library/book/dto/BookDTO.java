package com.jiraws.library.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

        @NotNull @NotBlank
        private String bookName;

        @NotNull
        private Integer bookPages;

    }
}
