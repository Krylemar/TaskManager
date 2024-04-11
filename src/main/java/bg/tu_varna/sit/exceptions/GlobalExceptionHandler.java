package bg.tu_varna.sit.exceptions;

import bg.tu_varna.sit.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<ErrorDetails> handleTaskNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails err = new ErrorDetails(new Date(), ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
