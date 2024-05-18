package com.neog.helloproject.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfigurations {

    @Value("${resttemplate.connection.timeout}")
    private int connectionTimeout;

    @Value("${resttemplate.read.timeout}")
    private int readTimeout;

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate(createClientHttpRequestFactory());
    }

    public ClientHttpRequestFactory createClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        System.out.println("connectionTimeout :: "+connectionTimeout);
        System.out.println("readTimeout:: "+readTimeout);
        factory.setConnectTimeout(connectionTimeout); // sets the maximum time to wait for establishing a connection
        factory.setReadTimeout(readTimeout);// sets the maximum time to wait for a response
        return factory;
    }
}
