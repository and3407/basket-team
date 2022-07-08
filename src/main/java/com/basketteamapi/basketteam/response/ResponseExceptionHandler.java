package com.basketteamapi.basketteam.response;

import com.basketteamapi.basketteam.components.player.exceptions.PlayerNotFoundException;
import com.basketteamapi.basketteam.components.team.exception.TeamSizeException;
import com.basketteamapi.basketteam.components.team.exception.TeamSizeNotFoundException;
import com.basketteamapi.basketteam.components.user.exceptions.UserNameIsBusyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = {
            PlayerNotFoundException.class,
            UserNameIsBusyException.class,
            TeamSizeNotFoundException.class
    })
    protected ResponseEntity<Object> handlerNotFoundEntityException(RuntimeException exception) {
        ApiResponse response = new ApiResponse (
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage() + ", (" + exception.getClass() + ")"
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            TeamSizeException.class,
    })
    protected ResponseEntity<Object> handlerBadRequestException(RuntimeException exception) {
        ApiResponse response = new ApiResponse (
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage() + ", (" + exception.getClass() + ")"
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
