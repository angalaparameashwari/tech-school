package com.tech_school.core.exceptions;
import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    // name of the resource
    private String name ;

    // identifier/handle of the resource
    private String id;

    public ResourceNotFoundException(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Object[] getArgs(){
        return new Object[]{name,id};
    }

}

