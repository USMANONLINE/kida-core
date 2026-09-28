package com.kidacore.server.dtos.response;

import lombok.Data;

@Data
public class BaseHttpResp {
    private boolean successful;
    private String description;
}