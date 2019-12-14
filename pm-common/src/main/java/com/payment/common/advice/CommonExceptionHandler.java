package com.payment.common.advice;

import com.payment.common.enums.ExceptionEnums;
import com.payment.common.exception.PmException;
import com.payment.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(PmException.class)
    public ResponseEntity<ExceptionResult> handlerException(PmException e){
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ExceptionResult(e.getExceptionEnums()));
    }
}
