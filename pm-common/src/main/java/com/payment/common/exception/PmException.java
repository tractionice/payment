package com.payment.common.exception;

import com.payment.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PmException extends RuntimeException{
    private ExceptionEnums exceptionEnums;
}
