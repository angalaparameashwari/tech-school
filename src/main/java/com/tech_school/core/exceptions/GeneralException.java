package com.tech_school.core.exceptions;

import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private String msgCode;

    private String httpCode;

    public GeneralException(String code){
        this.msgCode = code;
    }
}
