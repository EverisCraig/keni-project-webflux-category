package com.craig.keniprojectwebfluxcategory.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class I18AbleException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    protected final transient Object[] args;

    public I18AbleException(String key, Object... args2) {
        super(key);
        args = args2;
    }
}
