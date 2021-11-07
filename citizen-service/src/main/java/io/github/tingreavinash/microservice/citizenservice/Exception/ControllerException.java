package io.github.tingreavinash.microservice.citizenservice.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ControllerException extends RuntimeException{
    private String errorCode;
    private String description;

    public ControllerException(String errorCode, String description) {
        super();
        this.errorCode = errorCode;
        this.description = description;
    }

    public ControllerException() {
        super();
    }
}
