package com.payment.common.vo;

import com.payment.common.enums.ExceptionEnums;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;
    public ExceptionResult(ExceptionEnums em){
        this.status = em.getCode();
        this.message = em.getMsg();
        timestamp = System.currentTimeMillis();
    }
}
