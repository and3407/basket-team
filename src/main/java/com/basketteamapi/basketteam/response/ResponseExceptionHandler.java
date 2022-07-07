package com.basketteamapi.basketteam.response;

import com.basketteamapi.basketteam.components.player.exceptions.PlayerNotFoundException;
import com.basketteamapi.basketteam.components.team.exception.FileTeamSizeNotFoundException;
import com.basketteamapi.basketteam.components.team.exception.TeamSizeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = {
            PlayerNotFoundException.class,
            UsernameNotFoundException.class,
            FileTeamSizeNotFoundException.class
    })
    protected ResponseEntity<Object> handlerNotFoundEntityException(RuntimeException exception) {
        ApiResponse response = new ApiResponse (
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            TeamSizeException.class,
    })
    protected ResponseEntity<Object> handlerBadRequestException(RuntimeException exception) {
        ApiResponse response = new ApiResponse (
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
