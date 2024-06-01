package com.springBootProject.customerService.dto;

import lombok.Data;

@Data
public class PageRequest {
    private int page;
    private int size;
}
