package io.github.tingreavinash.microservice.citizenservice.Exception;

import lombok.*;

@Getter
@Setter
public class BusinessException extends RuntimeException{
    private String errorCode;
    private String description;

    public BusinessException(String errorCode, String description) {
        super();
        this.errorCode = errorCode;
        this.description = description;
    }

    public BusinessException() {
        super();
    }
}
