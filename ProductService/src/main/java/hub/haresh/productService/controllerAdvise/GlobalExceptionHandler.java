package hub.haresh.productService.controllerAdvise;

import hub.haresh.productService.dto.ErrorDTO;
import hub.haresh.productService.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@SuppressWarnings("unused")
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ErrorDTO handleNullPointerException() {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setMessage("Something went wrong");
        errorDto.setStatus("FAILURE");

        return errorDto;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException exception) {

        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setStatus("FAILURE");
        errorDto.setMessage(exception.getMessage());

        return new ResponseEntity<>(errorDto,
                HttpStatus.NOT_FOUND);
    }
}
