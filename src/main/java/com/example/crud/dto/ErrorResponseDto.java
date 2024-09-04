package com.example.crud.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponseDto {

    @Schema(description = "Error message")
    private String message;

    public ErrorResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
