package com.webserver.shoppingmall.member.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceDuplicatedException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceDuplicatedException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("resource duplicated! resourceName :%s, fieldName: %s, fieldValue :%s",
                resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
