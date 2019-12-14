package com.payment.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    PRICE_CAN_NOT_BE_NULL(400,"价格不能为空"),
    ORDER_INFO_NOT_FOUND(404,"对象信息未找到"),
    ;
    private int code;
    private String msg;
}
