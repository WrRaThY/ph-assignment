package priv.rdo.ph.common.errors;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
class ValidationNotPassedHandler {

    @ExceptionHandler
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    ErrorResponse handle(MethodArgumentNotValidException e, ServletWebRequest request) {
        return ErrorResponse.of(
                UNPROCESSABLE_ENTITY,
                request.getRequest().getRequestURI(),
                e.getMessage()
        );
    }
}
