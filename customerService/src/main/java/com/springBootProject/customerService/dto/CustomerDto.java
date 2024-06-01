package com.springBootProject.customerService.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String phone_number;
}
