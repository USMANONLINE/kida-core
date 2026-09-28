package com.kidacore.server.dtos.response;

import lombok.Data;

@Data
public class BaseHttpRespData<T> extends BaseHttpResp {
    private T data;
}
