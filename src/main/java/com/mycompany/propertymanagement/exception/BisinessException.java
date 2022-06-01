package com.mycompany.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BisinessException extends RuntimeException {

    private List<ErrorModel> errors;

    public BisinessException(List<ErrorModel>errors){
        this.errors = errors;
    }
}
