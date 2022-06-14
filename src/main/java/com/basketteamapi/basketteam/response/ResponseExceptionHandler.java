package com.basketteamapi.basketteam.response;

import com.basketteamapi.basketteam.components.user.exceptions.UserNameIsBusyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(UserNameIsBusyException.class)
    protected ResponseEntity<Object> userNameIsBusyHandler(
        RuntimeException exception,
        WebRequest request
    ) {
        ApiResponse response = new ApiResponse (
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
