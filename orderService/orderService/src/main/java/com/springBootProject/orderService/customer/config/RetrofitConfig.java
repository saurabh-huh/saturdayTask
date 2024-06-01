package com.springBootProject.orderService.customer.config;

import com.springBootProject.orderService.customer.client.CustomerClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

//
@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl("http://localhost:8081/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        return new Retrofit.Builder()
//                .baseUrl("http://localhost:8081/") // URL of the Customer service
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(new OkHttpClient.Builder().build())
//                .build();
    }

    @Bean
    public CustomerClient customerClient(Retrofit retrofit){
        return retrofit.create(CustomerClient.class);
    }
}
