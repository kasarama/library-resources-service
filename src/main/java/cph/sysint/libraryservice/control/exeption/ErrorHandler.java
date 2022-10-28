package cph.sysint.libraryservice.control.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ExceptionDto> handleAccessDeniedException(NotFoundException notFoundException) {
        ExceptionDto errorDto = new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), notFoundException.getMessage());
        return new ResponseEntity<ExceptionDto>(
                errorDto, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
