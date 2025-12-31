package net.irq3.blog.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Result<O,E> (O o, E e, @JsonIgnore HttpStatus status) {
    public static <O, E> Result<O, E> resultOk(O value) {
        return new Result<>(value, null, HttpStatus.OK);
    }

    public static <O, E> Result<O, E> resultBadRequest(E value) {
        return new Result<>(null, value, HttpStatus.BAD_REQUEST);
    }

    public static <O, E> Result<O, E> resultError(E value) {
        return new Result<>(null, value, HttpStatus.BAD_REQUEST);
    }

    public static <O, E> Result<O, E> resultCustom(O value, HttpStatus status) {
        return new Result<>(value, null, status);
    }

    public boolean isOk() {
        return e == null;
    }
}
