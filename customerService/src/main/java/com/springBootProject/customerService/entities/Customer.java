package com.springBootProject.customerService.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;


@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 3,max = 20)
    private String first_name;
    @NotBlank
    @Size(min = 3,max = 20)
    private String last_name;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Enter valid email Id:")
    private String email_id;

    @Pattern(regexp = "^[5-9][0-9]{9}$",message = "Enter valid Phone number")
    private String phone_number;
}

