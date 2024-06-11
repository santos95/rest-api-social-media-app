package com.sortiz.social_media_app.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDetails {

    private LocalDateTime cratedDate;
    private String message;
    private String details;

    public ErrorDetails() {
    }

    public ErrorDetails(LocalDateTime cratedDate, String message, String details) {
        this.cratedDate = cratedDate;
        this.message = message;
        this.details = details;
    }
}
