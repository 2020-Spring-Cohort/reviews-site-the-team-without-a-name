package org.wecancodeit.reviews.storage;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Object message) {
    }
}
