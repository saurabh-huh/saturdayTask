package com.springBootProject.orderService.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private UUID id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String phone_number;
}
