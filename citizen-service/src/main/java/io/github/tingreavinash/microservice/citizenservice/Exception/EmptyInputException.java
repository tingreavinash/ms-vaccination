package io.github.tingreavinash.microservice.citizenservice.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmptyInputException extends RuntimeException {
    private String errorCode;
    private String description;

    public EmptyInputException(String errorCode, String description) {
        super();
        this.errorCode = errorCode;
        this.description = description;
    }

    public EmptyInputException() {
        super();
    }
}
