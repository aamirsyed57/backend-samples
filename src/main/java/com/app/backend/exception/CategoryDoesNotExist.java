package com.app.backend.exception;

public class CategoryDoesNotExist extends RuntimeException{
    public CategoryDoesNotExist(Long categoryId) {
        super(String.format("Category with id %d does not exist", categoryId));
    }
}
