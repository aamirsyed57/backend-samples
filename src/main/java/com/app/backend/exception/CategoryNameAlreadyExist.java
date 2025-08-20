package com.app.backend.exception;

public class CategoryNameAlreadyExist extends RuntimeException{
    public CategoryNameAlreadyExist(String name) {
        super(String.format("category name already exist: %s", name));
    }
}
