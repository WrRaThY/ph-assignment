package priv.rdo.ph.common.errors;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
class EntityNotFoundExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    ErrorResponse handle(EntityNotFoundException e, ServletWebRequest request) {
        return ErrorResponse.of(
                NOT_FOUND,
                request.getRequest().getRequestURI(),
                e.getMessage()
        );
    }
}
