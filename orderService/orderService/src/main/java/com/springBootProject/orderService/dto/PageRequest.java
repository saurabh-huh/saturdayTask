package com.springBootProject.orderService.dto;

import lombok.Data;

@Data
public class PageRequest {
    private int page;
    private int size;
}
