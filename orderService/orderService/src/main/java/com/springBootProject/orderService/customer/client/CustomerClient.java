package com.springBootProject.orderService.customer.client;

import com.springBootProject.orderService.customer.model.CustomerDto;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

@Component
public interface CustomerClient {

    @GET("/api/v1/customers/{id}")
    Call<CustomerDto> getCustomerById(@Path("id") UUID id);
}
