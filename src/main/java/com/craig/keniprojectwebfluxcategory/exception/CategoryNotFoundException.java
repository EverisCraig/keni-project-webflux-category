package com.craig.keniprojectwebfluxcategory.exception;

import com.craig.keniprojectwebfluxcategory.util.I18AbleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryNotFoundException extends I18AbleException {
    public CategoryNotFoundException(String key, Object... args2) {
        super(key, args2);
    }
}
