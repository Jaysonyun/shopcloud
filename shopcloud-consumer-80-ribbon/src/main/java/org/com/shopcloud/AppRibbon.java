package org.com.shopcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AppRibbon 
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppRibbon.class, args);
    }
}
